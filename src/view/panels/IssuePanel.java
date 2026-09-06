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

public class IssuePanel extends JPanel {

    private JTextField txtIssueId;
    private JTextField txtBookId;
    private JTextField txtMemberId;
    private JTextField txtIssueDate;
    private JTextField txtDueDate;

    private JButton btnIssue;
    private JButton btnClear;

    private JTable issueTable;

    public IssuePanel() {

        setLayout(new BorderLayout(0, 15));

        setBorder(
                BorderFactory.createEmptyBorder(
                        20, 30, 25, 30));

        // ===========================
        // Title
        // ===========================

        JLabel lblTitle = new JLabel("Issue Book");

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
                        "Issue Details"));

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(6, 12, 6, 12);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        // ---------------------------
        // Issue ID
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Issue ID:"),
                gbc);

        txtIssueId = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtIssueId,
                gbc);

        // ---------------------------
        // Book ID
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 1;
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
        // Member ID
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 2;
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
        // Issue Date
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Issue Date:"),
                gbc);

        txtIssueDate = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtIssueDate,
                gbc);

        // ---------------------------
        // Due Date
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Due Date:"),
                gbc);

        txtDueDate = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtDueDate,
                gbc);

        topPanel.add(
                formPanel,
                BorderLayout.CENTER);

        // ===========================
        // Button Panel
        // ===========================

        JPanel buttonPanel = new JPanel();

        btnIssue = new JButton("Issue");
        btnClear = new JButton("Clear");

        btnIssue.setFocusPainted(false);
        btnClear.setFocusPainted(false);

        buttonPanel.add(btnIssue);
        buttonPanel.add(btnClear);

        topPanel.add(
                buttonPanel,
                BorderLayout.SOUTH);

        add(
                topPanel,
                BorderLayout.NORTH);

        // ===========================
        // Issue Table
        // ===========================

        String[] columns = {
                "Issue ID",
                "Book ID",
                "Member ID",
                "Issue Date",
                "Due Date"
        };
        
        DefaultTableModel tableModel =
                new DefaultTableModel(columns, 0);

        issueTable = new JTable(tableModel);

        issueTable.setRowHeight(25);

        issueTable.getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD, 14));

        JScrollPane scrollPane =
                new JScrollPane(issueTable);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        "Issued Books"));

        add(
                scrollPane,
                BorderLayout.CENTER);
    }

    public JTextField getTxtIssueId() {
        return txtIssueId;
    }

    public JTextField getTxtBookId() {
        return txtBookId;
    }

    public JTextField getTxtMemberId() {
        return txtMemberId;
    }

    public JTextField getTxtIssueDate() {
        return txtIssueDate;
    }

    public JTextField getTxtDueDate() {
        return txtDueDate;
    }

    public JButton getBtnIssue() {
        return btnIssue;
    }

    public JButton getBtnClear() {
        return btnClear;
    }

    public JTable getIssueTable() {
        return issueTable;
    }
}