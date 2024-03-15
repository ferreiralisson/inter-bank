package br.com.inter.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.inter.controller.TipoAcao;
import br.com.inter.dao.ContaDAO;

public class DeletarContaBean implements TipoAcao {

	private HttpServletRequest req;
	private HttpServletResponse resp;

	public DeletarContaBean(HttpServletRequest req, HttpServletResponse resp) {
		super();
		this.req = req;
		this.resp = resp;
	}

	@Override
	public void execute() throws ServletException, IOException {
		String numeroConta = this.req.getParameter("numero-conta");
		Integer numeroContaCliente = Integer.valueOf(numeroConta);

		ContaDAO dao = new ContaDAO();
		dao.removerConta(numeroContaCliente);

		// chamo o jsp
		this.resp.sendRedirect("controlador?acao=listarContas");
	}

}
