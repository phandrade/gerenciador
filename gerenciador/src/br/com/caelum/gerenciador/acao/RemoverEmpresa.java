package br.com.caelum.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.modelo.Banco;
import br.com.caelum.gerenciador.util.GerenciadorUtil;

public class RemoverEmpresa implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramIdEmpresa = request.getParameter("idEmpresa");
		if(paramIdEmpresa != null) {
			Integer idEmpresa = Integer.valueOf(paramIdEmpresa);
			
			Banco banco = new Banco();
			banco.removerEmpresaPorId(idEmpresa); // TODO - retornar mensagem com resultado do processo de remocao			
		}		
		return GerenciadorUtil.montarAcaoRedirect("aplicacao?acao=ListaEmpresas");
		
	}

}
