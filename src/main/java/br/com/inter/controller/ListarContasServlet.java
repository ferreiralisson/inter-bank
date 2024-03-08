package br.com.inter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.inter.dao.ContaDAO;

@WebServlet(urlPatterns = "/contas")
public class ListarContasServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContaDAO bd = new ContaDAO();
		req.setAttribute("contas", bd.listarContas());
		
		RequestDispatcher rd = req.getRequestDispatcher("/listar-contas.jsp");
		rd.forward(req, resp);
	}

}
