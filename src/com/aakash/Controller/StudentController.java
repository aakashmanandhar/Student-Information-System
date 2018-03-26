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
import javax.servlet.http.Part;

import com.aakash.DAO.StudentDAO;
import com.aakash.DAO.StudentDAOImpl;
import com.aakash.DTO.Student;
import com.aakash.Util.ImageUtil;

@WebServlet("/StudentController")
@MultipartConfig
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StudentDAO studentdao = new StudentDAOImpl();
	private static final String STUDENT_LIST = "studentList.jsp";
	private static final String STUDENT_FORM = "studentForm.jsp";

	String forward = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("actions");

		if (action.equals("student_new")) {
			forward = STUDENT_FORM;
		} else if (action.equals("student_delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			studentdao.deleteStudentInfo(id);
			request.setAttribute("students", studentdao.getAllStudentInfo());
		} else if (action.equals("student_list")) {
			request.setAttribute("students", studentdao.getAllStudentInfo());
			forward = STUDENT_LIST;
		} else if (action.equals("student_edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("student", studentdao.getStudentInfoById(id));
			forward = STUDENT_FORM;
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

		String studentId = request.getParameter("id");

		Part part = request.getPart("photo");
		String fileName = ImageUtil.getFileName(part);
		String imageUrl = "";
		if (!fileName.isEmpty()) {
			imageUrl = ImageUtil.writeImageToFile(part, ImageUtil.IMAGE_UPLOAD_PATH + fileName);
		} else {
			imageUrl = studentdao.getImageUrlById(Integer.parseInt(studentId));
		}

		student.setImageUrl(imageUrl);

		if (studentId == null || studentId.isEmpty()) {
			studentdao.saveStudentInfo(student);
		} else {
			student.setId(Integer.parseInt(studentId));
			studentdao.updateStudentInfo(student);
		}

		response.sendRedirect("StudentController?actions=student_list");
	}

}
