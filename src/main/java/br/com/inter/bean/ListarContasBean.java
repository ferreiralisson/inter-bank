package br.com.inter.bean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.inter.controller.TipoAcao;
import br.com.inter.dao.ContaDAO;

public class ListarContasBean implements TipoAcao {

	private HttpServletRequest req;
	private HttpServletResponse resp;

	public ListarContasBean(HttpServletRequest req, HttpServletResponse resp) {
		super();
		this.req = req;
		this.resp = resp;
	}

	@Override
	public void execute() throws ServletException, IOException {
		ContaDAO bd = new ContaDAO();
		req.setAttribute("contas", bd.listarContas());

		RequestDispatcher rd = req.getRequestDispatcher("/listar-contas.jsp");
		rd.forward(req, resp);
	}

}
