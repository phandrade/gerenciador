package br.com.caelum.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutorizacaoFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AutorizacaoFilter() {
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println(this.getClass().toString());
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String nomeAcao = httpRequest.getParameter("acao");
		
		if(nomeAcao == null || nomeAcao.isEmpty()) {
			nomeAcao = "ListaEmpresas";
		}
		
		if(!nomeAcao.equals("Login") && (httpRequest.getSession().getAttribute("usuarioLogado") == null)) {
			httpResponse.sendRedirect("aplicacao?acao=Login");
			return;
		}
		chain.doFilter(httpRequest, httpResponse);			
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
