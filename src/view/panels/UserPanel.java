package view.panels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


public class UserPanel extends JPanel {

    private JTextField txtUserId;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JTextField txtFullName;
    private JTextField txtRole;

    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnClear;

    private JTable userTable;

    public UserPanel() {

        setLayout(new BorderLayout(0, 15));

        setBorder(
                BorderFactory.createEmptyBorder(
                        20, 30, 25, 30));

        // ===========================
        // Title
        // ===========================

        JLabel lblTitle = new JLabel("User Management");

        lblTitle.setFont(
                new Font("Segoe UI", Font.BOLD, 26));

        lblTitle.setHorizontalAlignment(
                SwingConstants.CENTER);

        add(lblTitle, BorderLayout.NORTH);

        // ===========================
        // Top Section
        // ===========================

        JPanel topPanel = new JPanel(
                new BorderLayout(0, 10));

        // ===========================
        // Form Panel
        // ===========================

        JPanel formPanel = new JPanel(
                new GridBagLayout());

        formPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "User Details"));

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(6, 12, 6, 12);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        // ---------------------------
        // User ID
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("User ID:"),
                gbc);

        txtUserId = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtUserId,
                gbc);

        // ---------------------------
        // Username
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Username:"),
                gbc);

        txtUsername = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtUsername,
                gbc);

        // ---------------------------
        // Password
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Password:"),
                gbc);

        txtPassword = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtPassword,
                gbc);

        // ---------------------------
        // Full Name
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Full Name:"),
                gbc);

        txtFullName = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtFullName,
                gbc);

        // ---------------------------
        // Role
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Role:"),
                gbc);

        txtRole = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtRole,
                gbc);

        topPanel.add(
                formPanel,
                BorderLayout.CENTER);

        // ===========================
        // Button Panel
        // ===========================

        JPanel buttonPanel = new JPanel();

        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear");

        btnAdd.setFocusPainted(false);
        btnUpdate.setFocusPainted(false);
        btnDelete.setFocusPainted(false);
        btnClear.setFocusPainted(false);

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);

        topPanel.add(
                buttonPanel,
                BorderLayout.SOUTH);

        add(
                topPanel,
                BorderLayout.NORTH);

        // ===========================
        // User Table
        // ===========================

        String[] columns = {
                "User ID",
                "Username",
                "Password",
                "Full Name",
                "Role"
        };

        DefaultTableModel tableModel =
                new DefaultTableModel(columns, 0);

        userTable = new JTable(tableModel);


        userTable.setRowHeight(25);

        userTable.getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD, 14));

        JScrollPane scrollPane =
                new JScrollPane(userTable);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        "Users"));

        add(
                scrollPane,
                BorderLayout.CENTER);
    }

    public JTextField getTxtUserId() {
        return txtUserId;
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public JTextField getTxtFullName() {
        return txtFullName;
    }

    public JTextField getTxtRole() {
        return txtRole;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnClear() {
        return btnClear;
    }

    public JTable getUserTable() {
        return userTable;
    }
}