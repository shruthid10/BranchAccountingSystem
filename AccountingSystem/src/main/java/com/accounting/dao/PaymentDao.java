
package com.accounting.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.accounting.beans.Branch;
import com.accounting.beans.Course;
import com.accounting.beans.Payment;
import com.accounting.beans.Student;

public class PaymentDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Payment p) {
	    try {
	        String checkPaymentSql = "SELECT COUNT(*) FROM payment WHERE student_id = ?";
	        int paymentCount = template.queryForObject(checkPaymentSql, Integer.class, p.getStudent_id());
	        if (paymentCount > 0) {
	            return -1; // Payment already exists
	        }

	        String courseFeeSql = "SELECT fees FROM Course WHERE course_id = (SELECT course_id FROM Student WHERE student_id = ?)";
	        double courseFee = template.queryForObject(courseFeeSql, Double.class, p.getStudent_id());

	        if (p.getAmount_paid() > courseFee) {
	            return -2; // Amount paid cannot be greater than the course fee
	        }

	        p.setDue_amount(courseFee - p.getAmount_paid());

	        String insertSql = "INSERT INTO payment (student_id, payment_date, amount_paid, due_amount) VALUES (?, ?, ?, ?)";
	        String updateSql = "UPDATE Student SET payment_status = ? WHERE student_id = ?";
	        boolean paymentStatus = (p.getDue_amount() == 0); // Set payment status based on due amount

	        int rowsAffected = template.update(insertSql, p.getStudent_id(), p.getPayment_date(), p.getAmount_paid(),
	                p.getDue_amount());
	        template.update(updateSql, paymentStatus, p.getStudent_id());

	        return rowsAffected;
	    } catch (DataAccessException e) {
	        System.out.println("Error occurred during database access: " + e.getMessage());
	        return -3; 
	    }
	}


	public int update(Payment p) {
	    try {
	        String courseFeeSql = "SELECT fees FROM Course WHERE course_id = (SELECT course_id FROM Student WHERE student_id = ?)";
	        double courseFee = template.queryForObject(courseFeeSql, Double.class, p.getStudent_id());

	        if (p.getAmount_paid() > courseFee) {
	            return -2; // Amount paid exceeds the course fee
	        }

	        String existingAmountSql = "SELECT amount_paid FROM payment WHERE payment_id = ?";
	        double existingAmount = template.queryForObject(existingAmountSql, Double.class, p.getPayment_id());

	        if (p.getAmount_paid() < existingAmount) {
	            return -3; // Invalid amount entered (less than the existing amount)
	        }

	        double dueAmount = courseFee - p.getAmount_paid();
	        boolean paymentStatus = (dueAmount == 0);

	        String sql = "UPDATE payment SET student_id = ?, payment_date = ?, amount_paid = ?, due_amount = ? WHERE payment_id = ?";
	        int rowsAffected = template.update(sql, p.getStudent_id(), p.getPayment_date(), p.getAmount_paid(), dueAmount, p.getPayment_id());

	        if (paymentStatus) {
	            String updateStudentSql = "UPDATE Student SET payment_status = ? WHERE student_id = ?";
	            template.update(updateStudentSql, true, p.getStudent_id());
	        }

	        return rowsAffected;
	    } catch (DataAccessException e) {
	        System.out.println("Error occurred during database access: " + e.getMessage());
	        return -1; // Database access error
	    }
	}


	public List<Payment> getPayments() {
		return template.query("select * from payment", new RowMapper<Payment>() {
			public Payment mapRow(ResultSet rs, int row) throws SQLException {

				Payment pay = new Payment();

				pay.setPayment_id(rs.getInt(1));
				pay.setStudent_id(rs.getInt(2));
				pay.setPayment_date(rs.getString(3));
				pay.setAmount_paid(rs.getFloat(4));
				pay.setDue_amount(rs.getDouble(5));
				return pay;
			}
		});
	}

	public Payment getPaymentId(int id) {
		String sql = "select * from payment where payment_id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Payment>(Payment.class));
	}

	public Payment getPaymentDetailsByStudentId(int student_id) {
		String sql = "SELECT * FROM payment WHERE student_id = ?";
		return template.queryForObject(sql, new Object[] { student_id },
				new BeanPropertyRowMapper<Payment>(Payment.class));
	}
	public List<Payment> getAllPayments() {
	    String query = "SELECT * FROM payment";
	    List<Payment> payments = template.query(query, new PaymentRowMapper());
	    return payments;
	}

	private class PaymentRowMapper implements RowMapper<Payment> {
	    
	    public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Payment payment = new Payment();
	        payment.setPayment_id(rs.getInt("payment_id"));
	        payment.setStudent_id(rs.getInt("student_id"));
	        payment.setPayment_date(rs.getString("payment_date"));
	        payment.setAmount_paid(rs.getFloat("amount_paid"));
	        return payment;
	    }
	}
	public List<Payment> getPaymentsByStudentId(int studentId) {
	    String query = "SELECT * FROM payment WHERE student_id = ?";
	    
	    return template.query(query, new Object[]{studentId}, new RowMapper<Payment>() {
	        
	        public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Payment payment = new Payment();
	            payment.setPayment_id(rs.getInt("payment_id"));
	            payment.setStudent_id(rs.getInt("student_id"));
	            payment.setPayment_date(rs.getString("payment_date"));
	            payment.setAmount_paid(rs.getFloat("amount_paid"));
	            // Set other payment properties from the result set
	            
	            return payment;
	        }
	    });
	}

	
	public Payment getPaymentById(int paymentId) {
		String sql = "SELECT p.payment_id, p.student_id, p.amount_paid, p.payment_date, p.due_amount, " +
	             "s.first_name, s.last_name, s.course_id, s.phone_number, s.address, " +
	             "c.name, c.fees, b.branch_id, b.branch_name " +
	             "FROM payment p " +
	             "INNER JOIN student s ON p.student_id = s.student_id " +
	             "INNER JOIN course c ON s.course_id = c.course_id " +
	             "INNER JOIN branch b ON s.branch_id = b.branch_id " +
	             "WHERE p.payment_id = ?";


	    return template.queryForObject(sql, new Object[]{paymentId}, new PaymentMapper());
	}

	private static class PaymentMapper implements RowMapper<Payment> {
	    
	    public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Payment payment = new Payment();
	        payment.setPayment_id(rs.getInt("payment_id"));
	        payment.setAmount_paid(rs.getFloat("amount_paid"));
	        payment.setPayment_date(rs.getString("payment_date"));
            payment.setDue_amount(rs.getDouble("due_amount"));
	        Student student = new Student();
	        student.setStudent_id(rs.getInt("student_id"));
	        student.setFirst_name(rs.getString("first_name"));
	        student.setLast_name(rs.getString("last_name"));
	        student.setPhone_number(rs.getString("phone_number"));
	        student.setAddress(rs.getString("address"));
            student.setCourse_id(rs.getInt("course_id"));
           student.setBranch_id(rs.getInt("branch_id"));
	        Course course = new Course();
	        course.setName(rs.getString("name"));
	        course.setFees(rs.getDouble("fees"));
	        Branch branch = new Branch();
	        
	        branch.setBranch_name(rs.getString("branch_name"));
	        payment.setBranch(branch);
	        
	        student.setCourse(course);
	        payment.setStudent(student);

	        return payment;
	    }
	}




}
