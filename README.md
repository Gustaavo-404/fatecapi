# 📚 Student Management API

This project is a **Student Management API** developed as part of a classroom exercise. The application provides CRUD functionalities to manage student data such as code, name, course, and CPF. 

It was built using **Spring Boot** with **Maven** as the build tool, making it simple and robust for educational purposes.

---

## 🚀 Features

- **Create Students**: Add new students to the system.
- **Read Students**: Retrieve the list of all students or a specific student by their code.
- **Update Students**: Modify student details.
- **Delete Students**: Remove students from the system.

---

## 🛠️ Technologies Used

- **Java**: Programming language.
- **Spring Boot**: Framework for building the API.
- **Maven**: Build and dependency management tool.
- **RESTful API**: Architecture for the endpoints.

---

## 📁 Endpoints

### 1. Retrieve all students
**GET** `/alunos`  
Response: Returns the list of all students.

### 2. Retrieve a student by ID
**GET** `/alunos/{codigo}`  
Path variable: `codigo` - ID of the student  
Response: Returns the student details if found, otherwise `404`.

### 3. Create a new student
**POST** `/alunos`  
Request body:
```json
{
  "nome": "Student Name",
  "curso": "Course Name",
  "cpf": "CPF"
}
```
Response: Returns the created student with a generated ID.
Error: 409 if the CPF already exists.

### 4. Update a student
PUT /alunos/{codigo}
Path variable: codigo - ID of the student
Request body:

```json
{
  "nome": "Updated Name",
  "curso": "Updated Course",
  "cpf": "Updated CPF"
}
```
Response: Returns the updated student details.
Error: 404 if the student is not found.

### 5. Delete a student
DELETE /alunos/{codigo}
Path variable: codigo - ID of the student
Response: Deletes the student if found.
Error: 204 if the student is successfully removed.

## 📝 How to Run the Project

1. **Clone the repository.**
2. **Open the project** in an IDE such as **Eclipse** or **IntelliJ**.
3. Ensure you have **Java 17+** and **Maven** installed.
4. Run the application using the command:
   ```bash
   mvn spring-boot:run
Access the API at http://localhost:8080.
## 📜 Notes
This project was developed as an educational exercise during class and showcases the use of Spring Boot for creating RESTful APIs. It demonstrates basic CRUD operations and simple in-memory storage using a List. No database integration was implemented in this version.

## 🧪 Testing the API

This API was tested using the **Thunder Client** extension for **VS Code**. Thunder Client provides a simple and efficient way to test RESTful APIs directly within the VS Code editor, making it easy to send requests and view responses during development.
