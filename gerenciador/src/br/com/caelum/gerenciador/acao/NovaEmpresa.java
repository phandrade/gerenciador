package br.com.caelum.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.modelo.Banco;
import br.com.caelum.gerenciador.modelo.Empresa;
import br.com.caelum.gerenciador.util.GerenciadorUtil;

public class NovaEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String indOperacao = request.getParameter("indOperacao");
		
		if(indOperacao == null || !indOperacao.equals("fazerCadastro")) {
			return GerenciadorUtil.montarAcaoForward("formNovaEmpresa.jsp");
		}
		
		String nomeEmpresa = request.getParameter("nome");
		String parametroData = request.getParameter("data");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Banco banco = new Banco();
		Empresa empresa = null;
		
		if(nomeEmpresa != null && !nomeEmpresa.isEmpty()) {
			empresa = new Empresa();
			empresa.setNome(nomeEmpresa);
			
			try {
				empresa.setDataAbertura(sdf.parse(parametroData));
			} catch (ParseException e) {
				throw new ServletException(e);
			}
			
			banco.adiciona(empresa);					
		}
		
		return GerenciadorUtil.montarAcaoRedirect("aplicacao?acao=ListaEmpresas");
	}

}
