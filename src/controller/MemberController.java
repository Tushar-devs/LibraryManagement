package controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Member;
import service.MemberService;
import view.panels.MemberPanel;

public class MemberController {

    private MemberPanel memberPanel;
    private MemberService memberService;

    public MemberController(MemberPanel memberPanel) {

        this.memberPanel = memberPanel;
        this.memberService = new MemberService();

        registerListeners();
        loadMembers();
    }

    // ===========================
    // Register Listeners
    // ===========================

    private void registerListeners() {

        memberPanel.getBtnAdd().addActionListener(e -> addMember());

        memberPanel.getBtnUpdate().addActionListener(e -> updateMember());

        memberPanel.getBtnDelete().addActionListener(e -> deleteMember());

        memberPanel.getBtnClear().addActionListener(e -> clearForm());
    }

    // ===========================
    // Add Member
    // ===========================

    private void addMember() {

        try {

            String name = memberPanel.getTxtName().getText().trim();
            String email = memberPanel.getTxtEmail().getText().trim();
            String phone = memberPanel.getTxtPhone().getText().trim();
            String address = memberPanel.getTxtAddress().getText().trim();
            String gender = memberPanel.getTxtGender().getText().trim();
            String courseOrClass = memberPanel.getTxtCourseOrClass().getText().trim();
            String department = memberPanel.getTxtDepartment().getText().trim();

            LocalDate dateOfBirth = LocalDate.parse(
                    memberPanel.getTxtDateOfBirth().getText().trim());

            Member member = new Member();

            member.setMemberName(name);
            member.setEmail(email);
            member.setPhoneNumber(phone);
            member.setAddress(address);
            member.setGender(gender);
            member.setCourseOrClass(courseOrClass);
            member.setDepartment(department);
            member.setDateOfBirth(dateOfBirth);
            member.setMembershipDate(LocalDate.now());

            boolean success = memberService.addMember(member);

            if (success) {

                JOptionPane.showMessageDialog(
                        memberPanel,
                        "Member added successfully.");

                clearForm();
                loadMembers();

            } else {

                JOptionPane.showMessageDialog(
                        memberPanel,
                        "Failed to add member.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (DateTimeParseException e) {

            JOptionPane.showMessageDialog(
                    memberPanel,
                    "Please enter Date of Birth in yyyy-mm-dd format.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ===========================
    // Update Member
    // ===========================

    private void updateMember() {

        try {

            int memberId = Integer.parseInt(
                    memberPanel.getTxtMemberId().getText().trim());

            Member existingMember =
                    memberService.getMemberById(memberId);

            if (existingMember == null) {

                JOptionPane.showMessageDialog(
                        memberPanel,
                        "Member not found.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            String name = memberPanel.getTxtName().getText().trim();
            String email = memberPanel.getTxtEmail().getText().trim();
            String phone = memberPanel.getTxtPhone().getText().trim();
            String address = memberPanel.getTxtAddress().getText().trim();
            String gender = memberPanel.getTxtGender().getText().trim();
            String courseOrClass = memberPanel.getTxtCourseOrClass().getText().trim();
            String department = memberPanel.getTxtDepartment().getText().trim();

            LocalDate dateOfBirth = LocalDate.parse(
                    memberPanel.getTxtDateOfBirth().getText().trim());

            existingMember.setMemberName(name);
            existingMember.setEmail(email);
            existingMember.setPhoneNumber(phone);
            existingMember.setAddress(address);
            existingMember.setGender(gender);
            existingMember.setCourseOrClass(courseOrClass);
            existingMember.setDepartment(department);
            existingMember.setDateOfBirth(dateOfBirth);
            /*
             * Preserve the original membership date; it is
             * system-controlled and not editable from this form.
             */

            boolean success =
                    memberService.updateMember(existingMember);

            if (success) {

                JOptionPane.showMessageDialog(
                        memberPanel,
                        "Member updated successfully.");

                clearForm();
                loadMembers();

            } else {

                JOptionPane.showMessageDialog(
                        memberPanel,
                        "Failed to update member.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    memberPanel,
                    "Please enter a valid numeric Member ID.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);

        } catch (DateTimeParseException e) {

            JOptionPane.showMessageDialog(
                    memberPanel,
                    "Please enter Date of Birth in yyyy-mm-dd format.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ===========================
    // Delete Member
    // ===========================

    private void deleteMember() {

        try {

            int memberId = Integer.parseInt(
                    memberPanel.getTxtMemberId().getText().trim());

            int choice = JOptionPane.showConfirmDialog(
                    memberPanel,
                    "Are you sure you want to delete this member?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION);

            if (choice != JOptionPane.YES_OPTION) {
                return;
            }

            boolean success =
                    memberService.deleteMember(memberId);

            if (success) {

                JOptionPane.showMessageDialog(
                        memberPanel,
                        "Member deleted successfully.");

                clearForm();
                loadMembers();

            } else {

                JOptionPane.showMessageDialog(
                        memberPanel,
                        "Member could not be deleted.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    memberPanel,
                    "Please enter a valid Member ID.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ===========================
    // Load Members
    // ===========================

    private void loadMembers() {

        List<Member> members =
                memberService.getAllMembers();

        DefaultTableModel model =
                (DefaultTableModel) memberPanel
                        .getMemberTable()
                        .getModel();

        model.setRowCount(0);

        for (Member member : members) {

            model.addRow(new Object[] {
                    member.getMemberId(),
                    member.getMemberName(),
                    member.getEmail(),
                    member.getPhoneNumber(),
                    member.getAddress()
            });
        }
    }

    // ===========================
    // Clear Form
    // ===========================

    private void clearForm() {

        memberPanel.getTxtMemberId().setText("");
        memberPanel.getTxtName().setText("");
        memberPanel.getTxtEmail().setText("");
        memberPanel.getTxtPhone().setText("");
        memberPanel.getTxtAddress().setText("");
        memberPanel.getTxtDateOfBirth().setText("");
        memberPanel.getTxtGender().setText("");
        memberPanel.getTxtCourseOrClass().setText("");
        memberPanel.getTxtDepartment().setText("");
    }
}
