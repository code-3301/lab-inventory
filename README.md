# DIU Lab Inventory System

Welcome to the DIU Lab Inventory System!
This web-based system is designed to efficiently manage lab equipment, student records, and borrowing activities at DIU (Daffodil International University).
## Features

Student Management
 - Add, update, delete, and view student records.
Category Management
 - Organize equipment into categories.
Equipment Management
- Add, update, delete, and track equipment.
Borrow Record Management
- Record when equipment is borrowed and returned.
- Monitor active and past borrow records.
Admin Dashboard
- Visual statistics and overview of the system.
Authentication
- Admin login system with secure password management (Spring Security).
Responsive UI
- Simple and user-friendly design.

## Technologies Used

   - Java 17+

  - Spring Boot (MVC, Data JPA, Security)

  - Thymeleaf (HTML templating engine)

 - Hibernate/JPA (ORM for database)

 - MySQL (Database)

 - Spring Security (Authentication)

-  Maven (Build tool)

##  Project Structure
```
├── src/main/java
│   ├── controller
│   │   ├── AdminController
│   │   ├── StudentController
│   │   ├── CategoryController
│   │   ├── EquipmentController
│   │   └── BorrowRecordController
│   ├── model (entities)
│   │   ├── Student
│   │   ├── Category
│   │   ├── Equipment
│   │   └── BorrowRecord
│   ├── repository
│   │   ├── StudentRepository
│   │   ├── CategoryRepository
│   │   ├── EquipmentRepository
│   │   └── BorrowRecordRepository
│   ├── service
│   │   ├── StudentService
│   │   ├── CategoryService
│   │   ├── EquipmentService
│   │   └── BorrowRecordService
│   └── config
│       └── SecurityConfig
├── src/main/resources
│   ├── templates (Thymeleaf HTML)
│   ├── static (CSS, JS)
│   └── application.properties
└── pom.xml
```

## ⚙ Installation & Setup

Clone the repository
```bash
git clone https://github.com/yourusername/diu-lab-inventory-system.git
cd diu-lab-inventory-system
```
Set up the database
Create a MySQL database:
```sql
CREATE DATABASE diu_lab_inventory;
```
Configure `application.properties`
Update your database credentials:

```
spring.datasource.url=jdbc:mysql://localhost:3306/diu_lab_inventory
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
```
Run the application

```bash
 ./mvnw spring-boot:run
```

## Access the system
Open your browser and go to:
```url
http://localhost:8080/lab-inventoty/admin/login
```

# Default Admin Credentials

(These can be configured inside the database or via the initial user service.)

```
Username	Password
admin	      admin123
```

## Future Improvements

- Pagination for student and equipment lists

- Search and filter features

- Email notifications for overdue equipment

- Role-based access control (Admin vs Assistant)

- UI improvements with Bootstrap/TailwindCSS

## Acknowledgements
Special thanks to DIU for inspiring this project and to the open-source community for providing the tools to build it.
