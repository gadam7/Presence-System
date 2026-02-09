# Presence System

A Spring Boot backend for managing users, instructors, students,
courses, lessons and attendance data storage tracking.

---

## Features

- User Authentication and Roles (Admin, User, Student, Instructor)
- Instructor and Lesson Management atm
- Secure Password Storage with BCrypt
- Auditable Entities with Creation and Modification Timestamps
- RESTful API Endpoints for CRUD Operations
- Database seeding for testing and development (users and lessons atm)

---

## API Endpoints (✅ / ❌)

- `POST /api/users` - Register a new user ✅
  ![Screenshot](static/screenshots/GET_api_users.png)
- `GET /api/users/{id}` - Get user details by ID ✅
- `GET /api/users` - Get all users ✅
- `PUT /api/users/{id}` - Update user details ✅
- `DELETE /api/users/{id}` - Delete user by ID ✅
- `POST /api/lessons` - Create a new lesson ✅
- `GET /api/lessons/{id}` - Get lesson details by ID ✅
- `GET /api/lessons` - Get all lessons ✅
- `PUT /api/lessons/{id}` - Update lesson details - To be implemented ✅
- `DELETE /api/lessons/{id}` - Delete lesson by ID - To be implemented ✅

> Note: More endpoints for Instructors, Students, Courses, and Attendance will be added in future updates.

---

## Seeding Test Data

- The database is seeded on startup for a fresh/empty database:
    - Admin, Student (not yet - ❌), Instructor, User accounts
    - Sample Lessons
    - (See `DataSeeder.java` and seeding classes for details)

---

## Author

[<img src="https://avatars.githubusercontent.com/u/115570387?v=4" width="80" align="left" style="border-radius: 50%" alt="gadam7 avatar" />](https://github.com/gadam7)

**Georgios Adamidis**  
🌍 Kos, Greece  
👨‍💻 Java, Spring Boot developer  
[![GitHub Badge](https://img.shields.io/badge/-gadam7-181717?style=flat-square&logo=GitHub&logoColor=white&link=https://github.com/gadam7)](https://github.com/gadam7)
[![Email Badge](https://img.shields.io/badge/-g.adamidis1985@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:g.adamidis1985@gmail.com)](mailto:g.adamidis1985@gmail.com)

<br clear="left"/>