package br.com.inter.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.inter.controller.TipoAcao;
import br.com.inter.dao.ContaDAO;
import br.com.inter.model.Conta;

public class AtualizarContaBean implements TipoAcao {

	private HttpServletRequest req;
	private HttpServletResponse resp;

	public AtualizarContaBean(HttpServletRequest req, HttpServletResponse resp) {
		super();
		this.req = req;
		this.resp = resp;
	}

	@Override
	public void execute() throws ServletException, IOException {
		String numeroContaCliente = this.req.getParameter("numero-conta");
		String nomeCliente = this.req.getParameter("nome-cliente");

		Integer numeroConta = Integer.valueOf(numeroContaCliente);

		ContaDAO dao = new ContaDAO();

		Conta contaParaAtualizar = new Conta(numeroConta, nomeCliente);
		dao.atualizarConta(contaParaAtualizar);

		// chamo o jsp
		this.resp.sendRedirect("controlador?acao=listarContas");

	}

}
