package com.accounting.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.accounting.beans.Course;

public class CourseDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Course c) {
		String sql = "INSERT INTO course ( name, fees, duration) VALUES ('" + c.getName() + "','" + c.getFees() + "','"
				+ c.getDuration() + "')";
		return template.update(sql);
	}

	public int update(Course c) {

		String sql = "update course set name='" + c.getName() + "',fees='" + c.getFees() + "',duration='"
				+ c.getDuration() + "' where course_id=" + c.getCourse_id() + "";

		return template.update(sql);
	}

	public List<Course> getCourses() {
		return template.query("select * from course", new RowMapper<Course>() {
			public Course mapRow(ResultSet rs, int row) throws SQLException {
				Course cr = new Course();
				cr.setCourse_id(rs.getInt(1));
				cr.setName(rs.getString(2));
				cr.setFees(rs.getDouble(3));
				cr.setDuration(rs.getInt(4));
				return cr;

			}
		});
	}

	public List<Course> getAllCourses() {
		List<Course> courses = template.query("SELECT  course_id,name FROM course",
				new BeanPropertyRowMapper<Course>(Course.class));
		return courses;
	}

	public Course getCourseById(int id) {
		String sql = "select * from course where course_id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Course>(Course.class));
	}

	public boolean getCourseByCourseName(String courseName) {
		String sql = "SELECT COUNT(*) FROM course WHERE name = ?";
		int count = template.queryForObject(sql, Integer.class, courseName);
		return count > 0;
	}

}
