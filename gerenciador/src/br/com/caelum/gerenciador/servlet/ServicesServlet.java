package br.com.caelum.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.caelum.gerenciador.modelo.Banco;
import br.com.caelum.gerenciador.modelo.Empresa;

public class ServicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		String formato = request.getHeader("Accept");
		
		if(acao.equals("ListaEmpresas")) {
			
			List<Empresa> empresas = new Banco().getEmpresas();
			
			if(formato.contains("json")) {
				
				Gson gson = new Gson();
				String json = gson.toJson(empresas);
				
				response.setContentType("application/json");
				response.getWriter().print(json);
			} else if(formato.contains("xml")) {
				
				XStream xstream = new XStream();
				xstream.alias("empresa", Empresa.class);
				String xml = xstream.toXML(empresas);
				
				response.setContentType("application/xml");
				response.getWriter().print(xml);
			}
		}
	}

}
