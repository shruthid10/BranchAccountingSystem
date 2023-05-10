
package com.accounting.dao;



import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;


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
		System.out.println(">>>>>>>>>>>>>"+ p.getPayment_date());
		String sql = "INSERT INTO payment (student_id, payment_date, amount_paid) VALUES ('" + p.getStudent_id() + "','"
				+ p.getPayment_date() + "','" + p.getAmount_paid() + "')";
		return template.update(sql);
	}
	
	public int update(Payment p) {

		String sql = "update payment set student_id='" + p.getStudent_id() + "',payment_date='" + p.getPayment_date()
				+ "',amount_paid='" + p.getAmount_paid() + "' where payment_id=" +p.getPayment_id()+"";

		return template.update(sql);
	}

	
	
	public List<Payment> getPayments() {
	    return template.query("select * from payment", new RowMapper<Payment>() {
	        public Payment mapRow(ResultSet rs, int row) throws SQLException {
//	         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//	       	 LocalDateTime fromDateTime = LocalDateTime.parse(payment.getPayment_date(rs.getDate(3)), formatter);
	          
	       	 Payment pay = new Payment();
//	       	 Date dd=(Date)rs.getDate(3);
//	       	 System.err.println(">>>>>>>>>>>"+dd);
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

	public int delete(int id) {
		String sql = "delete from payment where payment_id=" + id + "";
		return template.update(sql);
	}
}
