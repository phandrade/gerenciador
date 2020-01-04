package br.com.caelum.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.modelo.Banco;
import br.com.caelum.gerenciador.modelo.Empresa;
import br.com.caelum.gerenciador.util.GerenciadorUtil;

public class ListaEmpresas implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> listaEmpresas = banco.getEmpresas();
		
		request.setAttribute("empresas", listaEmpresas);		
		return GerenciadorUtil.montarAcaoForward("listaEmpresas.jsp");
		
	}

}
