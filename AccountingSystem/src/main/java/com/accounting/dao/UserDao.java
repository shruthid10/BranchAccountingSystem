package com.accounting.dao;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import com.accounting.beans.User;


public class UserDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

		
	public User findByUsernameAndPasswordAndRole(String username, String password, String role) {
	    String sql = "SELECT * FROM user WHERE username = ? AND password = ? AND role = ?";
	    List<User> users = jdbcTemplate.query(sql, new Object[]{username, password,role}, new BeanPropertyRowMapper<User>(User.class));
	    return users.isEmpty() ? null : users.get(0);
	}
	
	
	

	public void save(User user) {
        String sql = "INSERT INTO user (username, password,email,role) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(),user.getEmail(),user.getRole());
    }

	public boolean existsByEmail(String email) {
	    String sql = "SELECT COUNT(*) FROM user WHERE email = ?";
	    Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email);
	    return count != null && count > 0;
	}

	
	  public boolean existsByUsername(String username) {
		  String sql = "SELECT COUNT(*) FROM user WHERE username = ?"; Integer count =
	      jdbcTemplate.queryForObject(sql, Integer.class, username);
		  return count != null && count > 0; 
		  }
	 
}
