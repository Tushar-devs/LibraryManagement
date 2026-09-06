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

public class MemberPanel extends JPanel {

    private JTextField txtMemberId;
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JTextField txtAddress;
    private JTextField txtDateOfBirth;
    private JTextField txtGender;
    private JTextField txtCourseOrClass;
    private JTextField txtDepartment;

    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnClear;

    private JTable memberTable;

    public MemberPanel() {

        setLayout(new BorderLayout(0, 15));

        setBorder(
                BorderFactory.createEmptyBorder(
                        20, 30, 25, 30));

        // ===========================
        // Title
        // ===========================

        JLabel lblTitle = new JLabel("Member Management");

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
                        "Member Details"));

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(6, 12, 6, 12);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        // ---------------------------
        // Member ID
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Member ID:"),
                gbc);

        txtMemberId = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtMemberId,
                gbc);

        // ---------------------------
        // Name
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Name:"),
                gbc);

        txtName = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtName,
                gbc);

        // ---------------------------
        // Email
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Email:"),
                gbc);

        txtEmail = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtEmail,
                gbc);

        // ---------------------------
        // Phone
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Phone:"),
                gbc);

        txtPhone = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtPhone,
                gbc);

        // ---------------------------
        // Address
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Address:"),
                gbc);

        txtAddress = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtAddress,
                gbc);

        // ---------------------------
        // Date of Birth
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Date of Birth (yyyy-mm-dd):"),
                gbc);

        txtDateOfBirth = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtDateOfBirth,
                gbc);

        // ---------------------------
        // Gender
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Gender:"),
                gbc);

        txtGender = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtGender,
                gbc);

        // ---------------------------
        // Course / Class
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Course/Class:"),
                gbc);

        txtCourseOrClass = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtCourseOrClass,
                gbc);

        // ---------------------------
        // Department
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Department:"),
                gbc);

        txtDepartment = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtDepartment,
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
        // Member Table
        // ===========================

        String[] columns = {
                "Member ID",
                "Name",
                "Email",
                "Phone",
                "Address"
        };

        DefaultTableModel tableModel =
                new DefaultTableModel(columns, 0);

        memberTable = new JTable(tableModel);

        memberTable.setRowHeight(25);

        memberTable.getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD, 14));

        JScrollPane scrollPane =
                new JScrollPane(memberTable);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        "Members"));

        add(
                scrollPane,
                BorderLayout.CENTER);
    }

    public JTextField getTxtMemberId() {
        return txtMemberId;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JTextField getTxtPhone() {
        return txtPhone;
    }

    public JTextField getTxtAddress() {
        return txtAddress;
    }

    public JTextField getTxtDateOfBirth() {
        return txtDateOfBirth;
    }

    public JTextField getTxtGender() {
        return txtGender;
    }

    public JTextField getTxtCourseOrClass() {
        return txtCourseOrClass;
    }

    public JTextField getTxtDepartment() {
        return txtDepartment;
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

    public JTable getMemberTable() {
        return memberTable;
    }
}