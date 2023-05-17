
package com.accounting.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.accounting.beans.Payment;

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
	            System.out.println("Error: Student ID already exists in the payment table");
	            return -1;
	        }

	        String checkStudentSql = "SELECT COUNT(*) FROM Student WHERE student_id = ?";
	        int studentCount = template.queryForObject(checkStudentSql, Integer.class, p.getStudent_id());
	        if (studentCount == 0) {
	            System.out.println("Error: Student ID not found in the student table");
	            return -2;
	        }

	        String insertSql = "INSERT INTO payment (student_id, payment_date, amount_paid) VALUES (?, ?, ?)";
	        String updateSql = "UPDATE Student SET payment_status = ? WHERE student_id = ?";

	        int rowsAffected = template.update(insertSql, p.getStudent_id(), p.getPayment_date(), p.getAmount_paid());
	        template.update(updateSql, true, p.getStudent_id());

	        return rowsAffected;
	    } catch (DataAccessException e) {
	        System.out.println("Error occurred during database access: " + e.getMessage());
	        return -3;
	    }
	}

	public int update(Payment p) {

		String sql = "update payment set student_id='" + p.getStudent_id() + "',payment_date='" + p.getPayment_date()
				+ "',amount_paid='" + p.getAmount_paid() + "' where payment_id=" + p.getPayment_id() + "";

		return template.update(sql);
	}

	public List<Payment> getPayments() {
		return template.query("select * from payment", new RowMapper<Payment>() {
			public Payment mapRow(ResultSet rs, int row) throws SQLException {

				Payment pay = new Payment();

				pay.setPayment_id(rs.getInt(1));
				pay.setStudent_id(rs.getInt(2));
				pay.setPayment_date(rs.getString(3));
				pay.setAmount_paid(rs.getFloat(4));
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

}
