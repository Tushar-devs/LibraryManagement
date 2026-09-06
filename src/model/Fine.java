package model;

import java.time.LocalDate;

public class Fine {
	private int fineId;
	private int returnId;
	private int memberId;
	private double amount;
	private String fineReason;
	private String paymentStatus;
	private LocalDate paymentDate;
	private int collectedBy;

	public Fine() {

	}

	public Fine(int fineId, int returnId, int memberId, double amount, String fineReason, String paymentStatus,
			LocalDate paymentDate, int collectedBy) {
		this.fineId = fineId;
		this.returnId = returnId;
		this.memberId = memberId;
		this.amount = amount;
		this.fineReason = fineReason;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
		this.collectedBy = collectedBy;
	}
	public Fine(int returnId, int memberId, double amount, String fineReason, String paymentStatus,
			LocalDate paymentDate, int collectedBy) {
		this.returnId = returnId;
		this.memberId = memberId;
		this.amount = amount;
		this.fineReason = fineReason;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
		this.collectedBy = collectedBy;
	}


	public int getFineId() {
		return fineId;
	}

	public void setFineId(int fineId) {
		this.fineId = fineId;
	}

	public int getReturnId() {
		return returnId;
	}

	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getFineReason() {
		return fineReason;
	}

	public void setFineReason(String fineReason) {
		this.fineReason = fineReason;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getCollectedBy() {
		return collectedBy;
	}

	public void setCollectedBy(int collectedBy) {
		this.collectedBy = collectedBy;
	}

	@Override
	public String toString() {
		return "Fine [fineId=" + fineId + ", returnId=" + returnId + ", memberId=" + memberId + ", amount=" + amount
				+ ", fineReason=" + fineReason + ", paymentStatus=" + paymentStatus + ", paymentDate=" + paymentDate
				+ ", collectedBy=" + collectedBy + "]";
	}

}
