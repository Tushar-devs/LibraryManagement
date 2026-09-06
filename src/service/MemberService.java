package service;

import java.util.ArrayList;
import java.util.List;

import dao.IssueRecordDAO;
import dao.MemberDAO;
import dao.ReturnRecordDAO;
import model.IssueRecord;
import model.Member;
import model.ReturnRecord;

public class MemberService {

	private MemberDAO memberDAO;
	private IssueRecordDAO issueRecordDAO;
	private ReturnRecordDAO returnRecordDAO;

	public MemberService() {
		memberDAO = new MemberDAO();
		issueRecordDAO = new IssueRecordDAO();
		returnRecordDAO = new ReturnRecordDAO();
	}

	public boolean addMember(Member member) {

		if (member == null) {
			System.out.println("Member details cannot be null.");
			return false;
		}

		if (member.getMemberName() == null || member.getMemberName().trim().isEmpty()) {
			System.out.println("Member name cannot be empty.");
			return false;
		}

		if (member.getPhoneNumber() == null || member.getPhoneNumber().trim().isEmpty()) {
			System.out.println("Phone number cannot be empty.");
			return false;
		}

		if (member.getEmail() == null || member.getEmail().trim().isEmpty()) {
			System.out.println("Email cannot be empty.");
			return false;
		}

		return memberDAO.addMember(member);
	}

	public Member getMemberById(int memberId) {

		if (memberId <= 0) {
			System.out.println("Invalid member ID.");
			return null;
		}

		return memberDAO.getMemberById(memberId);
	}

	public List<Member> getAllMembers() {
		return memberDAO.getAllMembers();
	}

	public List<Member> searchMembersByName(String memberName) {

		if (memberName == null || memberName.trim().isEmpty()) {
			System.out.println("Member name cannot be empty.");
			return new ArrayList<>();
		}

		return memberDAO.searchMembersByName(memberName);
	}

	public boolean updateMember(Member member) {

		if (member == null) {
			System.out.println("Member details cannot be null.");
			return false;
		}

		if (member.getMemberId() <= 0) {
			System.out.println("Invalid member ID.");
			return false;
		}

		if (member.getMemberName() == null || member.getMemberName().trim().isEmpty()) {
			System.out.println("Member name cannot be empty.");
			return false;
		}

		if (member.getPhoneNumber() == null || member.getPhoneNumber().trim().isEmpty()) {
			System.out.println("Phone number cannot be empty.");
			return false;
		}

		if (member.getEmail() == null || member.getEmail().trim().isEmpty()) {
			System.out.println("Email cannot be empty.");
			return false;
		}

		return memberDAO.updateMember(member);
	}

	public boolean deleteMember(int memberId) {

		if (memberId <= 0) {
			System.out.println("Invalid member ID.");
			return false;
		}

		Member member = memberDAO.getMemberById(memberId);

		if (member == null) {
			System.out.println("Member not found.");
			return false;
		}

		List<IssueRecord> issueRecords = issueRecordDAO.getIssueRecordsByMemberId(memberId);

		for (IssueRecord issueRecord : issueRecords) {

			ReturnRecord returnRecord = returnRecordDAO.getReturnRecordByIssueId(issueRecord.getIssueId());

			if (returnRecord == null) {
				System.out.println("Cannot delete member. Member has issued books that have not been returned.");
				return false;
			}
		}

		return memberDAO.deleteMember(memberId);
	}
}