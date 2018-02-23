package br.com.alura.gerenciador.web;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		PrintWriter writer = resp.getWriter();
		if (usuario == null) {
			writer.println("<html><body>Usuario invalido</body></html>");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);
			writer.println("<html><body>Usuario logado: " + email + "</body></html>");
		}
	}
}
