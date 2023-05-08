package com.accounting.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.accounting.beans.Accountant;


public class AccountantDao  {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	public int saveaccountant(Accountant a) { 
	String sql = "INSERT INTO accountant (accountant_id, first_name, last_name, email,salary,branch_id) VALUES ('"
	  + a.getAccountant_id() + "','" + a.getFirst_name() + "','" + a.getLast_name() + "','" +
	  a.getEmail() + "','" + a.getSalary() + "','" + a.getBranch_id() + "')"; 
	return template.update(sql); 
	  }
	 
	public List<Accountant> getAccountants() {
		return template.query("select * from accountant", new RowMapper<Accountant>() {
			public Accountant mapRow(ResultSet rs, int row) throws SQLException {
				Accountant acc = new Accountant();
				acc.setAccountant_id(rs.getInt(1));
				acc.setFirst_name(rs.getString(2));
				acc.setLast_name(rs.getString(3));
				acc.setEmail(rs.getString(4));
				acc.setSalary(rs.getFloat(5));
				acc.setBranch_id(rs.getInt(6));
				return acc;
					
			}
		});
	}
	
	public int update(Accountant a) {
  String sql ="update accountant set first_name='" + a.getFirst_name() + "',last_name='" + a.getLast_name()+"',email='" +a.getEmail() +"',salary='" +a.getSalary()
        +"',branch_id='" +a.getBranch_id()+ "' where accountant_id=" +a.getAccountant_id() +"";
		return template.update(sql);
	}
	
	public Accountant getAccountantById(int id){  
	    String sql="select * from accountant where accountant_id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Accountant>(Accountant.class));  
	}  
	
	public int delete(int id){  
		String sql="update accountant set branch_id=NULL where accountant_id="+id;
		template.update(sql);
		String sql1="delete from accountant where accountant_id="+id+"";  
	    return template.update(sql1);  
	}  

	 public boolean existsByEmail(String email) {
	        String sql = "SELECT COUNT(*) FROM accountant WHERE email = ?";
	        Integer count = template.queryForObject(sql, Integer.class, email);
	        return count != null && count > 0;
	    }
}
