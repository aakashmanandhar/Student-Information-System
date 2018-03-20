package com.aakash.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aakash.DAO.StudentDAO;
import com.aakash.DAO.StudentDAOImpl;
import com.aakash.DTO.Student;

@WebServlet("/StudentController")
@MultipartConfig
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StudentDAO studentdao = new StudentDAOImpl();
	String forward = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("actions");

		if (action.equals("student_new")) {
			forward = "studentForm.jsp";
		} else if (action.equals("student_list")) {
			request.setAttribute("students", studentdao.getAllStudentInfo());
			forward = "studentList.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Student student = new Student();
		student.setStudentName(request.getParameter("sname"));
		student.setCollegeName(request.getParameter("cname"));
		student.setEmail(request.getParameter("email"));
		student.setDepartment(request.getParameter("department"));
		student.setGender(request.getParameter("gender"));
		student.setRoll(Integer.parseInt(request.getParameter("roll")));

		// FOR DATE
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = sdf.parse(request.getParameter("dob"));
			student.setDob(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// FOR CHECKBOX
		String[] subjects = request.getParameterValues("subject");
		String subject = "";
		for (String sub : subjects) {
			subject = subject + sub + "/";
		}
		student.setSubject(subject);

		// FOR IMAGE
		System.out.println(request.getPart("photo"));
		student.setImageUrl("");

		studentdao.saveStudentInfo(student);

	}

}
