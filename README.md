🎓 Student Management System – Java JDBC Project
This is a simple console-based Student Management System developed using Core Java with JDBC connectivity to a MySQL database. The project follows a clean modular structure using MVC architecture — making it easy to maintain and understand.

✅ Features
Add new student details

Update existing student data

Delete a student by ID

Display all student records

Follows a 3-layer architecture:

Controller (handles user interaction)

Service (contains business logic)

DAO (performs database operations)

🧱 Technologies Used
Technology	Description
Java	Core Java (JDK 8 or above)
JDBC	Java Database Connectivity
MySQL	Database
Console UI	Command-line menu system

🧩 Project Structure
```
StudentManagement/
│
├── controller/             // Takes input from user
│   └── StudentController.java
│
├── service/                // Business logic layer
│   └── StudentService.java
│
├── dao/                    // Database operations
│   └── StudentDAO.java
│
├── model/                  // Student entity
│   └── Student.java
│
├── DBConnection.java       // MySQL connection utility
└── README.md               // Project documentation
```
