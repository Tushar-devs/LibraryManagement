package model;

import java.time.LocalDate;

public class ReturnRecord {
	private int returnId;
	private int issueId;
	private LocalDate returnDate;
	private int daysLate;
	private double fineAmount;
	private String remarks;

	public ReturnRecord() {

	}

	public ReturnRecord(int returnId, int issueId, LocalDate returnDate, int daysLate, double fineAmount,
			String remarks) {
		this.returnId = returnId;
		this.issueId = issueId;
		this.returnDate = returnDate;
		this.daysLate = daysLate;
		this.fineAmount = fineAmount;
		this.remarks = remarks;
	}
	
	public ReturnRecord(int issueId, LocalDate returnDate, int daysLate, double fineAmount,
			String remarks) {
		this.issueId = issueId;
		this.returnDate = returnDate;
		this.daysLate = daysLate;
		this.fineAmount = fineAmount;
		this.remarks = remarks;
	}


	public int getReturnId() {
		return returnId;
	}

	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public int getDaysLate() {
		return daysLate;
	}

	public void setDaysLate(int daysLate) {
		this.daysLate = daysLate;
	}

	public double getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "ReturnRecord [returnId=" + returnId + ", issueId=" + issueId + ", returnDate=" + returnDate
				+ ", daysLate=" + daysLate + ", fineAmount=" + fineAmount + ", remarks=" + remarks + "]";
	}

}
