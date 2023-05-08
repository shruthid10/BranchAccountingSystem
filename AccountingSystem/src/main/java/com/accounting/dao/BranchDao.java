package com.accounting.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper; 


import com.accounting.beans.Branch;


public class BranchDao  {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public int save(Branch b) {
		String sql = "INSERT INTO branch (branch_name, address, city, state) VALUES ('" + b.getBranch_name() + "','"
				+ b.getAddress() + "','" + b.getCity() + "','" + b.getState() + "')";
		return template.update(sql);
	}

	public int update(Branch b) {

		String sql = "update branch set branch_name='" + b.getBranch_name() + "',address='" + b.getAddress()
				+ "',city='" + b.getCity() + "',state='" + b.getState() + "' where branch_id=" +b.getBranch_id()+"";
	
		return template.update(sql);
	}

	
	public List<Branch> getBranches() {
		return template.query("select * from branch", new RowMapper<Branch>() {
			public Branch mapRow(ResultSet rs, int row) throws SQLException {
				Branch br = new Branch();
				br.setBranch_id(rs.getInt(1));
				br.setBranch_name(rs.getString(2));
				br.setAddress(rs.getString(3));
				br.setCity(rs.getString(4));
				br.setState(rs.getString(5));
				return br;
				
				
			}
		});
	}
	public Branch getBranchById(int id){  
	    String sql="select * from branch where branch_id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Branch>(Branch.class));  
	}  
	
	public int delete(int id){  
	    String sql="delete from branch where branch_id="+id+"";  
	    return template.update(sql);  
	}  
	
}
