package com.accounting.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
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
		String sql = "INSERT INTO student (student_id, first_name, last_name, email,address,city,state,phone_number,course_id,payment_status,branch_id) VALUES ('"
				+ s.getStudent_id() + "','" + s.getFirst_name() + "','" + s.getLast_name() + "','" + s.getEmail()
				+ "','" + s.getAddress() + "','" + s.getCity() + "','" + s.getState() + "','" + s.getPhone_number()
				+ "','" + s.getCourse_id() + "','" + 0 + "','" + s.getBranch_id() + "')";
		System.out.println(s.isPayment_status());
		return template.update(sql);
	}

	public int update(Student s) {
		String sql = "update  student set first_name='" + s.getFirst_name() + "', last_name='" + s.getLast_name()
				+ "', email='" + s.getEmail() + "',address='" + s.getAddress() + "',city='" + s.getCity() + "',state='"
				+ s.getState() + "',phone_number='" + s.getPhone_number() + "',course_id='" + s.getCourse_id()
				+ "',payment_status='" + (s.isPayment_status() ? 1 : 0) + "',branch_id='" + s.getBranch_id()
				+ "'where student_id=" + s.getStudent_id() + "";

		return template.update(sql);
	}

	public List<Student> getStudents() {
		return template.query("select * from student", new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int row) throws SQLException {
				Student st = new Student();
				System.out.print(rs.getBoolean(10));
				st.setStudent_id(rs.getInt(1));
				st.setFirst_name(rs.getString(2));
				st.setLast_name(rs.getString(3));
				st.setEmail(rs.getString(4));
				st.setAddress(rs.getString(5));
				st.setCity(rs.getString(6));
				st.setState(rs.getString(7));
				st.setPhone_number(rs.getString(8));
				st.setCourse_id(rs.getInt(10));
				st.setPayment_status(rs.getBoolean(11));
				st.setBranch_id(rs.getInt(9));
				return st;

			}
		});
	}

	public Student getStudentById(int id) {
		String sql = "select * from student where student_id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Student>(Student.class));
	}

	public List<Student> searchStudentsByCourseName(String courseName) {
		String sql = "SELECT s.*, c.name, b.branch_name " + "FROM Student s "
				+ "JOIN Course c ON s.course_id = c.course_id " + "JOIN Branch b ON s.branch_id = b.branch_id "
				+ "WHERE c.name = ?";
		return template.query(sql, new Object[] { courseName }, BeanPropertyRowMapper.newInstance(Student.class));
	}

	public boolean existsByEmail(String email) {
	    String query = "SELECT COUNT(*) FROM student WHERE email = ?";
	    int count = template.queryForObject(query, Integer.class, email);
	    return count > 0;
	}

	
	public Student fetchStudentById(int student_id) {
	    String sql = "SELECT s.*, p.amount_paid, p.payment_date, p.due_amount " +
	            "FROM student s " +
	            "LEFT JOIN payment p ON s.student_id = p.student_id " +
	            "WHERE s.student_id = ?";

	    try {
	        return template.queryForObject(sql, new Object[]{student_id}, new RowMapper<Student>() {
	            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
	                Student student = new Student();
	                student.setStudent_id(rs.getInt("student_id"));
	                student.setFirst_name(rs.getString("first_name"));
	                student.setLast_name(rs.getString("last_name"));
	                student.setEmail(rs.getString("email"));
	                student.setAddress(rs.getString("address"));
	                student.setCity(rs.getString("city"));
	                student.setState(rs.getString("state"));
	                student.setPhone_number(rs.getString("phone_number"));
	                student.setCourse_id(rs.getInt("course_id"));
	                student.setBranch_id(rs.getInt("branch_id"));

	                if (rs.getObject("amount_paid") == null) {
	                    student.setAmount_paid(null);
	                    student.setPayment_date(null);
	                    student.setPayment_status(false);
	                     // Set due amount as null if no payment is found
	                } else {
	                    float amountPaid = rs.getFloat("amount_paid");
	                    student.setAmount_paid(rs.wasNull() ? null : amountPaid);
	                    student.setPayment_date(rs.getString("payment_date"));

	                    String courseFeeSql = "SELECT fees FROM Course WHERE course_id = ?";
	                    double courseFee = template.queryForObject(courseFeeSql, Double.class, student.getCourse_id());
	                    double dueAmount = courseFee - amountPaid;

	                    if (dueAmount == 0) {
	                        student.setPayment_status(true);
	                    } else {
	                        student.setPayment_status(false);
	                    }

	                    student.setDue_amount(dueAmount); // Set the due amount
	                }

	                return student;
	            }
	        });
	    } catch (EmptyResultDataAccessException e) {
	        return null;
	    }
	}

	

	public Student getStudentInfoById(int student_id) {
	    String sql = "SELECT * FROM student WHERE student_id = ?";
	    try {
	        return template.queryForObject(sql, new Object[]{student_id}, new RowMapper<Student>() {
	            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
	                Student student = new Student();
	                student.setStudent_id(rs.getInt("student_id"));
	                student.setFirst_name(rs.getString("first_name"));
	                student.setLast_name(rs.getString("last_name"));
	                student.setCourse_id(rs.getInt("course_id"));
	                student.setPhone_number(rs.getString("phone_number"));
	                student.setAddress(rs.getString("address"));
	                // Set other student details as needed
	                return student;
	            }
	        });
	    } catch (EmptyResultDataAccessException e) {
	        return null;
	    }
	}


}
