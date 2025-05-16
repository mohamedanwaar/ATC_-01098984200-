
# Event Booking System

## Overview
The **Event Booking System** is a modern, responsive, and user-friendly web application developed using **Spring Boot** and **Thymeleaf**. It allows users to explore, book, and manage events while providing administrators with tools to manage the events.

---

## Features

## 👥 User Features

- ✅ **User Authentication**: Register, login, and logout with role-based access.
- 📅 **View Events**: See available events with full details (name, date, location, image, description, and price).
- 💲 **Book Events**: Book available events securely.
- 📁 **Manage Bookings**: View and cancel previously booked events.

---

## 🛠️ Admin Features

- 🫮 **Dashboard**: Manage all events in the system.
- ➕ **Add Event**: Create new events with full detail.
- ✏️ **Edit Event**: Update event details at any time.
- ❌ **Delete Event**: Remove events from the system.

---

## Technologies Used

| Layer        | Technologies                             |
|--------------|------------------------------------------|
| Backend      | Java, Spring Boot                        |
| Frontend     | HTML5, CSS3, Bootstrap 5, Thymeleaf      |
| Database     | MySql                                    |                  
| Template     | Thymeleaf                                |
| Build Tool   | Maven                                    |

---

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com.example.bookingsystem/
│   │       ├── Config/
│   │       │   └── Config.java
│   │       ├── Controller/
│   │       │   ├── AdminController.java
│   │       │   ├── AuthController.java
│   │       │   ├── BookingController.java
│   │       │   ├── EventController.java
│   │       │   └── FilesController.java
│   │       ├── Entitys/
│   │       │   ├── Booking.java
│   │       │   ├── EventsEntity.java
│   │       │   ├── Role.java
│   │       │   └── UserEntity.java
│   │       ├── Repository/
│   │       │   ├── BookingRepo.java
│   │       │   ├── EventRepo.java
│   │       │   └── UserRepo.java
│   │       └── Service/
│   │           ├── BookingService.java
│   │           ├── EventService.java
│   │           └── UserService.java
│   ├── resources/
│   │   ├── static/                       # Static assets like CSS/JS
│   │   ├── templates/                    # Thymeleaf templates
│   │   │   ├── home.html
│   │   │   ├── login.html
│   │   │   ├── register.html
│   │   │   ├── myBookings.html
│   │   │   ├── adminDashboard.html
│   │   │   ├── adminAddPage.html
│   │   │   └── updatePage.html
│   │   └── application.properties        # App config
│   └── BookingSystemApplication.java     # Main class
└── test/                                  # Unit & Integration tests
```

---

## Getting Started

### Prerequisites
- Java 17+
- Maven
- MySQL database 

## ⚙️ Configuration & Setup

### 🛠️ Configure the Database

Edit your `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/event_booking
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
```
### Running the Application
```bash
# Clone the repository
git clone https://github.com/your-username/event-booking-system.git

# Navigate to the project directory
cd event-booking-system

# Run the application
mvn spring-boot:run
```

### Access Points
- User Homepage: `http://localhost:8080/home`
- Admin Dashboard: `http://localhost:8080/admin/dashboard`
- Login Page: `http://localhost:8080/login`


