SELECT
    b.book_id,
    b.title,
    a.author_name,
    c.category_name,
    p.publisher_name
FROM Book b
JOIN Author a ON b.author_id = a.author_id
JOIN Category c ON b.category_id = c.category_id
JOIN Publisher p ON b.publisher_id = p.publisher_id;