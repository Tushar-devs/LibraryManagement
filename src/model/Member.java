package model;

import java.time.LocalDate;

public class Member {
	private int memberId;
	private String memberName;
	private String fatherName;
	private String gender;
	private LocalDate dateOfBirth;
	private String courseOrClass;
	private String department;
	private int semester;
	private String address;
	private String city;
	private String state;
	private String phoneNumber;
	private String email;
	private LocalDate membershipDate;

	public Member() {

	}

	public Member(int memberId, String memberName, String fatherName, String gender, LocalDate dateOfBirth,
			String courseOrClass, String department, int semester, String address, String city, String state,
			String phoneNumber, String email, LocalDate membershipDate) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.fatherName = fatherName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.courseOrClass = courseOrClass;
		this.department = department;
		this.semester = semester;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.membershipDate = membershipDate;
	}
	public Member(String memberName, String fatherName, String gender, LocalDate dateOfBirth,
			String courseOrClass, String department, int semester, String address, String city, String state,
			String phoneNumber, String email, LocalDate membershipDate) {
		this.memberName = memberName;
		this.fatherName = fatherName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.courseOrClass = courseOrClass;
		this.department = department;
		this.semester = semester;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.membershipDate = membershipDate;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCourseOrClass() {
		return courseOrClass;
	}

	public void setCourseOrClass(String courseOrClass) {
		this.courseOrClass = courseOrClass;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getMembershipDate() {
		return membershipDate;
	}

	public void setMembershipDate(LocalDate membershipDate) {
		this.membershipDate = membershipDate;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", fatherName=" + fatherName
				+ ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", courseOrClass=" + courseOrClass
				+ ", department=" + department + ", semester=" + semester + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", phoneNumber=" + phoneNumber + ", email=" + email + ", membershipDate="
				+ membershipDate + "]";
	}

}
