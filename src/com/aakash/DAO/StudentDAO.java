package com.aakash.DAO;

import java.util.List;

import com.aakash.DTO.Student;

public interface StudentDAO {

	public void saveStudentInfo(Student student);

	public void updateStudentInfo(Student student);

	public void deleteStudentInfo(int id);

	public List<Student> getAllStudentInfo(int id);

	public Student getStudentInfoById(int id);

	public String getImageUrlById(int id);

}
