/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author heaty566
 */
public class Helper {

	public static boolean protectedRouter(HttpServletRequest request, HttpServletResponse response, int minRole,
			int maxRole, String page) throws Exception {

		if (!isLogin(request) || !correctRole(request, minRole, maxRole)) {
			request.setAttribute("errorMessage", "Action is not allow, please login first");
			request.getRequestDispatcher(page).forward(request, response);

			return false;
		}

		return true;
	}

	public static boolean isLogin(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return false;
		}
		String username = (String) session.getAttribute("username");

		return username != null;
	}

	public static boolean correctRole(HttpServletRequest request, int minRole, int maxRole) {
		HttpSession session = request.getSession(false);
		Integer roleR = (Integer) session.getAttribute("role");

		return roleR != null && roleR >= minRole && roleR <= maxRole;
	}

	public static String getStringParam(HttpServletRequest request, String field, String label, int min, int max,
			String defaultValue) {
		String value = (String) request.getParameter(field);

		if (value == null || value.trim().isEmpty()) {
			if (defaultValue == null) {
				request.setAttribute(field + "Error", label + " is required");
				return null;
			}

			return defaultValue;
		}
		if (value.trim().length() > max) {
			request.setAttribute(field + "Error", label + " is less than or equal " + max + " character(s)");
			return null;
		}
		if (value.trim().length() < min) {
			request.setAttribute(field + "Error", label + " is greater than or equal " + min + " character(s)");
			return null;
		}
		return value;
	}

	public static Integer getIntParam(HttpServletRequest request, String field, String label, int min, int max,
			Integer defaultValue) {

		String value = (String) request.getParameter(field);
		Integer realValue;

		if (value == null || value.isEmpty()) {
			if (defaultValue == null) {
				request.setAttribute(field + "Error", label + " is required");
				return null;
			}
			return defaultValue;
		}
		try {
			realValue = Integer.parseInt(value);
		}
		catch (NumberFormatException e) {
			request.setAttribute(field + "Error",
					label + " must be a number and less than or equal " + Integer.MAX_VALUE);
			return null;
		}
		if (realValue > max) {
			request.setAttribute(field + "Error", label + " is less than or equal " + max);
			return null;
		}
		if (realValue < min) {
			request.setAttribute(field + "Error", label + " is greater than or equal " + min);
			return null;
		}

		return realValue;
	}

	public static Float getFloatParam(HttpServletRequest request, String field, String label, float min, float max,
			Float defaultValue) {

		String value = (String) request.getParameter(field);
		Float realValue;
		if (value == null || value.isEmpty()) {
			if (defaultValue == null) {
				request.setAttribute(field + "Error", label + " is required");
				return null;
			}
			return defaultValue;
		}

		try {
			realValue = Float.parseFloat(value);
		}
		catch (NumberFormatException e) {

			request.setAttribute(field + "Error",
					label + " must be a number and less than or equal " + Float.MAX_VALUE);
			return null;
		}
		if (realValue > max) {
			request.setAttribute(field + "Error", label + " is less than or equal " + max);
			return null;
		}
		if (realValue < min) {
			request.setAttribute(field + "Error", label + " is greater than or equal " + min);
			return null;
		}

		return realValue;
	}

}
