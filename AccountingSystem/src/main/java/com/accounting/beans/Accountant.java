package com.accounting.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Accountant {
	
	
	  private int accountant_id;
	  private String first_name;
	  private String last_name;
	  private String email;
	  private float salary;
	  private int branch_id;
	  private String branch_name;
	  @Autowired
	  private Branch branch;
	  
	public int getAccountant_id() {
		return accountant_id;
	}
	public void setAccountant_id(int accountant_id) {
		this.accountant_id = accountant_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	  public String getBranch_name() {
		return branch_name;
	}
	public Branch getBranch() {
		return branch;
	}
	@Override
		public String toString() {
			return "Accountant [accountant_id=" + accountant_id + ", first_name=" + first_name + ", last_name=" + last_name
					+ ", email=" + email + ", salary=" + salary + ", branch_id=" + branch_id + ", branch_name="
					+ branch_name + ", branch=" + branch + "]";
		}
	  
	  

}
