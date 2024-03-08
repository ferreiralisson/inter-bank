package br.com.inter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.inter.dao.ContaDAO;
import br.com.inter.model.Conta;

@WebServlet(urlPatterns = "/nova-conta")
public class CriarContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String numeroConta = req.getParameter("numero-conta");
		String nomeCliente = req.getParameter("nome-cliente");
		
		if(numeroConta == null || numeroConta.equalsIgnoreCase("")) {
			throw new RuntimeException("numero da conta invalido");
		}
		
		var conta = new Conta(Integer.valueOf(numeroConta), nomeCliente);
		var contaDAO = new ContaDAO();
		contaDAO.criarConta(conta);
		req.setAttribute("conta", conta);
		
		RequestDispatcher rd = req.getRequestDispatcher("/conta-criada.jsp");
		rd.forward(req, resp);
	}

}
