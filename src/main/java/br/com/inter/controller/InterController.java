package br.com.inter.controller;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/controlador")
public class InterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String action = req.getParameter("acao");
		
		String fqn = "br.com.inter.bean." + Character.toUpperCase(action.charAt(0)) 
		+ action.substring(1)
		+ "Bean";
		
		try {
			Class<?> classe = Class.forName(fqn);
			Constructor<?> construtor = 
					classe.getDeclaredConstructor(HttpServletRequest.class,
					HttpServletResponse.class);

			TipoAcao tipoAcao = (TipoAcao) construtor.newInstance(req, resp);
			tipoAcao.execute();
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | 
				InstantiationException
				| IllegalAccessException | 
				IllegalArgumentException | 
				InvocationTargetException e) {
			throw new ServletException(e);
		}
	}

}
