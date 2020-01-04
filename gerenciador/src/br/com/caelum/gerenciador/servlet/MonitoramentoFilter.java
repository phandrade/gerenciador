package br.com.caelum.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MonitoramentoFilter implements Filter {

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
		
		String nomeAcao = httpRequest.getParameter("acao");
		
		long antes = System.currentTimeMillis();		
		chain.doFilter(request, response);		
		long depois = System.currentTimeMillis();
		System.out.println("Tempo da Acao " + nomeAcao + " - " + (depois - antes));
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
