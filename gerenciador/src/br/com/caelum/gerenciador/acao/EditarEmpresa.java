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


public class EditarEmpresa implements Acao {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		String idEmpresa = request.getParameter("idEmpresa");		
		String indOperacao = request.getParameter("indOperacao");
		Empresa empresaEditada = banco.obterEmpresaPorId(Integer.valueOf(idEmpresa));
		empresaEditada = banco.obterEmpresaPorId(Integer.valueOf(idEmpresa));
		
		if("fazerAlteracao".equals(indOperacao)) {
			
			String novoNome = request.getParameter("nome");
			String novaDataAbertura = request.getParameter("data");
			empresaEditada.setNome(novoNome);
			try {
				empresaEditada.setDataAbertura(sdf.parse(novaDataAbertura));
			} catch (ParseException e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			return GerenciadorUtil.montarAcaoRedirect("aplicacao?acao=ListaEmpresas");
			
		} else if (idEmpresa != null) {
			request.setAttribute("empresa", empresaEditada);			
			return GerenciadorUtil.montarAcaoForward("formEditarEmpresa.jsp");
		}
		return null;
	}

}
