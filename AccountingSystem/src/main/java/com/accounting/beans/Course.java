package com.accounting.beans;

public class Course {
	

	    private int course_id;
	    private String name;
	    private double fees;
	    private int duration;
		public int getCourse_id() {
			return course_id;
		}
		public void setCourse_id(int course_id) {
			this.course_id = course_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getFees() {
			return fees;
		}
		public void setFees(double fees) {
			this.fees = fees;
		}
		public int getDuration() {
			return duration;
		}
		public void setDuration(int duration) {
			this.duration = duration;
		}
		@Override
		public String toString() {
			return "Course [course_id=" + course_id + ", name=" + name + ", fees=" + fees + ", duration=" + duration
					+ "]";
		}

	   
}
