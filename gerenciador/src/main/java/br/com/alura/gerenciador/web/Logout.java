package br.com.alura.gerenciador.web;

import br.com.alura.gerenciador.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("usuario.logado");
		//ou invalidate tira tudo que estava na session
		//req.getSession().invalidate();
		//req.getSession().setMaxInactiveInterval(0);
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>Deslogado com sucesso</body></html>");
	}

}
