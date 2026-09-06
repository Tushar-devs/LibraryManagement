SELECT
    i.issue_id,
    b.title,
    m.member_name,
    u.username,
    i.issue_date,
    i.due_date
FROM IssueRecord i
JOIN Book b ON i.book_id = b.book_id
JOIN Member m ON i.member_id = m.member_id
JOIN User u ON i.user_id = u.user_id;
