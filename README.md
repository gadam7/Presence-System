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
- `GET /api/users/{id}` - Get user details by ID ✅
- `GET /api/users` - Get all users ✅
- `PUT /api/users/{id}` - Update user details ✅
- `DELETE /api/users/{id}` - Delete user by ID ✅
- `POST /api/lessons` - Create a new lesson - To be implemented ✅
- `GET /api/lessons/{id}` - Get lesson details by ID - To be implemented ✅
- `GET /api/lessons` - Get all lessons - To be implemented ✅
- `PUT /api/lessons/{id}` - Update lesson details - To be implemented ❌
- `DELETE /api/lessons/{id}` - Delete lesson by ID - To be implemented ❌