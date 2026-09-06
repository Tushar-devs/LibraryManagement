package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.IssueRecord;

public class IssueRecordDAO {
	private IssueRecord mapResultSetToIssueRecord(ResultSet rs) throws SQLException {
		IssueRecord issueRecord = new IssueRecord();

		issueRecord.setIssueId(rs.getInt("issue_id"));
		issueRecord.setBookId(rs.getInt("book_id"));
		issueRecord.setMemberId(rs.getInt("member_id"));
		issueRecord.setUserId(rs.getInt("user_id"));
		issueRecord.setIssueDate(rs.getDate("issue_date").toLocalDate());
		issueRecord.setDueDate(rs.getDate("due_date").toLocalDate());
		issueRecord.setRemarks(rs.getString("remarks"));

		return issueRecord;
	}

	public boolean issueBook(IssueRecord issueRecord) {
		String sql = "INSERT INTO issue_record (book_id, member_id, user_id, issue_date, due_date, remarks) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, issueRecord.getBookId());
			ps.setInt(2, issueRecord.getMemberId());
			ps.setInt(3, issueRecord.getUserId());
			ps.setDate(4, Date.valueOf(issueRecord.getIssueDate()));
			ps.setDate(5, Date.valueOf(issueRecord.getDueDate()));
			ps.setString(6, issueRecord.getRemarks());

			int rowsAffected = ps.executeUpdate();

			ps.close();
			con.close();

			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public IssueRecord getIssueRecordById(int issueId) {
		String sql = "SELECT * FROM issuerecord WHERE issue_id = ?";

		IssueRecord issueRecord = null;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, issueId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				issueRecord = mapResultSetToIssueRecord(rs);
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return issueRecord;
	}

	public List<IssueRecord> getAllIssueRecords() {
		String sql = "SELECT * FROM issuerecord";

		List<IssueRecord> issueRecords = new ArrayList<>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				issueRecords.add(mapResultSetToIssueRecord(rs));
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return issueRecords;
	}

	public List<IssueRecord> getIssueRecordsByBookId(int bookId) {
		String sql = "SELECT * FROM issuerecord WHERE book_id = ?";

		List<IssueRecord> issueRecords = new ArrayList<>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, bookId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				issueRecords.add(mapResultSetToIssueRecord(rs));
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return issueRecords;
	}

	public List<IssueRecord> getIssueRecordsByMemberId(int memberId) {
		String sql = "SELECT * FROM issuerecord WHERE member_id = ?";

		List<IssueRecord> issueRecords = new ArrayList<>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, memberId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				issueRecords.add(mapResultSetToIssueRecord(rs));
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return issueRecords;
	}
}
