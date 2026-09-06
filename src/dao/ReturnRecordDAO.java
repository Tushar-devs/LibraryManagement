package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.ReturnRecord;

public class ReturnRecordDAO {
	private ReturnRecord mapResultSetToReturnRecord(ResultSet rs) throws SQLException {
		ReturnRecord returnRecord = new ReturnRecord();

		returnRecord.setReturnId(rs.getInt("return_id"));
		returnRecord.setIssueId(rs.getInt("issue_id"));
		returnRecord.setReturnDate(rs.getDate("return_date").toLocalDate());
		returnRecord.setDaysLate(rs.getInt("days_late"));
		returnRecord.setFineAmount(rs.getDouble("fine_amount"));
		returnRecord.setRemarks(rs.getString("remarks"));

		return returnRecord;
	}

	public boolean returnBook(ReturnRecord returnRecord) {
		String sql = "INSERT INTO return_record (issue_id, return_date, days_late, fine_amount, remarks) "
				+ "VALUES (?, ?, ?, ?, ?)";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, returnRecord.getIssueId());
			ps.setDate(2, Date.valueOf(returnRecord.getReturnDate()));
			ps.setInt(3, returnRecord.getDaysLate());
			ps.setDouble(4, returnRecord.getFineAmount());
			ps.setString(5, returnRecord.getRemarks());

			int rowsAffected = ps.executeUpdate();

			ps.close();
			con.close();

			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ReturnRecord getReturnRecordById(int returnId) {
		String sql = "SELECT * FROM returnrecord WHERE return_id = ?";

		ReturnRecord returnRecord = null;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, returnId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				returnRecord = mapResultSetToReturnRecord(rs);
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnRecord;
	}

	public ReturnRecord getReturnRecordByIssueId(int issueId) {
		String sql = "SELECT * FROM returnrecord WHERE issue_id = ?";

		ReturnRecord returnRecord = null;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, issueId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				returnRecord = mapResultSetToReturnRecord(rs);
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnRecord;
	}
	public List<ReturnRecord> getReturnRecordsByMemberId(int memberId) {

	    String sql = "SELECT rr.* " +
	                 "FROM returnrecord rr " +
	                 "INNER JOIN issue_record ir ON rr.issue_id = ir.issue_id " +
	                 "WHERE ir.member_id = ?";

	    List<ReturnRecord> returnRecords = new ArrayList<>();

	    try {
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, memberId);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            returnRecords.add(mapResultSetToReturnRecord(rs));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return returnRecords;
	}

	public List<ReturnRecord> getAllReturnRecords() {
		String sql = "SELECT * FROM returnrecord";

		List<ReturnRecord> returnRecords = new ArrayList<>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				returnRecords.add(mapResultSetToReturnRecord(rs));
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnRecords;
	}
}
