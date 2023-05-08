package com.accounting.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import com.accounting.beans.Student;

public class StudentDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Student s) {
		String sql = "INSERT INTO student (student_id, first_name, last_name, email,address,city,state,phone_number,course_name,branch_id) VALUES ('"
				+ s.getStudent_id() + "','" + s.getFirst_name() + "','" + s.getLast_name() + "','" + s.getEmail()
				+ "','" + s.getAddress() + "','" + s.getCity() + "','" + s.getState() + "','" + s.getPhone_number()
				+ "','" + s.getCourse_name() + "','" + s.getBranch_id() + "')";
		return template.update(sql);
	}

	public int update(Student s) {
		String sql = "update  student set first_name='" + s.getFirst_name() + "', last_name='" + s.getLast_name()
				+ "', email='" + s.getEmail() + "',address='" + s.getAddress() + "',city='" + s.getCity() + "',state='"
				+ s.getState() + "',phone_number='" + s.getPhone_number() + "',course_name='" + s.getCourse_name()
				+ "',branch_id='" + s.getBranch_id() + "'where student_id=" + s.getStudent_id() + "";

		return template.update(sql);
	}

	public List<Student> getStudents() {
		return template.query("select * from student", new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int row) throws SQLException {
				Student st = new Student();
				st.setStudent_id(rs.getInt(1));
				st.setFirst_name(rs.getString(2));
				st.setLast_name(rs.getString(3));
				st.setEmail(rs.getString(4));
				st.setAddress(rs.getString(5));
				st.setCity(rs.getString(6));
				st.setState(rs.getString(7));
				st.setPhone_number(rs.getString(8));
				st.setCourse_name(rs.getString(9));
				st.setBranch_id(rs.getInt(10));
				return st;

			}
		});
	}

	public Student getStudentById(int id) {
		String sql = "select * from student where student_id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Student>(Student.class));
	}

	public int delete(int id) {
	     String sql="update student set branch_id=NULL where student_id="+id;
		 template.update(sql);
		 String sql1 = "delete from student where student_id=" + id;
		 return template.update(sql1);
	}
}
