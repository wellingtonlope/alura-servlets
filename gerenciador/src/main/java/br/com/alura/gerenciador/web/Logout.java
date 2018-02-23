package br.com.alura.gerenciador.web;

import br.com.alura.gerenciador.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
public class Logout implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("usuarioLogado");
		//ou invalidate tira tudo que estava na session
		//req.getSession().invalidate();
		//req.getSession().setMaxInactiveInterval(0);
		return "/WEB-INF/paginas/logout.html";
	}

}
