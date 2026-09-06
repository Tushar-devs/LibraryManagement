package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.Publisher;

public class PublisherDAO {
	public boolean addPublisher(Publisher publisher) {
		String sql = "INSERT INTO publisher (publisher_name, publisher_city, publisher_email, publisher_phone, website) VALUES (?, ?, ?, ?, ?)";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, publisher.getPublisherName());
			ps.setString(2, publisher.getPublisherCity());
			ps.setString(3, publisher.getPublisherEmail());
			ps.setString(4, publisher.getPublisherPhone());
			ps.setString(5, publisher.getWebsite());

			int rowsAffected = ps.executeUpdate();

			ps.close();
			con.close();

			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Publisher getPublisherById(int publisherId) {
		String sql = "SELECT * FROM publisher WHERE publisher_id = ?";

		Publisher publisher = null;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, publisherId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				publisher = new Publisher();

				publisher.setPublisherId(rs.getInt("publisher_id"));
				publisher.setPublisherName(rs.getString("publisher_name"));
				publisher.setPublisherCity(rs.getString("publisher_city"));
				publisher.setPublisherEmail(rs.getString("publisher_email"));
				publisher.setPublisherPhone(rs.getString("publisher_phone"));
				publisher.setWebsite(rs.getString("website"));
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return publisher;
	}

	public Publisher getPublisherByName(String publisherName) {
		String sql = "SELECT * FROM publisher WHERE publisher_name = ?";

		Publisher publisher = null;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, publisherName);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				publisher = new Publisher();

				publisher.setPublisherId(rs.getInt("publisher_id"));
				publisher.setPublisherName(rs.getString("publisher_name"));
				publisher.setPublisherCity(rs.getString("publisher_city"));
				publisher.setPublisherEmail(rs.getString("publisher_email"));
				publisher.setPublisherPhone(rs.getString("publisher_phone"));
				publisher.setWebsite(rs.getString("website"));
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return publisher;
	}

	public List<Publisher> getAllPublishers() {
		String sql = "SELECT * FROM publisher";

		List<Publisher> publishers = new ArrayList<>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Publisher publisher = new Publisher();

				publisher.setPublisherId(rs.getInt("publisher_id"));
				publisher.setPublisherName(rs.getString("publisher_name"));
				publisher.setPublisherCity(rs.getString("publisher_city"));
				publisher.setPublisherEmail(rs.getString("publisher_email"));
				publisher.setPublisherPhone(rs.getString("publisher_phone"));
				publisher.setWebsite(rs.getString("website"));

				publishers.add(publisher);
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return publishers;
	}

	public boolean updatePublisher(Publisher publisher) {
		String sql = "UPDATE publisher SET publisher_name = ?, publisher_city = ?, publisher_email = ?, publisher_phone = ?, website = ? WHERE publisher_id = ?";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, publisher.getPublisherName());
			ps.setString(2, publisher.getPublisherCity());
			ps.setString(3, publisher.getPublisherEmail());
			ps.setString(4, publisher.getPublisherPhone());
			ps.setString(5, publisher.getWebsite());
			ps.setInt(6, publisher.getPublisherId());

			int rowsAffected = ps.executeUpdate();

			ps.close();
			con.close();

			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletePublisher(int publisherId) {
		String sql = "DELETE FROM publisher WHERE publisher_id = ?";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, publisherId);

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
