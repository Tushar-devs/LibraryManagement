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

public class ReturnPanel extends JPanel {

    private JTextField txtReturnId;
    private JTextField txtIssueId;
    private JTextField txtBookId;
    private JTextField txtMemberId;
    private JTextField txtReturnDate;
    private JTextField txtFine;

    private JButton btnReturn;
    private JButton btnClear;

    private JTable returnTable;

    public ReturnPanel() {

        setLayout(new BorderLayout(0, 15));

        setBorder(
                BorderFactory.createEmptyBorder(
                        20, 30, 25, 30));

        // ===========================
        // Title
        // ===========================

        JLabel lblTitle = new JLabel("Return Book");

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
                        "Return Details"));

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(6, 12, 6, 12);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        // ---------------------------
        // Return ID
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Return ID:"),
                gbc);

        txtReturnId = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtReturnId,
                gbc);

        // ---------------------------
        // Issue ID
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 1;
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
        gbc.gridy = 2;
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
        gbc.gridy = 3;
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
        // Return Date
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Return Date:"),
                gbc);

        txtReturnDate = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtReturnDate,
                gbc);

        // ---------------------------
        // Fine
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Fine:"),
                gbc);

        txtFine = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtFine,
                gbc);

        topPanel.add(
                formPanel,
                BorderLayout.CENTER);

        // ===========================
        // Button Panel
        // ===========================

        JPanel buttonPanel = new JPanel();

        btnReturn = new JButton("Return");
        btnClear = new JButton("Clear");

        btnReturn.setFocusPainted(false);
        btnClear.setFocusPainted(false);

        buttonPanel.add(btnReturn);
        buttonPanel.add(btnClear);

        topPanel.add(
                buttonPanel,
                BorderLayout.SOUTH);

        add(
                topPanel,
                BorderLayout.NORTH);

        // ===========================
        // Return Table
        // ===========================

        String[] columns = {
                "Return ID",
                "Issue ID",
                "Book ID",
                "Member ID",
                "Return Date",
                "Fine"
        };

        DefaultTableModel tableModel =
                new DefaultTableModel(columns, 0);

        returnTable = new JTable(tableModel);

        returnTable.setRowHeight(25);

        returnTable.getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD, 14));

        JScrollPane scrollPane =
                new JScrollPane(returnTable);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        "Returned Books"));

        add(
                scrollPane,
                BorderLayout.CENTER);
    }

    public JTextField getTxtReturnId() {
        return txtReturnId;
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

    public JTextField getTxtReturnDate() {
        return txtReturnDate;
    }

    public JTextField getTxtFine() {
        return txtFine;
    }

    public JButton getBtnReturn() {
        return btnReturn;
    }

    public JButton getBtnClear() {
        return btnClear;
    }

    public JTable getReturnTable() {
        return returnTable;
    }
}