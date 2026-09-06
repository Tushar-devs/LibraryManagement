package service;

import dao.BookDAO;
import dao.IssueRecordDAO;
import dao.MemberDAO;
import dao.UserDAO;
import java.time.LocalDate;
import model.Book;
import model.Member;
import model.User;
import model.IssueRecord;

import java.util.ArrayList;
import java.util.List;

public class IssueService {

	private BookDAO bookDAO;
	private MemberDAO memberDAO;
	private UserDAO userDAO;
	private IssueRecordDAO issueRecordDAO;

	public IssueService() {
		bookDAO = new BookDAO();
		memberDAO = new MemberDAO();
		userDAO = new UserDAO();
		issueRecordDAO = new IssueRecordDAO();
	}

	public boolean issueBook(int bookId, int memberId, int userId) {

		Book book = bookDAO.getBookById(bookId);
		if (book == null) {
			System.out.println("Book not found.");
			return false;
		}

		Member member = memberDAO.getMemberById(memberId);
		if (member == null) {
			System.out.println("Member not found.");
			return false;
		}

		User user = userDAO.getUserById(userId);
		if (user == null) {
			System.out.println("User not found.");
			return false;
		}

		if (book.getAvailableCopies() <= 0) {
			System.out.println("Book is currently unavailable.");
			return false;
		}

		IssueRecord issueRecord = new IssueRecord();
		issueRecord.setBookId(bookId);
		issueRecord.setMemberId(memberId);
		issueRecord.setUserId(userId);
		issueRecord.setIssueDate(LocalDate.now());
		issueRecord.setDueDate(LocalDate.now().plusDays(14)); // 14-day borrowing period
		issueRecord.setRemarks("Book Issued");

		boolean issued = issueRecordDAO.issueBook(issueRecord);

		if (issued) {
			book.setAvailableCopies(book.getAvailableCopies() - 1);
			bookDAO.updateBook(book);
			System.out.println("Book issued successfully.");
			return true;
		}

		System.out.println("Failed to issue book.");
		return false;
	}

	public IssueRecord getIssueRecordById(int issueId) {
		return issueRecordDAO.getIssueRecordById(issueId);
	}

	public List<IssueRecord> getAllIssueRecords() {
		return issueRecordDAO.getAllIssueRecords();
	}

	public List<IssueRecord> getIssueRecordsByMemberId(int memberId) {

		Member member = memberDAO.getMemberById(memberId);

		if (member == null) {
			System.out.println("Member not found.");
			return new ArrayList<>();
		}

		return issueRecordDAO.getIssueRecordsByMemberId(memberId);
	}

	public List<IssueRecord> getIssueRecordsByBookId(int bookId) {

		Book book = bookDAO.getBookById(bookId);

		if (book == null) {
			System.out.println("Book not found.");
			return new ArrayList<>();
		}

		return issueRecordDAO.getIssueRecordsByBookId(bookId);
	}

}