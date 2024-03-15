package br.com.inter.bean;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.inter.controller.TipoAcao;
import br.com.inter.dao.ContaDAO;
import br.com.inter.model.Conta;

public class ListarContaBean implements TipoAcao {

	private HttpServletRequest req;
	private HttpServletResponse resp;

	public ListarContaBean(HttpServletRequest req, HttpServletResponse resp) {
		super();
		this.req = req;
		this.resp = resp;
	}

	@Override
	public void execute() throws ServletException, IOException {

		String numeroConta = this.req.getParameter("numero-conta");
		Integer numeroContaCliente = Integer.valueOf(numeroConta);

		ContaDAO dao = new ContaDAO();

		Optional<Conta> conta = dao.buscaPorId(numeroContaCliente);

		if (conta.isPresent()) {
			req.setAttribute("conta", conta.get());
			RequestDispatcher rd = this.req.getRequestDispatcher("atualiza-conta.jsp");
			rd.forward(this.req, this.resp);
		}
	}

}
