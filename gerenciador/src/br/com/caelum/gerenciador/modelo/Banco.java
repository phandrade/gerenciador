package br.com.caelum.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresas = new ArrayList<Empresa>();
	private static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private static Integer chaveSequencial = 1;
	
	static {
		
		Empresa empresa = new Empresa();
		empresa.setId(Banco.chaveSequencial++);
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(Banco.chaveSequencial++);
		empresa2.setNome("Caelum");
		
		Usuario usuario = new Usuario();
		usuario.setLogin("paulo");
		usuario.setSenha("123");
		Usuario usuario2 = new Usuario();
		usuario2.setLogin("ana");
		usuario2.setSenha("123");
		
		Banco.listaUsuarios.add(usuario);
		Banco.listaUsuarios.add(usuario2);
		
		Banco.listaEmpresas.add(empresa);
		Banco.listaEmpresas.add(empresa2);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.listaEmpresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.listaEmpresas;
	}
	
	public Empresa obterEmpresaPorId(Integer id) {
		
		if(id != null) {
			
			for (Empresa empresa : getEmpresas()) {
				if(empresa.getId().equals(id)) {
					return empresa;
				}
			}
		}
		return null;
	}
	
	public Usuario obterUsuarioPorLogin(String login, String senha) {
		
		if(login != null && senha != null) {
			
			for (Usuario usuario : listaUsuarios) {
				if(usuario.ehIgual(login, senha)) {
					return usuario;
				}
			}
		}
		return null;
	}
	
	public boolean removerEmpresaPorId(Integer id) {
		
		if(id != null) {
			
			Iterator<Empresa> iterator = Banco.listaEmpresas.iterator();			
			while(iterator.hasNext()) {
				Empresa empresa = iterator.next();
				if(empresa.getId().equals(id)) {
					iterator.remove();
				}
			}
		}
		return false;
	}
	
}
