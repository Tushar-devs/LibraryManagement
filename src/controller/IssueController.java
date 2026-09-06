package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.IssueRecord;
import service.IssueService;
import view.panels.IssuePanel;

public class IssueController {

    private IssuePanel issuePanel;
    private IssueService issueService;
    private int currentUserId;

    public IssueController(IssuePanel issuePanel, int currentUserId) {

        this.issuePanel = issuePanel;
        this.issueService = new IssueService();
        this.currentUserId = currentUserId;

        registerListeners();
        loadIssueRecords();
    }

    // ===========================
    // Register Listeners
    // ===========================

    private void registerListeners() {

        issuePanel.getBtnIssue().addActionListener(e -> issueBook());

        issuePanel.getBtnClear().addActionListener(e -> clearForm());
    }

    // ===========================
    // Issue Book
    // ===========================

    private void issueBook() {

        try {

            int bookId = Integer.parseInt(
                    issuePanel.getTxtBookId().getText().trim());

            int memberId = Integer.parseInt(
                    issuePanel.getTxtMemberId().getText().trim());

            boolean success =
                    issueService.issueBook(bookId, memberId, currentUserId);

            if (success) {

                JOptionPane.showMessageDialog(
                        issuePanel,
                        "Book issued successfully.");

                clearForm();
                loadIssueRecords();

            } else {

                JOptionPane.showMessageDialog(
                        issuePanel,
                        "Failed to issue book. Check that the book and member exist and the book is available.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    issuePanel,
                    "Please enter valid numeric Book ID and Member ID.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ===========================
    // Load Issue Records
    // ===========================

    private void loadIssueRecords() {

        List<IssueRecord> issueRecords =
                issueService.getAllIssueRecords();

        DefaultTableModel model =
                (DefaultTableModel) issuePanel
                        .getIssueTable()
                        .getModel();

        model.setRowCount(0);

        for (IssueRecord issueRecord : issueRecords) {

            model.addRow(new Object[] {
                    issueRecord.getIssueId(),
                    issueRecord.getBookId(),
                    issueRecord.getMemberId(),
                    issueRecord.getIssueDate(),
                    issueRecord.getDueDate()
            });
        }
    }

    // ===========================
    // Clear Form
    // ===========================

    private void clearForm() {

        issuePanel.getTxtIssueId().setText("");
        issuePanel.getTxtBookId().setText("");
        issuePanel.getTxtMemberId().setText("");
        issuePanel.getTxtIssueDate().setText("");
        issuePanel.getTxtDueDate().setText("");
    }
}
