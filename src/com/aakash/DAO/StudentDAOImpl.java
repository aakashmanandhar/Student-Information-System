package com.aakash.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aakash.DTO.Student;
import com.aakash.Util.DbUtil;

public class StudentDAOImpl implements StudentDAO {

	PreparedStatement ps = null;

	@Override
	public void saveStudentInfo(Student student) {

		String sql = "INSERT INTO student_tbl (student_name, college_name, email, subject, department, gender, image_url, dob, roll) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getCollegeName());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getSubject());
			ps.setString(5, student.getDepartment());
			ps.setString(6, student.getGender());
			ps.setString(7, student.getImageUrl());
			ps.setDate(8, new java.sql.Date(student.getDob().getTime()));
			ps.setInt(9, student.getRoll());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudentInfo(Student student) {
		String sql = "UPDATE student_tbl SET student_name=?, college_name=?, email=?, subject=?, department=?, gender=?, image_url=?, dob=?, roll=? WHERE id=?";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getCollegeName());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getSubject());
			ps.setString(5, student.getDepartment());
			ps.setString(6, student.getGender());
			ps.setString(7, student.getImageUrl());
			ps.setDate(8, new java.sql.Date(student.getDob().getTime()));
			ps.setInt(9, student.getRoll());
			ps.setInt(10, student.getId());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteStudentInfo(int id) {
		String sql = "DELETE FROM student_tbl WHERE id=?";

		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Student> getAllStudentInfo(int id) {
		List<Student> studentList = new ArrayList<>();
		String sql = "SELECT * FROM student_tbl";

		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setStudentName(rs.getString("student_name"));
				student.setCollegeName(rs.getString("college_name"));
				student.setDepartment(rs.getString("department"));
				student.setSubject(rs.getString("subject"));
				student.setEmail(rs.getString("email"));
				student.setRoll(rs.getInt("roll"));
				student.setDob(rs.getDate("dob"));
				student.setGender(rs.getString("gender"));
				studentList.add(student);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public String getImageUrlById(int id) {
		String sql = "SELECT image_url FROM student_tbl WHERE id=?";
		String imageUrl = "";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				imageUrl = rs.getString("image_url");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imageUrl;
	}

	@Override
	public Student getStudentInfoById(int id) {
		Student student = new Student();
		String sql = "SELECT * FROM student_tbl WHERE id=?";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				student.setId(rs.getInt("id"));
				student.setStudentName(rs.getString("student_name"));
				student.setCollegeName(rs.getString("college_name"));
				student.setDepartment(rs.getString("department"));
				student.setSubject(rs.getString("subject"));
				student.setEmail(rs.getString("email"));
				student.setRoll(rs.getInt("roll"));
				student.setDob(rs.getDate("dob"));
				student.setGender(rs.getString("gender"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

}
