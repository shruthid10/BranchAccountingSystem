package com.accounting.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.accounting.beans.Accountant;
import com.accounting.beans.Branch;

public class BranchDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Branch b) {

		String sql = "INSERT INTO branch ( branch_name, branch_location, state) VALUES ('" + b.getBranch_name() + "','"
				+ b.getBranch_location() + "','" + b.getState() + "')";

		return template.update(sql);
	}

	public int update(Branch b) {

		String sql = "update branch set branch_name='" + b.getBranch_name() + "',branch_location='"
				+ b.getBranch_location() + "',state='" + b.getState() + "' where branch_id=" + b.getBranch_id() + "";

		return template.update(sql);
	}

	public List<Branch> getBranches() {
		return template.query("select * from branch", new RowMapper<Branch>() {
			public Branch mapRow(ResultSet rs, int row) throws SQLException {
				Branch br = new Branch();
				br.setBranch_id(rs.getInt(1));
				br.setBranch_name(rs.getString(2));
				br.setBranch_location(rs.getString(3));
				br.setState(rs.getString(4));
				return br;

			}
		});
	}

	public List<Branch> getAllBranches() {
		List<Branch> branches = template.query("SELECT DISTINCT branch_id, branch_name FROM branch",
				new BeanPropertyRowMapper<Branch>(Branch.class));
		return branches;
	}

	public Branch getBranchById(int id) {
		String sql = "select * from branch where branch_id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Branch>(Branch.class));
	}

	public int delete(int id) {
		String sql = "UPDATE branch SET branch_id = null WHERE branch_id =" + id;
		template.update(sql);
		String sql1 = "DELETE FROM branch WHERE branch_id =" + id;
		return template.update(sql1);

	}

	public List<Accountant> getAccountantsByBranch(int branchId) {
		String sql = "SELECT a.*, b.branch_name FROM Accountant a JOIN Branch b ON a.branch_id = b.branch_id WHERE a.branch_id = ?";
		return template.query(sql, new Object[] { branchId }, new RowMapper<Accountant>() {

			public Accountant mapRow(ResultSet rs, int rowNum) throws SQLException {
				Accountant accountant = new Accountant();
				accountant.setAccountant_id(rs.getInt("accountant_id"));
				accountant.setFirst_name(rs.getString("first_name"));
				accountant.setLast_name(rs.getString("last_name"));
				accountant.setEmail(rs.getString("email"));
				accountant.setSalary(rs.getFloat("salary"));
				accountant.setBranch_id(rs.getInt("branch_id"));
				accountant.setBranch_name(rs.getString("branch_name"));

				return accountant;
			}
		});
	}

	public boolean getBranchByBranchName(String branchName) {
		String sql = "SELECT COUNT(*) FROM branch WHERE branch_name = ?";
		int count = template.queryForObject(sql, Integer.class, branchName);
		return count > 0;
	}

}
