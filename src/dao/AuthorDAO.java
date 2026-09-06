package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import model.Author;

public class AuthorDAO {
	public boolean addAuthor(Author author) {

		String sql = "INSERT INTO author (author_name) VALUES (?)";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, author.getAuthorName());
			int rowsAffected = ps.executeUpdate();

			ps.close();
			con.close();

			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Author> getAllAuthors() {
		ArrayList<Author> authorList = new ArrayList<>();
		String sql = "SELECT * FROM author";
		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("author_id");
				String name = rs.getString("author_name");
				Author author = new Author(id, name);
				authorList.add(author);

			}

			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authorList;
	}

	public Author getAuthorById(int authorId) {
		String sql = "SELECT * FROM author WHERE author_id = ?";
		Author author = null;
		try {

			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, authorId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("author_id");
				String name = rs.getString("author_name");
				author = new Author(id, name);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return author;
	}

	public Author getAuthorByName(String authorName) {

		String sql = "SELECT * FROM author WHERE author_name = ?";
		Author author = null;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, authorName);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("author_id");
				String name = rs.getString("author_name");
				author = new Author(id, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return author;
	}

	public boolean updateAuthor(Author author) {
		String sql = "UPDATE author SET author_name = ? WHERE author_id = ?";
		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, author.getAuthorName());
			ps.setInt(2, author.getAuthorId());

			int rowsAffected = ps.executeUpdate();

			ps.close();
			con.close();

			return rowsAffected > 0;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		}
	}

	public boolean deleteAuthor(int authorId) {

		String sql = "DELETE FROM author WHERE author_id = ?";
		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, authorId);

			int rowsAffected = ps.executeUpdate();

			ps.close();
			con.close();

			return rowsAffected > 0;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}
}
