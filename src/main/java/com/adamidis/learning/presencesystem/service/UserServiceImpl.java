package com.adamidis.learning.presencesystem.service;

import com.adamidis.learning.presencesystem.dto.AuthorityDto;
import com.adamidis.learning.presencesystem.dto.UserDto;
import com.adamidis.learning.presencesystem.model.Authority;
import com.adamidis.learning.presencesystem.model.Instructor;
import com.adamidis.learning.presencesystem.model.Role;
import com.adamidis.learning.presencesystem.model.User;
import com.adamidis.learning.presencesystem.repository.AuthorityRepository;
import com.adamidis.learning.presencesystem.repository.InstructorRepository;
import com.adamidis.learning.presencesystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final InstructorRepository instructorRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                            AuthorityRepository authorityRepository,
                            InstructorRepository instructorRepository,
                            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.instructorRepository = instructorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto registerUser(UserDto userDto) {
        // Implementation for registering a user
        User tempUser = new User();
        tempUser.setUsername(userDto.getUsername());
        tempUser.setFirstName(userDto.getFirstName());
        tempUser.setLastName(userDto.getLastName());
        tempUser.setEmail(userDto.getEmail());
        tempUser.setPassword(passwordEncoder.encode(userDto.getPassword())); // Assuming UserDto has a password field
        User savedUser = userRepository.save(tempUser);

        Authority authority = new Authority();
        authority.setAuthority(Role.ROLE_USER); // Assign default role
        authority.setUser(savedUser);
        authorityRepository.save(authority);

        List<Authority> authorities = authorityRepository.findByUserId(savedUser.getId());
        return convertToDto(savedUser, authorities);
    }

    public List<UserDto> findAll() {
        return userRepository.findAll() // Fetches all users from the database
                .stream() // Starts a stream to process the list
                .map(user -> { // For each user, fetch their authorities and convert to DTO
                    List<Authority> authorities = authorityRepository.findByUserId(user.getId()); // Fetch authorities for the user
                    return convertToDto(user, authorities); // Convert user entity to UserDto including authorities
                })
                .collect(toList()); // Collects the results into a List<UserDto>
    }

    @Override
    public UserDto findById(Integer id) {
        User tempUser = userRepository.findById(id) // Fetch user by ID
                .orElseThrow(() -> new RuntimeException("Did not found user id - " + id)); // Throws exception if user not found
        List<Authority> authorities = authorityRepository.findByUserId(tempUser.getId()); // Fetch authorities for the user

        return convertToDto(tempUser, authorities); // Convert user entity to UserDto including authorities
    }

    @Override
    @Transactional
    public UserDto update(UserDto userDto) {
        if (userDto.getId() == null) { // Ensure the user ID is provided for update
            throw new RuntimeException("User id must not be null for update operation"); // Throws exception if ID is null
        }

        User existingUser = userRepository.findById(userDto.getId()) // Fetch existing user by ID
                .orElseThrow(() -> new RuntimeException("Did not found user id - " + userDto.getId())); // Throws exception if user not found

        existingUser.setUsername(userDto.getUsername()); // Update user fields
        existingUser.setFirstName(userDto.getFirstName()); // Update user fields
        existingUser.setLastName(userDto.getLastName()); // Update user fields
        existingUser.setEmail(userDto.getEmail()); // Update user fields

        // save changes to the user
        userRepository.save(existingUser); // Persist the updated user entity

        // update authorities if provided
        if (userDto.getAuthorities() != null) { // Check if authorities are provided in the DTO
            // remove existing authorities
            authorityRepository.deleteByUserId(existingUser.getId()); // Delete existing authorities for the user

            // add new authorities
            for (AuthorityDto authority : userDto.getAuthorities()) { // Iterate over the new authorities
                Authority newAuthority = new Authority(); // Create a new Authority entity
                newAuthority.setUser(existingUser); // Set the user for the authority
                newAuthority.setAuthority(authority.getAuthority()); // Set the authority role
                authorityRepository.save(newAuthority); // Save the new authority
            }
        }

        // return the updated user DTO with new authorities
        List<Authority> updatedAuthorities = authorityRepository.findByUserId(existingUser.getId()); // Fetch updated authorities
        return convertToDto(existingUser, updatedAuthorities); // Convert to UserDto and return
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        User tempUser = userRepository.findById(id) // Fetch user by ID
                .orElseThrow(() -> new RuntimeException("Did not found user id - " + id)); // Throws exception if user not found

        // 1. remove associated authorities
        authorityRepository.deleteByUserId(tempUser.getId()); // Delete associated authorities

        // 2. clear lessons if the user is an instructor
        Instructor instructor = instructorRepository.findByUser(tempUser);
        if (instructor != null) {
            instructor.getLessons().clear();
            instructorRepository.delete(instructor);
        }

        // 3. delete the user
        userRepository.delete(tempUser); // Delete the user entity

    }

    // --- Helper Method to Convert Entity to DTO ---
    private UserDto convertToDto(User savedUser, List<Authority> authorities) {
        UserDto userDto = new UserDto();
        userDto.setId(savedUser.getId());
        userDto.setUsername(savedUser.getUsername());
        userDto.setFirstName(savedUser.getFirstName());
        userDto.setLastName(savedUser.getLastName());
        userDto.setEmail(savedUser.getEmail());
        userDto.setAuthorities(
                authorities.stream()
                        .map(this::convertToDto)
                        .collect(toList())
        );
        userDto.setPassword(null); // Do not expose password
        return userDto;
    }

    private AuthorityDto convertToDto(Authority authority) {
        AuthorityDto authorityDto = new AuthorityDto();
        authorityDto.setId(authority.getId());
        authorityDto.setAuthority(authority.getAuthority());
        return authorityDto;
    }
}
