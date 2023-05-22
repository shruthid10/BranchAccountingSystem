package com.accounting.beans;

public class Payment {
	
	 private int payment_id ;
	 private int student_id; 
	 private String payment_date ;
	 private float amount_paid;
	 private double due_amount;
	 private Student student;
	 private Branch branch;
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
	
	
	public String getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}
	public float getAmount_paid() {
		return amount_paid;
	}
	public void setAmount_paid(float amount_paid) {
		this.amount_paid = amount_paid;
	}
	public double getDue_amount() {
		return due_amount;
	}
	public void setDue_amount(double due_amount) {
		this.due_amount = due_amount;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	 
	 
	 
	 
	 

}
