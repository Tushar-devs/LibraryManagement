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

public class BookPanel extends JPanel {

    private JTextField txtBookId;
    private JTextField txtIsbn;
    private JTextField txtTitle;
    private JTextField txtAuthorId;
    private JTextField txtCategoryId;
    private JTextField txtPublisherId;
    private JTextField txtTotalCopies;

    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnClear;

    private JTable bookTable;

    public BookPanel() {

        setLayout(new BorderLayout(0, 15));

        setBorder(
                BorderFactory.createEmptyBorder(
                        20, 30, 25, 30));

        // ===========================
        // Title
        // ===========================

        JLabel lblTitle = new JLabel("Book Management");

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
                        "Book Details"));

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(6, 12, 6, 12);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        // ---------------------------
        // Book ID
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Book ID:"),
                gbc);

        txtBookId = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtBookId,
                gbc);

        // ---------------------------
        // ISBN
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("ISBN:"),
                gbc);

        txtIsbn = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtIsbn,
                gbc);

        // ---------------------------
        // Title
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Title:"),
                gbc);

        txtTitle = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtTitle,
                gbc);

        // ---------------------------
        // Author ID
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Author ID:"),
                gbc);

        txtAuthorId = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtAuthorId,
                gbc);

        // ---------------------------
        // Category ID
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Category ID:"),
                gbc);

        txtCategoryId = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtCategoryId,
                gbc);

        // ---------------------------
        // Publisher ID
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Publisher ID:"),
                gbc);

        txtPublisherId = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtPublisherId,
                gbc);

        // ---------------------------
        // Total Copies
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Total Copies:"),
                gbc);

        txtTotalCopies = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtTotalCopies,
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
        // Book Table
        // ===========================

        String[] columns = {
                "Book ID",
                "ISBN",
                "Title",
                "Author ID",
                "Category ID",
                "Publisher ID",
                "Available Copies"
        };

        bookTable = new JTable(
                new DefaultTableModel(
                        new Object[0][7],
                        columns));
        
        bookTable.setRowHeight(25);

        bookTable.getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD, 14));

        JScrollPane scrollPane =
                new JScrollPane(bookTable);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        "Books"));

        add(
                scrollPane,
                BorderLayout.CENTER);
    }
    public JTextField getTxtBookId() {
        return txtBookId;
    }

    public JTextField getTxtIsbn() {
        return txtIsbn;
    }

    public JTextField getTxtTitle() {
        return txtTitle;
    }

    public JTextField getTxtAuthorId() {
        return txtAuthorId;
    }

    public JTextField getTxtCategoryId() {
        return txtCategoryId;
    }

    public JTextField getTxtPublisherId() {
        return txtPublisherId;
    }

    public JTextField getTxtTotalCopies() {
        return txtTotalCopies;
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

    public JTable getBookTable() {
        return bookTable;
    }
}