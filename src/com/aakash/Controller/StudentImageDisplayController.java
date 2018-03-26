package com.aakash.Controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aakash.DAO.StudentDAO;
import com.aakash.DAO.StudentDAOImpl;

@WebServlet("/StudentImageDisplayController")
public class StudentImageDisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_BUFFER_SIZE = 1024;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String studentId = request.getParameter("studentId");
		StudentDAO studentdao = new StudentDAOImpl();
		String imagePath = studentdao.getImageUrlById(Integer.parseInt(studentId));

		File file = new File(imagePath);

		String contentType = getServletContext().getMimeType(file.getName());

		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		response.reset();
		response.setBufferSize(DEFAULT_BUFFER_SIZE);
		response.setHeader("Content-Length", String.valueOf(file.length()));
		response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");

		BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());

		int len;

		byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];

		while ((len = in.read(bytes)) != -1) {
			out.write(bytes, 0, len);
		}

		in.close();
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
