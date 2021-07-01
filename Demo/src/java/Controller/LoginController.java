/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import daos.UserDao;
import dtos.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Helper;
import utils.Routers;

/**
 * @author heaty566
 */
@WebServlet(name = "LoginController", urlPatterns = { "/LoginController" })
public class LoginController extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the +
	// sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(Routers.LoginP).forward(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String username = Helper.getStringParam(request, "username", "username", 1, 10, null);
			String password = Helper.getStringParam(request, "password", "Password", 1, 50, null);

			if (username == null || password == null) {
				request.getRequestDispatcher(Routers.LoginP).forward(request, response);
				return;
			}
			User user = UserDao.getUser(username);

			System.out.println(user);
			if (user == null || !user.getUserPassword().equals(password)) {
				request.setAttribute("errorMessage", "Invalid login");
				request.getRequestDispatcher(Routers.LoginP).forward(request, response);
				return;
			}

			HttpSession se = request.getSession();
			se.setAttribute("username", username);
			request.getRequestDispatcher(Routers.List).forward(request, response);
			return;
		}
		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Invalid login");
			request.getRequestDispatcher(Routers.LoginP).forward(request, response);
		}
	}

	/**
	 * Returns a short description of the servlet.
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
