CREATE TABLE User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone_number VARCHAR(15),
    role VARCHAR(20) DEFAULT 'LIBRARIAN'
);
CREATE TABLE Author (
    author_id INT AUTO_INCREMENT PRIMARY KEY,
    author_name VARCHAR(100) NOT NULL
);
CREATE TABLE Category (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL,
    category_description VARCHAR(255)
);
CREATE TABLE Publisher (
    publisher_id INT AUTO_INCREMENT PRIMARY KEY,
    publisher_name VARCHAR(100) NOT NULL,
    publisher_address VARCHAR(255),
    publisher_city VARCHAR(50),
    publisher_email VARCHAR(100),
    publisher_phone VARCHAR(15),
    website VARCHAR(100)
);
CREATE TABLE Book (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    isbn VARCHAR(20) UNIQUE,
    title VARCHAR(150) NOT NULL,
    author_id INT,
    category_id INT,
    publisher_id INT,
    edition VARCHAR(20),
    publication_year YEAR,
    language VARCHAR(30),
    rack_number VARCHAR(20),
    price DECIMAL(10,2),
    total_copies INT NOT NULL DEFAULT 1,
    available_copies INT NOT NULL DEFAULT 1,
    availability_status VARCHAR(20) DEFAULT 'AVAILABLE',
    description TEXT,
    FOREIGN KEY (author_id)
        REFERENCES Author(author_id),
    FOREIGN KEY (category_id)
        REFERENCES Category(category_id),
    FOREIGN KEY (publisher_id)
        REFERENCES Publisher(publisher_id)
);
CREATE TABLE Member (
    member_id INT AUTO_INCREMENT PRIMARY KEY,
    member_name VARCHAR(100) NOT NULL,
    father_name VARCHAR(100),
    gender VARCHAR(10),
    date_of_birth DATE,
    course_or_class VARCHAR(50),
    department VARCHAR(50),
    semester INT,
    address VARCHAR(255),
    city VARCHAR(50),
    state VARCHAR(50),
    phone_number VARCHAR(15),
    email VARCHAR(100),
    membership_date DATE NOT NULL
);
CREATE TABLE IssueRecord (
    issue_id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT NOT NULL,
    member_id INT NOT NULL,
    user_id INT NOT NULL,
    issue_date DATE NOT NULL,
    due_date DATE NOT NULL,
    remarks VARCHAR(255),
    FOREIGN KEY (book_id)
        REFERENCES Book(book_id),
    FOREIGN KEY (member_id)
        REFERENCES Member(member_id),
    FOREIGN KEY (user_id)
        REFERENCES User(user_id)
);
CREATE TABLE ReturnRecord (
    return_id INT AUTO_INCREMENT PRIMARY KEY,
    issue_id INT NOT NULL UNIQUE,
    return_date DATE NOT NULL,
    days_late INT DEFAULT 0,
    fine_amount DECIMAL(10,2) DEFAULT 0.00,
    remarks VARCHAR(255),
    FOREIGN KEY (issue_id)
        REFERENCES IssueRecord(issue_id)
);
CREATE TABLE Fine (
    fine_id INT AUTO_INCREMENT PRIMARY KEY,
    return_id INT NOT NULL,
    member_id INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    fine_reason VARCHAR(255),
    payment_status VARCHAR(20) DEFAULT 'Pending',
    payment_date DATE,
    collected_by INT,
    FOREIGN KEY (return_id)
        REFERENCES ReturnRecord(return_id),
    FOREIGN KEY (member_id)
        REFERENCES Member(member_id),
    FOREIGN KEY (collected_by)
        REFERENCES User(user_id)
);