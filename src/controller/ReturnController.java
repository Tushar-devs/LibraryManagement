package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.IssueRecord;
import model.ReturnRecord;
import service.IssueService;
import service.ReturnService;
import view.panels.ReturnPanel;

public class ReturnController {

    private ReturnPanel returnPanel;
    private ReturnService returnService;
    private IssueService issueService;

    public ReturnController(ReturnPanel returnPanel) {

        this.returnPanel = returnPanel;
        this.returnService = new ReturnService();
        this.issueService = new IssueService();

        registerListeners();
        loadReturnRecords();
    }

    // ===========================
    // Register Listeners
    // ===========================

    private void registerListeners() {

        returnPanel.getBtnReturn().addActionListener(e -> returnBook());

        returnPanel.getBtnClear().addActionListener(e -> clearForm());
    }

    // ===========================
    // Return Book
    // ===========================

    private void returnBook() {

        try {

            int issueId = Integer.parseInt(
                    returnPanel.getTxtIssueId().getText().trim());

            boolean success =
                    returnService.returnBook(issueId);

            if (success) {

                JOptionPane.showMessageDialog(
                        returnPanel,
                        "Book returned successfully.");

                clearForm();
                loadReturnRecords();

            } else {

                JOptionPane.showMessageDialog(
                        returnPanel,
                        "Failed to return book. Check that the issue record exists and has not already been returned.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    returnPanel,
                    "Please enter a valid numeric Issue ID.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ===========================
    // Load Return Records
    // ===========================

    private void loadReturnRecords() {

        List<ReturnRecord> returnRecords =
                returnService.getAllReturnRecords();

        DefaultTableModel model =
                (DefaultTableModel) returnPanel
                        .getReturnTable()
                        .getModel();

        model.setRowCount(0);

        for (ReturnRecord returnRecord : returnRecords) {

            IssueRecord issueRecord =
                    issueService.getIssueRecordById(returnRecord.getIssueId());

            Object bookId = issueRecord != null ? issueRecord.getBookId() : "-";
            Object memberId = issueRecord != null ? issueRecord.getMemberId() : "-";

            model.addRow(new Object[] {
                    returnRecord.getReturnId(),
                    returnRecord.getIssueId(),
                    bookId,
                    memberId,
                    returnRecord.getReturnDate(),
                    returnRecord.getFineAmount()
            });
        }
    }

    // ===========================
    // Clear Form
    // ===========================

    private void clearForm() {

        returnPanel.getTxtReturnId().setText("");
        returnPanel.getTxtIssueId().setText("");
        returnPanel.getTxtBookId().setText("");
        returnPanel.getTxtMemberId().setText("");
        returnPanel.getTxtReturnDate().setText("");
        returnPanel.getTxtFine().setText("");
    }
}
