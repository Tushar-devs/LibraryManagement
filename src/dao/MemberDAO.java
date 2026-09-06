package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.Member;

public class MemberDAO {
	public boolean addMember(Member member) {
		String sql = "INSERT INTO member (member_name, father_name, gender, date_of_birth, "
				+ "course_or_class, department, semester, address, city, state, "
				+ "phone_number, email, membership_date) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, member.getMemberName());
			ps.setString(2, member.getFatherName());
			ps.setString(3, member.getGender());
			ps.setDate(4, Date.valueOf(member.getDateOfBirth()));
			ps.setString(5, member.getCourseOrClass());
			ps.setString(6, member.getDepartment());
			ps.setInt(7, member.getSemester());
			ps.setString(8, member.getAddress());
			ps.setString(9, member.getCity());
			ps.setString(10, member.getState());
			ps.setString(11, member.getPhoneNumber());
			ps.setString(12, member.getEmail());
			ps.setDate(13, Date.valueOf(member.getMembershipDate()));
			int rowsAffected = ps.executeUpdate();

			ps.close();
			con.close();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	private Member mapResultSetToMember(ResultSet rs) throws SQLException {
		Member member = new Member();

		member.setMemberId(rs.getInt("member_id"));
		member.setMemberName(rs.getString("member_name"));
		member.setFatherName(rs.getString("father_name"));
		member.setGender(rs.getString("gender"));
		member.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
		member.setCourseOrClass(rs.getString("course_or_class"));
		member.setDepartment(rs.getString("department"));
		member.setSemester(rs.getInt("semester"));
		member.setAddress(rs.getString("address"));
		member.setCity(rs.getString("city"));
		member.setState(rs.getString("state"));
		member.setPhoneNumber(rs.getString("phone_number"));
		member.setEmail(rs.getString("email"));
		member.setMembershipDate(rs.getDate("membership_date").toLocalDate());

		return member;
	}

	public Member getMemberById(int memberId) {
		String sql = "SELECT * FROM member WHERE member_id = ?";

		Member member = null;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, memberId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				member = mapResultSetToMember(rs);
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}

	public Member getMemberByEmail(String email) {
		String sql = "SELECT * FROM member WHERE email = ?";

		Member member = null;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				member = mapResultSetToMember(rs);
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}

	public List<Member> getAllMembers() {
		String sql = "SELECT * FROM member";

		List<Member> members = new ArrayList<>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				members.add(mapResultSetToMember(rs));
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return members;
	}

	public List<Member> searchMembersByName(String memberName) {
		String sql = "SELECT * FROM member WHERE member_name LIKE ?";

		List<Member> members = new ArrayList<>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, "%" + memberName + "%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				members.add(mapResultSetToMember(rs));
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return members;
	}

	public boolean updateMember(Member member) {
		String sql = "UPDATE member SET member_name = ?, father_name = ?, gender = ?, "
				+ "date_of_birth = ?, course_or_class = ?, department = ?, semester = ?, "
				+ "address = ?, city = ?, state = ?, phone_number = ?, email = ?, "
				+ "membership_date = ? WHERE member_id = ?";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, member.getMemberName());
			ps.setString(2, member.getFatherName());
			ps.setString(3, member.getGender());
			ps.setDate(4, Date.valueOf(member.getDateOfBirth()));
			ps.setString(5, member.getCourseOrClass());
			ps.setString(6, member.getDepartment());
			ps.setInt(7, member.getSemester());
			ps.setString(8, member.getAddress());
			ps.setString(9, member.getCity());
			ps.setString(10, member.getState());
			ps.setString(11, member.getPhoneNumber());
			ps.setString(12, member.getEmail());
			ps.setDate(13, Date.valueOf(member.getMembershipDate()));
			ps.setInt(14, member.getMemberId());

			int rowsAffected = ps.executeUpdate();

			ps.close();
			con.close();

			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteMember(int memberId) {
		String sql = "DELETE FROM member WHERE member_id = ?";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, memberId);

			int rowsAffected = ps.executeUpdate();

			ps.close();
			con.close();

			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
