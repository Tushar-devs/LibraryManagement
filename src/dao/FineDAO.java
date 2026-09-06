package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.Fine;

public class FineDAO {
	private Fine mapResultSetToFine(ResultSet rs) throws SQLException {
		Fine fine = new Fine();

		fine.setFineId(rs.getInt("fine_id"));
		fine.setReturnId(rs.getInt("return_id"));
		fine.setMemberId(rs.getInt("member_id"));
		fine.setAmount(rs.getDouble("amount"));
		fine.setFineReason(rs.getString("fine_reason"));
		fine.setPaymentStatus(rs.getString("payment_status"));

		java.sql.Date paymentDate = rs.getDate("payment_date");
		if (paymentDate != null) {
			fine.setPaymentDate(paymentDate.toLocalDate());
		}

		fine.setCollectedBy(rs.getInt("collected_by"));

		return fine;
	}

	public boolean addFine(Fine fine) {
		String sql = "INSERT INTO fine (return_id, member_id, amount, fine_reason, payment_status, payment_date, collected_by) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, fine.getReturnId());
			ps.setInt(2, fine.getMemberId());
			ps.setDouble(3, fine.getAmount());
			ps.setString(4, fine.getFineReason());
			ps.setString(5, fine.getPaymentStatus());

			if (fine.getPaymentDate() != null) {
				ps.setDate(6, Date.valueOf(fine.getPaymentDate()));
			} else {
				ps.setNull(6, Types.DATE);
			}

			ps.setInt(7, fine.getCollectedBy());

			int rowsAffected = ps.executeUpdate();

			ps.close();
			con.close();

			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Fine getFineByReturnId(int returnId) {
		String sql = "SELECT * FROM fine WHERE return_id = ?";

		Fine fine = null;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, returnId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				fine = mapResultSetToFine(rs);
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fine;
	}
	public List<Fine> getFinesByMemberId(int memberId) {

	    String sql = "SELECT * FROM fine WHERE member_id = ?";
	    List<Fine> fines = new ArrayList<>();

	    try {
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, memberId);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            fines.add(mapResultSetToFine(rs));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return fines;
	}

	public List<Fine> getAllFines() {
		String sql = "SELECT * FROM fine";

		List<Fine> fines = new ArrayList<>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				fines.add(mapResultSetToFine(rs));
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fines;
	}

	public boolean updateFine(Fine fine) {
		String sql = "UPDATE fine SET return_id = ?, member_id = ?, amount = ?, fine_reason = ?, "
				+ "payment_status = ?, payment_date = ?, collected_by = ? WHERE fine_id = ?";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, fine.getReturnId());
			ps.setInt(2, fine.getMemberId());
			ps.setDouble(3, fine.getAmount());
			ps.setString(4, fine.getFineReason());
			ps.setString(5, fine.getPaymentStatus());

			if (fine.getPaymentDate() != null) {
				ps.setDate(6, Date.valueOf(fine.getPaymentDate()));
			} else {
				ps.setNull(6, Types.DATE);
			}

			ps.setInt(7, fine.getCollectedBy());
			ps.setInt(8, fine.getFineId());

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
