package br.com.inter.bean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.inter.controller.TipoAcao;
import br.com.inter.dao.ContaDAO;
import br.com.inter.model.Conta;

public class CriarContaBean implements TipoAcao {
	
	private HttpServletRequest req;
	private HttpServletResponse resp;

	public CriarContaBean(HttpServletRequest req, HttpServletResponse resp) {
		super();
		this.req = req;
		this.resp = resp;
	}
	
	@Override
	public void execute() throws ServletException, IOException {
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
