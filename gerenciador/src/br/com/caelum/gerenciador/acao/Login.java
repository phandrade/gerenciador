package br.com.caelum.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.modelo.Banco;
import br.com.caelum.gerenciador.modelo.Usuario;
import br.com.caelum.gerenciador.util.GerenciadorUtil;

public class Login implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String indOperacao = request.getParameter("indOperacao");
		
		if(indOperacao == null || !indOperacao.equals("fazerLogin")) {
			return GerenciadorUtil.montarAcaoForward("formLogin.jsp");
		}
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Banco banco = new Banco();		
		Usuario usuario = banco.obterUsuarioPorLogin(login, senha);	
							
		if(usuario != null) {
			request.getSession().setAttribute("usuarioLogado", usuario);
			return GerenciadorUtil.montarAcaoRedirect("aplicacao?acao=ListaEmpresas");			
		} else {
			request.setAttribute("loginInvalido", true);
			return GerenciadorUtil.montarAcaoForward("formLogin.jsp");
		}
		
	}

}
