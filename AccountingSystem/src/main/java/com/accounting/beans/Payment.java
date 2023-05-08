package com.accounting.beans;

import java.sql.Date;

public class Payment {
	private int payment_id;
	private int  student_id;
	private Date  payment_date;
	private Float  amount_paid ;
	
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	
	
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date date) {
		this.payment_date = date;
	}
	public Float getAmount_paid() {
		return amount_paid;
	}
	public void setAmount_paid(Float amount_paid) {
		this.amount_paid = amount_paid;
	}
	
}
