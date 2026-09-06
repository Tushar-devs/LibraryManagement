package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Fine;
import service.FineService;
import view.panels.FinePanel;

public class FineController {

    private FinePanel finePanel;
    private FineService fineService;
    private int currentUserId;

    public FineController(FinePanel finePanel, int currentUserId) {

        this.finePanel = finePanel;
        this.fineService = new FineService();
        this.currentUserId = currentUserId;

        registerListeners();
        loadFines();
    }

    // ===========================
    // Register Listeners
    // ===========================

    private void registerListeners() {

        finePanel.getBtnPay().addActionListener(e -> payFine());

        finePanel.getBtnClear().addActionListener(e -> clearForm());
    }

    // ===========================
    // Pay Fine
    // ===========================

    private void payFine() {

        try {

            int returnId = Integer.parseInt(
                    finePanel.getTxtReturnId().getText().trim());

            boolean success =
                    fineService.payFine(returnId, currentUserId);

            if (success) {

                JOptionPane.showMessageDialog(
                        finePanel,
                        "Fine paid successfully.");

                clearForm();
                loadFines();

            } else {

                JOptionPane.showMessageDialog(
                        finePanel,
                        "Failed to pay fine. Check that the Return ID exists and the fine is not already paid.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    finePanel,
                    "Please enter a valid numeric Return ID.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ===========================
    // Load Fines
    // ===========================

    private void loadFines() {

        List<Fine> fines =
                fineService.getAllFines();

        DefaultTableModel model =
                (DefaultTableModel) finePanel
                        .getFineTable()
                        .getModel();

        model.setRowCount(0);

        for (Fine fine : fines) {

            model.addRow(new Object[] {
                    fine.getFineId(),
                    fine.getMemberId(),
                    fine.getReturnId(),
                    fine.getAmount(),
                    fine.getPaymentStatus()
            });
        }
    }

    // ===========================
    // Clear Form
    // ===========================

    private void clearForm() {

        finePanel.getTxtFineId().setText("");
        finePanel.getTxtMemberId().setText("");
        finePanel.getTxtReturnId().setText("");
        finePanel.getTxtAmount().setText("");
        finePanel.getTxtStatus().setText("");
    }
}
