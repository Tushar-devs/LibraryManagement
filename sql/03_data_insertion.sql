INSERT INTO User
(username, password, full_name, email, phone_number, role)
VALUES

('admin',
 'admin123',
 'Library Administrator',
 'admin@library.com',
 '9876543210',
 'ADMIN'),

('librarian',
 'lib123',
 'Aman Verma',
 'librarian@library.com',
 '9876543211',
 'LIBRARIAN');
 INSERT INTO Author (author_name)
VALUES
('Herbert Schildt'),
('Joshua Bloch'),
('Robert C. Martin'),
('Kathy Sierra'),
('Abraham Silberschatz');
INSERT INTO Category
(category_name, category_description)
VALUES

('Programming',
 'Books related to programming languages and coding'),

('Database',
 'Books related to DBMS, SQL and database design'),

('Software Engineering',
 'Books related to software development practices'),

('Computer Networks',
 'Books related to networking concepts and protocols'),

('Operating Systems',
 'Books related to operating system concepts');
 INSERT INTO Publisher
(
    publisher_name,
    publisher_address,
    publisher_city,
    publisher_email,
    publisher_phone,
    website
)
VALUES

(
    'McGraw Hill',
    '245 Park Avenue',
    'New York',
    'contact@mcgrawhill.com',
    '1111111111',
    'www.mheducation.com'
),

(
    'Pearson',
    '80 Strand',
    'London',
    'support@pearson.com',
    '2222222222',
    'www.pearson.com'
),

(
    'O Reilly Media',
    '1005 Gravenstein Highway North',
    'Sebastopol',
    'help@oreilly.com',
    '3333333333',
    'www.oreilly.com'
),

(
    'Wiley',
    '111 River Street',
    'Hoboken',
    'info@wiley.com',
    '4444444444',
    'www.wiley.com'
),

(
    'Cengage Learning',
    '200 Pier Four Boulevard',
    'Boston',
    'support@cengage.com',
    '5555555555',
    'www.cengage.com'
);
INSERT INTO Book
(
    isbn,
    title,
    author_id,
    category_id,
    publisher_id,
    edition,
    publication_year,
    language,
    rack_number,
    price,
    total_copies,
    available_copies,
    availability_status,
    description
)
VALUES

(
    '9781260547576',
    'Java The Complete Reference',
    1,
    1,
    1,
    '11th',
    2020,
    'English',
    'A1',
    950.00,
    5,
    5,
    'AVAILABLE',
    'Comprehensive guide to Java programming'
),

(
    '9780134685991',
    'Effective Java',
    2,
    1,
    2,
    '3rd',
    2018,
    'English',
    'A2',
    850.00,
    4,
    4,
    'AVAILABLE',
    'Best practices for writing high-quality Java code'
),

(
    '9780132350884',
    'Clean Code',
    3,
    3,
    3,
    '1st',
    2008,
    'English',
    'A3',
    750.00,
    3,
    3,
    'AVAILABLE',
    'Handbook of agile software craftsmanship'
),

(
    '9780596009205',
    'Head First Java',
    4,
    1,
    4,
    '2nd',
    2005,
    'English',
    'A4',
    700.00,
    6,
    6,
    'AVAILABLE',
    'Beginner-friendly introduction to Java'
),

(
    '9780073523323',
    'Database System Concepts',
    5,
    2,
    5,
    '6th',
    2010,
    'English',
    'B1',
    1200.00,
    2,
    2,
    'AVAILABLE',
    'Fundamental concepts of database systems'
);
INSERT INTO Member
(
    member_name,
    father_name,
    gender,
    date_of_birth,
    course_or_class,
    department,
    semester,
    address,
    city,
    state,
    phone_number,
    email,
    membership_date
)
VALUES

(
    'Tushar Sharma',
    'Rajesh Sharma',
    'Male',
    '2002-04-15',
    'MCA',
    'Computer Applications',
    2,
    'Aliganj',
    'Lucknow',
    'Uttar Pradesh',
    '9000000001',
    'tushar@example.com',
    '2026-06-01'
),

(
    'Aman Gupta',
    'Rakesh Gupta',
    'Male',
    '2003-07-10',
    'MCA',
    'Computer Applications',
    2,
    'Gomti Nagar',
    'Lucknow',
    'Uttar Pradesh',
    '9000000002',
    'aman@example.com',
    '2026-06-01'
),

(
    'Priya Singh',
    'Arun Singh',
    'Female',
    '2003-02-18',
    'MCA',
    'Computer Applications',
    2,
    'Indira Nagar',
    'Lucknow',
    'Uttar Pradesh',
    '9000000003',
    'priya@example.com',
    '2026-06-02'
),

(
    'Rohit Verma',
    'Sanjay Verma',
    'Male',
    '2002-11-25',
    'MCA',
    'Computer Applications',
    2,
    'Hazratganj',
    'Lucknow',
    'Uttar Pradesh',
    '9000000004',
    'rohit@example.com',
    '2026-06-03'
),

(
    'Neha Mishra',
    'Vijay Mishra',
    'Female',
    '2003-05-12',
    'MCA',
    'Computer Applications',
    2,
    'Jankipuram',
    'Lucknow',
    'Uttar Pradesh',
    '9000000005',
    'neha@example.com',
    '2026-06-04'
);
INSERT INTO IssueRecord
(
    book_id,
    member_id,
    user_id,
    issue_date,
    due_date,
    remarks
)
VALUES

(
    1,
    1,
    1,
    '2026-06-01',
    '2026-06-15',
    'Issued by admin'
),

(
    2,
    2,
    2,
    '2026-06-02',
    '2026-06-16',
    'Issued by librarian'
),

(
    3,
    3,
    1,
    '2026-06-03',
    '2026-06-17',
    'Issued by admin'
),

(
    4,
    4,
    2,
    '2026-06-04',
    '2026-06-18',
    'Issued by librarian'
),

(
    5,
    5,
    1,
    '2026-06-05',
    '2026-06-19',
    'Issued by admin'
);
INSERT INTO ReturnRecord
(
    issue_id,
    return_date,
    days_late,
    fine_amount,
    remarks
)
VALUES

(
    1,
    '2026-06-14',
    0,
    0.00,
    'Returned before due date'
),

(
    2,
    '2026-06-16',
    0,
    0.00,
    'Returned on due date'
),

(
    3,
    '2026-06-20',
    3,
    30.00,
    'Returned 3 days late'
),

(
    4,
    '2026-06-23',
    5,
    50.00,
    'Returned 5 days late'
),

(
    5,
    '2026-06-29',
    10,
    100.00,
    'Returned 10 days late'
);