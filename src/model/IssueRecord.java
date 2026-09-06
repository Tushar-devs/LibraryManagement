package model;

import java.time.LocalDate;

public class IssueRecord {
	private int issueId;
	private int bookId;
	private int memberId;
	private int userId;
	private LocalDate issueDate;
	private LocalDate dueDate;
	private String remarks;

	public IssueRecord() {

	}

	public IssueRecord(int issueId, int bookId, int memberId, int userId, LocalDate issueDate, LocalDate dueDate,
			String remarks) {
		this.issueId = issueId;
		this.bookId = bookId;
		this.memberId = memberId;
		this.userId = userId;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.remarks = remarks;
	}

	public IssueRecord(int bookId, int memberId, int userId, LocalDate issueDate, LocalDate dueDate,
			String remarks) {
		this.bookId = bookId;
		this.memberId = memberId;
		this.userId = userId;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.remarks = remarks;
	}


	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "IssueRecord [issueId=" + issueId + ", bookId=" + bookId + ", memberId=" + memberId + ", userId="
				+ userId + ", issueDate=" + issueDate + ", dueDate=" + dueDate + ", remarks=" + remarks + "]";
	}

}
