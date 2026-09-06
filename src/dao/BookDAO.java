package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.Book;

public class BookDAO {

	private Book mapResultSetToBook(ResultSet rs) throws SQLException {
		Book book = new Book();

		book.setBookId(rs.getInt("book_id"));
		book.setIsbn(rs.getString("isbn"));
		book.setTitle(rs.getString("title"));
		book.setAuthorId(rs.getInt("author_id"));
		book.setCategoryId(rs.getInt("category_id"));
		book.setPublisherId(rs.getInt("publisher_id"));
		book.setEdition(rs.getString("edition"));
		book.setPublicationYear(rs.getInt("publication_year"));
		book.setLanguage(rs.getString("language"));
		book.setRackNumber(rs.getString("rack_number"));
		book.setPrice(rs.getDouble("price"));
		book.setTotalCopies(rs.getInt("total_copies"));
		book.setAvailableCopies(rs.getInt("available_copies"));
		book.setAvailabilityStatus(rs.getString("availability_status"));
		book.setDescription(rs.getString("description"));

		return book;
	}

	public boolean addBook(Book book) {
		String sql = "INSERT INTO book (isbn, title, author_id, category_id, publisher_id, edition, publication_year, language, rack_number, price, total_copies, available_copies, availability_status, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setInt(3, book.getAuthorId());
			ps.setInt(4, book.getCategoryId());
			ps.setInt(5, book.getPublisherId());
			ps.setString(6, book.getEdition());
			ps.setInt(7, book.getPublicationYear());
			ps.setString(8, book.getLanguage());
			ps.setString(9, book.getRackNumber());
			ps.setDouble(10, book.getPrice());
			ps.setInt(11, book.getTotalCopies());
			ps.setInt(12, book.getAvailableCopies());
			ps.setString(13, book.getAvailabilityStatus());
			ps.setString(14, book.getDescription());

			int rowsAffected = ps.executeUpdate();

			ps.close();
			con.close();

			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Book getBookById(int bookId) {
		String sql = "SELECT * FROM book WHERE book_id = ?";

		Book book = null;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, bookId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				book = mapResultSetToBook(rs);
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return book;
	}

	public Book getBookByISBN(String isbn) {
		String sql = "SELECT * FROM book WHERE isbn = ?";

		Book book = null;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, isbn);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				book = mapResultSetToBook(rs);
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return book;
	}

	public List<Book> getAllBooks() {
		String sql = "SELECT * FROM book";

		List<Book> books = new ArrayList<>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				books.add(mapResultSetToBook(rs));
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

	public boolean updateBook(Book book) {
		String sql = "UPDATE book SET isbn = ?, title = ?, author_id = ?, category_id = ?, "
				+ "publisher_id = ?, edition = ?, publication_year = ?, language = ?, "
				+ "rack_number = ?, price = ?, total_copies = ?, available_copies = ?, "
				+ "availability_status = ?, description = ? " + "WHERE book_id = ?";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setInt(3, book.getAuthorId());
			ps.setInt(4, book.getCategoryId());
			ps.setInt(5, book.getPublisherId());
			ps.setString(6, book.getEdition());
			ps.setInt(7, book.getPublicationYear());
			ps.setString(8, book.getLanguage());
			ps.setString(9, book.getRackNumber());
			ps.setDouble(10, book.getPrice());
			ps.setInt(11, book.getTotalCopies());
			ps.setInt(12, book.getAvailableCopies());
			ps.setString(13, book.getAvailabilityStatus());
			ps.setString(14, book.getDescription());
			ps.setInt(15, book.getBookId());

			int rowsAffected = ps.executeUpdate();

			ps.close();
			con.close();

			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteBook(int bookId) {
		String sql = "DELETE FROM book WHERE book_id = ?";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, bookId);

			int rowsAffected = ps.executeUpdate();

			ps.close();
			con.close();

			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Search / Filters
	public List<Book> searchBooksByTitle(String title) {
		String sql = "SELECT * FROM book WHERE title LIKE ?";

		List<Book> books = new ArrayList<>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, "%" + title + "%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				books.add(mapResultSetToBook(rs));
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

	public List<Book> getBooksByAuthorId(int authorId) {
		String sql = "SELECT * FROM book WHERE author_id = ?";

		List<Book> books = new ArrayList<>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, authorId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				books.add(mapResultSetToBook(rs));
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

	public List<Book> getBooksByCategoryId(int categoryId) {
		String sql = "SELECT * FROM book WHERE category_id = ?";

		List<Book> books = new ArrayList<>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, categoryId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				books.add(mapResultSetToBook(rs));
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

	public List<Book> getBooksByPublisherId(int publisherId) {
		String sql = "SELECT * FROM book WHERE publisher_id = ?";
		List<Book> books = new ArrayList<>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, publisherId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				books.add(mapResultSetToBook(rs));
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

	// Inventory
	public List<Book> getAvailableBooks() {
	    String sql = "SELECT * FROM book WHERE available_copies > 0";

	    List<Book> books = new ArrayList<>();

	    try {
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            books.add(mapResultSetToBook(rs));
	        }

	        rs.close();
	        ps.close();
	        con.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return books;
	}

	public List<Book> getUnavailableBooks() {
	    String sql = "SELECT * FROM book WHERE available_copies = 0";

	    List<Book> books = new ArrayList<>();

	    try {
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            books.add(mapResultSetToBook(rs));
	        }

	        rs.close();
	        ps.close();
	        con.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return books;
	}

}
