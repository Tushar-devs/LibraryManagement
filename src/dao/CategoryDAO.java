package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.Category;

public class CategoryDAO {
	public boolean addCategory(Category category) {
		String sql = "INSERT INTO category(category_name, category_description) VALUES(?, ?)";
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getCategoryName());
			ps.setString(2, category.getCategoryDescription());
			int rowsAffected = ps.executeUpdate();
			ps.close();
			con.close();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Category getCategoryById(int categoryId) {
		String sql = "SELECT * FROM category WHERE category_id = ?";
		Category category = null;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				category = new Category();
				category.setCategoryId(rs.getInt("category_id"));
				category.setCategoryName(rs.getString("category_name"));
			    category.setCategoryDescription(rs.getString("category_description"));

			}
		
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return category;
	}
	public Category getCategoryByName(String categoryName) {
	    String sql = "SELECT * FROM category WHERE category_name = ?";

	    Category category = null;

	    try {
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, categoryName);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            category = new Category();

	            category.setCategoryId(rs.getInt("category_id"));
	            category.setCategoryName(rs.getString("category_name"));
	            category.setCategoryDescription(rs.getString("category_description"));

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return category;
	}
	
	public List<Category> getAllCategories(){
		String sql = "SELECT * FROM category";
		ArrayList<Category> categories = new ArrayList<>();
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			

			while(rs.next()) {
				Category category = new Category();
				category.setCategoryId(rs.getInt("category_id"));
				category.setCategoryName(rs.getString("category_name"));
				category.setCategoryDescription(rs.getString("category_description"));
				categories.add(category);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}
	public boolean deleteCategory(int categoryId) {
		String sql = "DELETE FROM category WHERE category_id = ?";
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			int rowsAffected = ps.executeUpdate();
			ps.close();
			con.close();
			return (rowsAffected>0);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
