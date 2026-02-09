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
  ![Screenshot](src/main/resources/static/screenshots/POST_api_users.png)
- `GET /api/users/{id}` - Get user details by ID ✅
  ![Screenshot](src/main/resources/static/screenshots/GET_api_users_id.png)
- `GET /api/users` - Get all users ✅
  ![Screenshot](src/main/resources/static/screenshots/GET_api_users.png)
- `PUT /api/users/{id}` - Update user details ✅
  ![Screenshot](src/main/resources/static/screenshots/PUT_api_users_id.png)
- `DELETE /api/users/{id}` - Delete user by ID ✅
  ![Screenshot](src/main/resources/static/screenshots/DELETE_api_users_id.png)
- `POST /api/lessons` - Create a new lesson ✅
  ![Screenshot](src/main/resources/static/screenshots/POST_api_lessons.png)
- `GET /api/lessons/{id}` - Get lesson details by ID ✅
  ![Screenshot](src/main/resources/static/screenshots/GET_api_lessons_id.png)
- `GET /api/lessons` - Get all lessons ✅
  ![Screenshot](src/main/resources/static/screenshots/GET_api_lessons.png)
- `PUT /api/lessons/{id}` - Update lesson details ✅
  ![Screenshot](src/main/resources/static/screenshots/PUT_api_lessons_id.png)
- `DELETE /api/lessons/{id}` - Delete lesson by ID ✅
  ![Screenshot](src/main/resources/static/screenshots/DELETE_api_lessons_id.png)
- `GET /api/classrooms` - Get all classrooms ✅
  ![Screenshot](src/main/resources/static/screenshots/GET_api_classrooms.png)
- `POST /api/classrooms` - Create a new classroom ✅
  ![Screenshot](src/main/resources/static/screenshots/POST_api_classrooms.png)
- `GET /api/classrooms/{id}` - Get classroom details by ID - work in progress ❌

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