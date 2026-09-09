# Library Management System

A desktop Library Management System built with **Java Swing** and **MySQL**, following a layered architecture (Controller → Service → DAO → Model).

## Features

- **Admin Login** — secure login for library staff/admin
- **Dashboard** — overview of library activity
- **Book Management** — add, update, delete, and search books
- **Member Management** — manage library member records
- **Issue Book** — issue books to members
- **Return Book** — process book returns
- **Fine Management** — calculate and track overdue fines
- **User Management** — manage admin/staff user accounts

## Tech Stack

- **Language:** Java
- **UI:** Java Swing
- **Database:** MySQL
- **Architecture:** Layered (Controller / Service / DAO / Model / View)

## Project Structure

```
src/
├── app/            # Application entry point
├── controller/      # Coordinates between service and view
├── dao/              # Database access (CRUD operations)
├── database/         # DB connection handling
├── model/            # Data models / entities
├── service/          # Business logic
├── util/             # Helper/utility classes
├── view/             # Main UI screens (e.g. Login)
└── view/panels/      # Feature panels (Book, Member, Issue, Return, Fine, User, Dashboard)
sql/                  # Database schema
```

## Setup

1. Clone the repository
2. Create the database using the schema in the `sql/` folder
3. In the project root, create a `config.properties` file (see `config.properties.example`) with your local MySQL credentials:
   ```
   db.url=jdbc:mysql://localhost:3306/library_management
   db.username=your_username
   db.password=your_password
   ```
4. Import the project into Eclipse (or any Java IDE)
5. Run the project from `app/Main.java`

## Notes

- Database credentials are kept out of version control via `config.properties` (git-ignored). Use `config.properties.example` as a template.
