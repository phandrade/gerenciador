package br.com.caelum.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import br.com.caelum.gerenciador.acao.Acao;

public class ControladorAplicacaoFilter implements Filter {
	
	public static final String PREFIXO_REDIRECT = "REDIRECT";
	public static final String PREFIXO_FORWARD = "FORWARD";
	public static final String SEPARADOR_ACAO_PAGINA = ":";
	public static final String PREFIXO_JSP = "WEB-INF/view/";
	public static final String PACKAGE_ACAO = "br.com.caelum.gerenciador.acao.";


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println(this.getClass().toString());
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String nomeAcao = httpRequest.getParameter("acao");
		String acaoRedirecionamento = null;
		
		if(nomeAcao == null || nomeAcao.isEmpty()) {
			nomeAcao = "ListaEmpresas";
		}
		
		Class<?> classe;
		try {
			classe = Class.forName(PACKAGE_ACAO + nomeAcao);
			Acao acao = (Acao) classe.newInstance();
			acaoRedirecionamento = acao.executa(httpRequest, httpResponse);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String[] acaoPaginaRedireciona = acaoRedirecionamento.split(":");
		if(acaoPaginaRedireciona[0].equals(PREFIXO_FORWARD)) {			
			RequestDispatcher rd = request.getRequestDispatcher(acaoPaginaRedireciona[1]);
			rd.forward(request, response);
			
		} else if(acaoPaginaRedireciona[0].equals(PREFIXO_REDIRECT)) {			
			httpResponse.sendRedirect(acaoPaginaRedireciona[1]);
		}
	}


	@Override
	public void destroy() {
	}


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
}
