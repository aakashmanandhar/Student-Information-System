package com.aakash.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aakash.DAO.UserDAO;
import com.aakash.DAO.UserDAOImpl;
import com.aakash.DTO.User;

@WebServlet("/UserController")
@MultipartConfig
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDAO userdao = new UserDAOImpl();
	private static final String USER_LIST = "userList.jsp";
	private static final String USER_FORM = "userForm.jsp";

	String forward = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("actions");

		if (action.equals("user_new")) {
			forward = USER_FORM;
		} else if (action.equals("user_delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			userdao.deleteUserInfo(id);
			request.setAttribute("users", userdao.getAllUserInfo());
		} else if (action.equals("user_list")) {
			request.setAttribute("users", userdao.getAllUserInfo());
			forward = USER_LIST;
		} else if (action.equals("user_edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("user", userdao.getUserInfoById(id));
			forward = USER_FORM;
		}

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setUserName(request.getParameter("uname"));
		user.setPassword(request.getParameter("pass"));
		System.out.println(request.getPart("photo"));
		user.setImageUrl("");
		
		String userId = request.getParameter("id");

		if (userId == null || userId.isEmpty()) {
			userdao.saveUserInfo(user);
		} else {
			user.setId(Integer.parseInt(userId));
			userdao.updateUserInfo(user);
		}

		response.sendRedirect("UserController?actions=user_list");

	}

}
