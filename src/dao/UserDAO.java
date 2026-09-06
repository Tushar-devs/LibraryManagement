package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.User;

public class UserDAO {
	private User mapResultSetToUser(ResultSet rs) throws SQLException {
		User user = new User();

		user.setUserId(rs.getInt("user_id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setFullName(rs.getString("full_name"));
		user.setEmail(rs.getString("email"));
		user.setPhoneNumber(rs.getString("phone_number"));
		user.setRole(rs.getString("role"));

		return user;
	}

	public boolean addUser(User user) {
		String sql = "INSERT INTO user (username, password, full_name, email, phone_number, role) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFullName());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhoneNumber());
			ps.setString(6, user.getRole());

			int rowsAffected = ps.executeUpdate();

			ps.close();
			con.close();

			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public User getUserById(int userId) {
	    String sql = "SELECT * FROM user WHERE user_id = ?";

	    User user = null;

	    try {
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setInt(1, userId);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            user = mapResultSetToUser(rs);
	        }

	        rs.close();
	        ps.close();
	        con.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return user;
	}

	public User getUserByUsername(String username) {
		String sql = "SELECT * FROM user WHERE username = ?";

		User user = null;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = mapResultSetToUser(rs);
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public List<User> getAllUsers() {
		String sql = "SELECT * FROM user";

		List<User> users = new ArrayList<>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				users.add(mapResultSetToUser(rs));
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public boolean updateUser(User user) {
		String sql = "UPDATE user SET username = ?, password = ?, full_name = ?, "
				+ "email = ?, phone_number = ?, role = ? WHERE user_id = ?";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFullName());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhoneNumber());
			ps.setString(6, user.getRole());
			ps.setInt(7, user.getUserId());

			int rowsAffected = ps.executeUpdate();

			ps.close();
			con.close();

			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(int userId) {
		String sql = "DELETE FROM user WHERE user_id = ?";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, userId);

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
