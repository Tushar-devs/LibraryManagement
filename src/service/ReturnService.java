package service;

import dao.BookDAO;
import dao.IssueRecordDAO;
import dao.ReturnRecordDAO;
import java.time.LocalDate;
import java.util.List;

import model.Book;
import model.IssueRecord;
import model.ReturnRecord;

public class ReturnService {

	private BookDAO bookDAO;
	private IssueRecordDAO issueRecordDAO;
	private ReturnRecordDAO returnRecordDAO;
	private FineService fineService;

	public ReturnService() {
		bookDAO = new BookDAO();
		issueRecordDAO = new IssueRecordDAO();
		returnRecordDAO = new ReturnRecordDAO();
		fineService = new FineService();
	}

	public boolean returnBook(int issueId) {

		IssueRecord issueRecord = issueRecordDAO.getIssueRecordById(issueId);

		if (issueRecord == null) {
			System.out.println("Issue record not found.");
			return false;
		}

		if (isBookReturned(issueId)) {
			System.out.println("Book has already been returned.");
			return false;
		}

		Book book = bookDAO.getBookById(issueRecord.getBookId());

		if (book == null) {
			System.out.println("Book not found.");
			return false;
		}

		ReturnRecord returnRecord = new ReturnRecord();
		returnRecord.setIssueId(issueId);
		returnRecord.setReturnDate(LocalDate.now());
		returnRecord.setDaysLate(0);
		returnRecord.setFineAmount(0);
		returnRecord.setRemarks("Book Returned");

		boolean returned = returnRecordDAO.returnBook(returnRecord);

		if (returned) {
			book.setAvailableCopies(book.getAvailableCopies() + 1);
			bookDAO.updateBook(book);

			fineService.generateFine(issueRecord, returnRecord);

			System.out.println("Book returned successfully.");
			return true;
		}

		System.out.println("Failed to return book.");
		return false;
	}

	private boolean isBookReturned(int issueId) {
		return returnRecordDAO.getReturnRecordByIssueId(issueId) != null;
	}

	public ReturnRecord getReturnRecordById(int returnId) {
		return returnRecordDAO.getReturnRecordById(returnId);
	}

	public List<ReturnRecord> getAllReturnRecords() {
		return returnRecordDAO.getAllReturnRecords();
	}

	public List<ReturnRecord> getReturnRecordsByMemberId(int memberId) {
		return returnRecordDAO.getReturnRecordsByMemberId(memberId);
	}

}