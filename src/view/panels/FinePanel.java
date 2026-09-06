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


public class FinePanel extends JPanel {

    private JTextField txtFineId;
    private JTextField txtMemberId;
    private JTextField txtReturnId;
    private JTextField txtAmount;
    private JTextField txtStatus;

    private JButton btnPay;
    private JButton btnClear;

    private JTable fineTable;

    public FinePanel() {

        setLayout(new BorderLayout(0, 15));

        setBorder(
                BorderFactory.createEmptyBorder(
                        20, 30, 25, 30));

        // ===========================
        // Title
        // ===========================

        JLabel lblTitle = new JLabel("Fine Management");

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
                        "Fine Details"));

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(6, 12, 6, 12);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        // ---------------------------
        // Fine ID
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Fine ID:"),
                gbc);

        txtFineId = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtFineId,
                gbc);

        // ---------------------------
        // Member ID
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 1;
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
        // Return ID
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 2;
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
        // Amount
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Amount:"),
                gbc);

        txtAmount = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtAmount,
                gbc);

        // ---------------------------
        // Status
        // ---------------------------

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;

        formPanel.add(
                new JLabel("Status:"),
                gbc);

        txtStatus = new JTextField(15);

        gbc.gridx = 1;
        gbc.weightx = 0.5;

        formPanel.add(
                txtStatus,
                gbc);

        topPanel.add(
                formPanel,
                BorderLayout.CENTER);

        // ===========================
        // Button Panel
        // ===========================

        JPanel buttonPanel = new JPanel();

        btnPay = new JButton("Pay Fine");
        btnClear = new JButton("Clear");

        btnPay.setFocusPainted(false);
        btnClear.setFocusPainted(false);

        buttonPanel.add(btnPay);
        buttonPanel.add(btnClear);

        topPanel.add(
                buttonPanel,
                BorderLayout.SOUTH);

        add(
                topPanel,
                BorderLayout.NORTH);

        // ===========================
        // Fine Table
        // ===========================

        String[] columns = {
                "Fine ID",
                "Member ID",
                "Return ID",
                "Amount",
                "Status"
        };

        DefaultTableModel tableModel =
                new DefaultTableModel(columns, 0);

        fineTable = new JTable(tableModel);

        fineTable.setRowHeight(25);

        fineTable.getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD, 14));

        JScrollPane scrollPane =
                new JScrollPane(fineTable);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        "Fines"));

        add(
                scrollPane,
                BorderLayout.CENTER);
    }

    public JTextField getTxtFineId() {
        return txtFineId;
    }

    public JTextField getTxtMemberId() {
        return txtMemberId;
    }

    public JTextField getTxtReturnId() {
        return txtReturnId;
    }

    public JTextField getTxtAmount() {
        return txtAmount;
    }

    public JTextField getTxtStatus() {
        return txtStatus;
    }

    public JButton getBtnPay() {
        return btnPay;
    }

    public JButton getBtnClear() {
        return btnClear;
    }

    public JTable getFineTable() {
        return fineTable;
    }
}