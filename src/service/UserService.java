package service;

import java.util.List;

import dao.UserDAO;
import model.User;

public class UserService {

	private UserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}

	public boolean addUser(User user) {

		if (user == null) {
			System.out.println("User details cannot be null.");
			return false;
		}

		if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
			System.out.println("Username cannot be empty.");
			return false;
		}

		if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
			System.out.println("Password cannot be empty.");
			return false;
		}

		if (user.getFullName() == null || user.getFullName().trim().isEmpty()) {
			System.out.println("Full name cannot be empty.");
			return false;
		}

		return userDAO.addUser(user);
	}

	public User getUserById(int userId) {

		if (userId <= 0) {
			System.out.println("Invalid user ID.");
			return null;
		}

		return userDAO.getUserById(userId);
	}

	public User getUserByUsername(String username) {

		if (username == null || username.trim().isEmpty()) {
			System.out.println("Username cannot be empty.");
			return null;
		}

		return userDAO.getUserByUsername(username);
	}

	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	public boolean updateUser(User user) {

		if (user == null) {
			System.out.println("User details cannot be null.");
			return false;
		}

		if (user.getUserId() <= 0) {
			System.out.println("Invalid user ID.");
			return false;
		}

		if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
			System.out.println("Username cannot be empty.");
			return false;
		}

		if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
			System.out.println("Password cannot be empty.");
			return false;
		}

		if (user.getFullName() == null || user.getFullName().trim().isEmpty()) {
			System.out.println("Full name cannot be empty.");
			return false;
		}

		return userDAO.updateUser(user);
	}

	public boolean deleteUser(int userId) {

		if (userId <= 0) {
			System.out.println("Invalid user ID.");
			return false;
		}

		User user = userDAO.getUserById(userId);

		if (user == null) {
			System.out.println("User not found.");
			return false;
		}

		return userDAO.deleteUser(userId);
	}
}