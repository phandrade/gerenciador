package br.com.caelum.gerenciador.util;

import br.com.caelum.gerenciador.servlet.ControladorAplicacaoFilter;

public class GerenciadorUtil {
	
	public static String montarAcaoForward(String paginaJSP) {		
		return ControladorAplicacaoFilter.PREFIXO_FORWARD + ControladorAplicacaoFilter.SEPARADOR_ACAO_PAGINA + ControladorAplicacaoFilter.PREFIXO_JSP + paginaJSP;
	}
	
	public static String montarAcaoRedirect(String acao) {		
		return ControladorAplicacaoFilter.PREFIXO_REDIRECT + ControladorAplicacaoFilter.SEPARADOR_ACAO_PAGINA + acao;
	}
}
