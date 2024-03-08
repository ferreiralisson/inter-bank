package br.com.inter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/inicio")
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//TODO: implementar usuario dinamico
		req.setAttribute("nome", "Usuario");

		RequestDispatcher rd = req.getRequestDispatcher("/bem-vindo.jsp");
		rd.forward(req, resp);
	}
}
