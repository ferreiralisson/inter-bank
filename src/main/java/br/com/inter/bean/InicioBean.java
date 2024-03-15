package br.com.inter.bean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.inter.controller.TipoAcao;

public class InicioBean implements TipoAcao {

	private HttpServletResponse resp;
	private HttpServletRequest req;

	public InicioBean(HttpServletResponse resp, HttpServletRequest req) {
		super();
		this.resp = resp;
		this.req = req;
	}

	@Override
	public void execute() throws ServletException, IOException {

		req.setAttribute("nome", "Usuario");

		RequestDispatcher rd = req.getRequestDispatcher("/bem-vindo.jsp");
		rd.forward(req, resp);
	}
}
