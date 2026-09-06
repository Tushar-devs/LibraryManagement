package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.User;
import service.UserService;
import view.panels.UserPanel;

public class UserController {

    private UserPanel userPanel;
    private UserService userService;

    public UserController(UserPanel userPanel) {

        this.userPanel = userPanel;
        this.userService = new UserService();

        registerListeners();
        loadUsers();
    }

    // ===========================
    // Register Listeners
    // ===========================

    private void registerListeners() {

        userPanel.getBtnAdd().addActionListener(e -> addUser());

        userPanel.getBtnUpdate().addActionListener(e -> updateUser());

        userPanel.getBtnDelete().addActionListener(e -> deleteUser());

        userPanel.getBtnClear().addActionListener(e -> clearForm());
    }

    // ===========================
    // Add User
    // ===========================

    private void addUser() {

        String username = userPanel.getTxtUsername().getText().trim();
        String password = userPanel.getTxtPassword().getText().trim();
        String fullName = userPanel.getTxtFullName().getText().trim();
        String role = userPanel.getTxtRole().getText().trim();

        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        user.setFullName(fullName);
        user.setRole(role);

        boolean success = userService.addUser(user);

        if (success) {

            JOptionPane.showMessageDialog(
                    userPanel,
                    "User added successfully.");

            clearForm();
            loadUsers();

        } else {

            JOptionPane.showMessageDialog(
                    userPanel,
                    "Failed to add user.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ===========================
    // Update User
    // ===========================

    private void updateUser() {

        try {

            int userId = Integer.parseInt(
                    userPanel.getTxtUserId().getText().trim());

            User existingUser =
                    userService.getUserById(userId);

            if (existingUser == null) {

                JOptionPane.showMessageDialog(
                        userPanel,
                        "User not found.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            String username = userPanel.getTxtUsername().getText().trim();
            String password = userPanel.getTxtPassword().getText().trim();
            String fullName = userPanel.getTxtFullName().getText().trim();
            String role = userPanel.getTxtRole().getText().trim();

            existingUser.setUsername(username);
            existingUser.setPassword(password);
            existingUser.setFullName(fullName);
            existingUser.setRole(role);

            boolean success =
                    userService.updateUser(existingUser);

            if (success) {

                JOptionPane.showMessageDialog(
                        userPanel,
                        "User updated successfully.");

                clearForm();
                loadUsers();

            } else {

                JOptionPane.showMessageDialog(
                        userPanel,
                        "Failed to update user.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    userPanel,
                    "Please enter a valid numeric User ID.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ===========================
    // Delete User
    // ===========================

    private void deleteUser() {

        try {

            int userId = Integer.parseInt(
                    userPanel.getTxtUserId().getText().trim());

            int choice = JOptionPane.showConfirmDialog(
                    userPanel,
                    "Are you sure you want to delete this user?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION);

            if (choice != JOptionPane.YES_OPTION) {
                return;
            }

            boolean success =
                    userService.deleteUser(userId);

            if (success) {

                JOptionPane.showMessageDialog(
                        userPanel,
                        "User deleted successfully.");

                clearForm();
                loadUsers();

            } else {

                JOptionPane.showMessageDialog(
                        userPanel,
                        "User could not be deleted.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    userPanel,
                    "Please enter a valid User ID.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ===========================
    // Load Users
    // ===========================

    private void loadUsers() {

        List<User> users =
                userService.getAllUsers();

        DefaultTableModel model =
                (DefaultTableModel) userPanel
                        .getUserTable()
                        .getModel();

        model.setRowCount(0);

        for (User user : users) {

            model.addRow(new Object[] {
                    user.getUserId(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getFullName(),
                    user.getRole()
            });
        }
    }

    // ===========================
    // Clear Form
    // ===========================

    private void clearForm() {

        userPanel.getTxtUserId().setText("");
        userPanel.getTxtUsername().setText("");
        userPanel.getTxtPassword().setText("");
        userPanel.getTxtFullName().setText("");
        userPanel.getTxtRole().setText("");
    }
}
