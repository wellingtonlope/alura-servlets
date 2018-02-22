package br.com.alura.gerenciador.web;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		String uri = req.getRequestURI();
		String usuario = getUsuario(req);
		System.out.println("Usuário " + usuario + " acessando a URI: " + uri);
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {

	}

	private String getUsuario(HttpServletRequest req) {
		String usuario = "<deslogado>";

		Cookie[] cookies = req.getCookies();
		if (cookies == null) return usuario;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("usuario.logado")) {
				usuario = cookie.getValue();
			}
		}
		return usuario;
	}
}
