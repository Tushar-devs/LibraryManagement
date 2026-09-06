package service;

import dao.FineDAO;
import model.Fine;
import model.IssueRecord;
import model.ReturnRecord;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class FineService {

	private FineDAO fineDAO;

	public FineService() {
		fineDAO = new FineDAO();
	}

	public double calculateFine(LocalDate dueDate, LocalDate returnDate) {

		if (returnDate.isBefore(dueDate) || returnDate.isEqual(dueDate)) {
			return 0;
		}

		long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);

		return daysLate * 5.0;

	}

	public Fine generateFine(IssueRecord issueRecord, ReturnRecord returnRecord) {

		long daysLate = ChronoUnit.DAYS.between(issueRecord.getDueDate(), returnRecord.getReturnDate());

		if (daysLate < 0) {
			daysLate = 0;
		}

		double fineAmount = calculateFine(issueRecord.getDueDate(), returnRecord.getReturnDate());

		returnRecord.setDaysLate((int) daysLate);
		returnRecord.setFineAmount(fineAmount);

		Fine fine = new Fine();

		fine.setMemberId(issueRecord.getMemberId());
		fine.setAmount(fineAmount);
		fine.setFineReason(daysLate > 0 ? "Late Return" : "No Fine");
		fine.setPaymentStatus("Pending");
		fine.setPaymentDate(null);

		if (fineAmount > 0) {
			fineDAO.addFine(fine);
		}

		return fine;
	}

	public Fine getFineByReturnId(int returnId) {
		return fineDAO.getFineByReturnId(returnId);
	}

	public List<Fine> getAllFines() {
		return fineDAO.getAllFines();
	}

	public List<Fine> getFinesByMemberId(int memberId) {
		return fineDAO.getFinesByMemberId(memberId);
	}

	public boolean payFine(int returnId, int userId) {

		Fine fine = fineDAO.getFineByReturnId(returnId);

		if (fine == null) {
			System.out.println("Fine not found.");
			return false;
		}

		if ("Paid".equalsIgnoreCase(fine.getPaymentStatus())) {
			System.out.println("Fine has already been paid.");
			return false;
		}

		fine.setPaymentStatus("Paid");
		fine.setPaymentDate(LocalDate.now());
		fine.setCollectedBy(userId);

		return fineDAO.updateFine(fine);
	}

}