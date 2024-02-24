package com.mei.vendasapi.security;



//TODO
//COLOCAR SEGURANÇA PARA O FILTRO E O PROJETO PODEREM FUNCIONAR CORRETAMENTE

import com.mei.vendasapi.domain.Usuario;
import com.mei.vendasapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MEISecurity {
	
	@Autowired
	private UsuarioRepository usurepo;
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	public String getUsuario() {
		String nome = (String) getAuthentication().getPrincipal().toString();		
		return nome;
	}
	public Integer getIdUsuario() {
		String nome = (String) getAuthentication().getPrincipal().toString();
		Usuario idusuario = usurepo.buscarUsuario(nome);
		return idusuario.getId();
	}
	
	public String getEmailsuario() {
		String nome = (String) getAuthentication().getPrincipal().toString();
		Usuario idusuario = usurepo.buscarUsuario(nome);
		return idusuario.getEmail();
	}
	
	public Usuario getUsu() {
		String nome = (String) getAuthentication().getPrincipal().toString();
		Usuario usuario = usurepo.buscarUsuario(nome);
		return usuario;
	}
	
	
}
