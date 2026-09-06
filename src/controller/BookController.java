package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Book;
import service.BookService;
import view.panels.BookPanel;

public class BookController {

    private BookPanel bookPanel;
    private BookService bookService;

    public BookController(BookPanel bookPanel) {

        this.bookPanel = bookPanel;
        this.bookService = new BookService();

        registerListeners();
        loadBooks();
    }

    // ===========================
    // Register Listeners
    // ===========================

    private void registerListeners() {

        bookPanel.getBtnAdd().addActionListener(e -> addBook());

        bookPanel.getBtnUpdate().addActionListener(e -> updateBook());

        bookPanel.getBtnDelete().addActionListener(e -> deleteBook());

        bookPanel.getBtnClear().addActionListener(e -> clearForm());
    }

    // ===========================
    // Add Book
    // ===========================

    private void addBook() {

        try {

            String isbn = bookPanel.getTxtIsbn().getText().trim();
            String title = bookPanel.getTxtTitle().getText().trim();

            int authorId = Integer.parseInt(
                    bookPanel.getTxtAuthorId().getText().trim());

            int categoryId = Integer.parseInt(
                    bookPanel.getTxtCategoryId().getText().trim());

            int publisherId = Integer.parseInt(
                    bookPanel.getTxtPublisherId().getText().trim());

            int totalCopies = Integer.parseInt(
                    bookPanel.getTxtTotalCopies().getText().trim());

            Book book = new Book();

            book.setIsbn(isbn);
            book.setTitle(title);
            book.setAuthorId(authorId);
            book.setCategoryId(categoryId);
            book.setPublisherId(publisherId);
            book.setTotalCopies(totalCopies);

            boolean success = bookService.addBook(book);

            if (success) {

                JOptionPane.showMessageDialog(
                        bookPanel,
                        "Book added successfully.");

                clearForm();
                loadBooks();

            } else {

                JOptionPane.showMessageDialog(
                        bookPanel,
                        "Failed to add book.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    bookPanel,
                    "Please enter valid numeric values for IDs and total copies.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ===========================
    // Update Book
    // ===========================

    private void updateBook() {

        try {

            int bookId = Integer.parseInt(
                    bookPanel.getTxtBookId().getText().trim());

            Book existingBook =
                    bookService.getBookById(bookId);

            if (existingBook == null) {

                JOptionPane.showMessageDialog(
                        bookPanel,
                        "Book not found.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            String isbn = bookPanel.getTxtIsbn().getText().trim();
            String title = bookPanel.getTxtTitle().getText().trim();

            int authorId = Integer.parseInt(
                    bookPanel.getTxtAuthorId().getText().trim());

            int categoryId = Integer.parseInt(
                    bookPanel.getTxtCategoryId().getText().trim());

            int publisherId = Integer.parseInt(
                    bookPanel.getTxtPublisherId().getText().trim());

            int totalCopies = Integer.parseInt(
                    bookPanel.getTxtTotalCopies().getText().trim());

            /*
             * Preserve the values controlled by the system.
             */
            int availableCopies =
                    existingBook.getAvailableCopies();

            if (totalCopies < availableCopies) {

                JOptionPane.showMessageDialog(
                        bookPanel,
                        "Total copies cannot be less than currently available copies.",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            existingBook.setIsbn(isbn);
            existingBook.setTitle(title);
            existingBook.setAuthorId(authorId);
            existingBook.setCategoryId(categoryId);
            existingBook.setPublisherId(publisherId);
            existingBook.setTotalCopies(totalCopies);

            boolean success =
                    bookService.updateBook(existingBook);

            if (success) {

                JOptionPane.showMessageDialog(
                        bookPanel,
                        "Book updated successfully.");

                clearForm();
                loadBooks();

            } else {

                JOptionPane.showMessageDialog(
                        bookPanel,
                        "Failed to update book.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    bookPanel,
                    "Please enter valid numeric values.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ===========================
    // Delete Book
    // ===========================

    private void deleteBook() {

        try {

            int bookId = Integer.parseInt(
                    bookPanel.getTxtBookId().getText().trim());

            int choice = JOptionPane.showConfirmDialog(
                    bookPanel,
                    "Are you sure you want to delete this book?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION);

            if (choice != JOptionPane.YES_OPTION) {
                return;
            }

            boolean success =
                    bookService.deleteBook(bookId);

            if (success) {

                JOptionPane.showMessageDialog(
                        bookPanel,
                        "Book deleted successfully.");

                clearForm();
                loadBooks();

            } else {

                JOptionPane.showMessageDialog(
                        bookPanel,
                        "Book could not be deleted.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    bookPanel,
                    "Please enter a valid Book ID.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ===========================
    // Load Books
    // ===========================

    private void loadBooks() {

        List<Book> books =
                bookService.getAllBooks();

        DefaultTableModel model =
                (DefaultTableModel) bookPanel
                        .getBookTable()
                        .getModel();

        model.setRowCount(0);

        for (Book book : books) {

            model.addRow(new Object[] {
                    book.getBookId(),
                    book.getIsbn(),
                    book.getTitle(),
                    book.getAuthorId(),
                    book.getCategoryId(),
                    book.getPublisherId(),
                    book.getAvailableCopies()
            });
        }
    }

    // ===========================
    // Clear Form
    // ===========================

    private void clearForm() {

        bookPanel.getTxtBookId().setText("");
        bookPanel.getTxtIsbn().setText("");
        bookPanel.getTxtTitle().setText("");
        bookPanel.getTxtAuthorId().setText("");
        bookPanel.getTxtCategoryId().setText("");
        bookPanel.getTxtPublisherId().setText("");
        bookPanel.getTxtTotalCopies().setText("");
    }
}