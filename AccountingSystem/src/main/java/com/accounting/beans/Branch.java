package com.accounting.beans;

public class Branch {
	
	    private int branch_id;
	    private String branch_name;
	    private String address;
	    private String city;
	    private String state;
		public int getBranch_id() {
			return branch_id;
		}
		public void setBranch_id(int branch_id) {
			this.branch_id = branch_id;
		}
		public String getBranch_name() {
			return branch_name;
		}
		public void setBranch_name(String branch_name) {
			this.branch_name = branch_name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
	    

}
