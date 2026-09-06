package service;

import java.util.ArrayList;
import java.util.List;

import dao.AuthorDAO;
import dao.BookDAO;
import dao.CategoryDAO;
import dao.PublisherDAO;
import model.Author;
import model.Book;
import model.Category;
import model.Publisher;

public class BookService {

	private BookDAO bookDAO;
	private AuthorDAO authorDAO;
	private CategoryDAO categoryDAO;
	private PublisherDAO publisherDAO;

	public BookService() {
		bookDAO = new BookDAO();
		authorDAO = new AuthorDAO();
		categoryDAO = new CategoryDAO();
		publisherDAO = new PublisherDAO();
	}

	public boolean addBook(Book book) {

		if (book == null) {
			System.out.println("Book details cannot be null.");
			return false;
		}

		if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
			System.out.println("Book title is required.");
			return false;
		}

		if (book.getIsbn() == null || book.getIsbn().trim().isEmpty()) {
			System.out.println("ISBN is required.");
			return false;
		}

		if (book.getTotalCopies() < 1) {
			System.out.println("Total copies must be at least 1.");
			return false;
		}

		book.setAvailableCopies(book.getTotalCopies());

		book.setAvailabilityStatus("Available");
		return bookDAO.addBook(book);

	}

	public Book getBookById(int bookId) {

		if (bookId <= 0) {
			System.out.println("Invalid book ID.");
			return null;
		}

		return bookDAO.getBookById(bookId);
	}

	public Book getBookByISBN(String isbn) {

		if (isbn == null || isbn.trim().isEmpty()) {
			System.out.println("ISBN cannot be empty.");
			return null;
		}

		return bookDAO.getBookByISBN(isbn);
	}

	public List<Book> getAllBooks() {
		return bookDAO.getAllBooks();
	}

	public List<Book> getBooksByAuthorId(int authorId) {

		if (authorId <= 0) {
			System.out.println("Invalid author ID.");
			return new ArrayList<>();
		}

		return bookDAO.getBooksByAuthorId(authorId);
	}

	public List<Book> getBooksByCategoryId(int categoryId) {

		if (categoryId <= 0) {
			System.out.println("Invalid category ID.");
			return new ArrayList<>();
		}

		return bookDAO.getBooksByCategoryId(categoryId);
	}

	public List<Book> getBooksByPublisherId(int publisherId) {

		if (publisherId <= 0) {
			System.out.println("Invalid publisher ID.");
			return new ArrayList<>();
		}

		return bookDAO.getBooksByPublisherId(publisherId);
	}

	public List<Book> searchBooksByTitle(String title) {

		if (title == null || title.trim().isEmpty()) {
			System.out.println("Book title cannot be empty.");
			return new ArrayList<>();
		}

		return bookDAO.searchBooksByTitle(title);
	}

	public boolean updateBook(Book book) {

		if (book == null) {
			System.out.println("Book details cannot be null.");
			return false;
		}

		if (book.getBookId() <= 0) {
			System.out.println("Invalid book ID.");
			return false;
		}

		if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
			System.out.println("Book title cannot be empty.");
			return false;
		}

		if (book.getIsbn() == null || book.getIsbn().trim().isEmpty()) {
			System.out.println("ISBN cannot be empty.");
			return false;
		}

		if (book.getTotalCopies() < 0 || book.getAvailableCopies() < 0) {
			System.out.println("Number of copies cannot be negative.");
			return false;
		}

		if (book.getAvailableCopies() > book.getTotalCopies()) {
			System.out.println("Available copies cannot exceed total copies.");
			return false;
		}

		return bookDAO.updateBook(book);
	}

	public boolean deleteBook(int bookId) {

		if (bookId <= 0) {
			System.out.println("Invalid book ID.");
			return false;
		}

		Book book = bookDAO.getBookById(bookId);

		if (book == null) {
			System.out.println("Book not found.");
			return false;
		}

		if (book.getAvailableCopies() != book.getTotalCopies()) {
			System.out.println("Cannot delete book. Some copies are currently issued.");
			return false;
		}

		return bookDAO.deleteBook(bookId);
	}

	public List<Book> getBooksByAuthorName(String authorName) {

		if (authorName == null || authorName.trim().isEmpty()) {
			System.out.println("Author name cannot be empty.");
			return new ArrayList<>();
		}

		Author author = authorDAO.getAuthorByName(authorName);

		if (author == null) {
			System.out.println("Author not found.");
			return new ArrayList<>();
		}

		return bookDAO.getBooksByAuthorId(author.getAuthorId());
	}

	public List<Book> getBooksByCategoryName(String categoryName) {

		if (categoryName == null || categoryName.trim().isEmpty()) {
			System.out.println("Category name cannot be empty.");
			return new ArrayList<>();
		}

		Category category = categoryDAO.getCategoryByName(categoryName);

		if (category == null) {
			System.out.println("Category not found.");
			return new ArrayList<>();
		}

		return bookDAO.getBooksByCategoryId(category.getCategoryId());
	}

	public List<Book> getBooksByPublisherName(String publisherName) {

		if (publisherName == null || publisherName.trim().isEmpty()) {
			System.out.println("Publisher name cannot be empty.");
			return new ArrayList<>();
		}

		Publisher publisher = publisherDAO.getPublisherByName(publisherName);

		if (publisher == null) {
			System.out.println("Publisher not found.");
			return new ArrayList<>();
		}

		return bookDAO.getBooksByPublisherId(publisher.getPublisherId());
	}
}