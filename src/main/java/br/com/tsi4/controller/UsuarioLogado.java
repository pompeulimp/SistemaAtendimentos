package br.com.tsi4.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.tsi4.model.Usuario;

@SessionScoped
@Named
public class UsuarioLogado implements Serializable{

	private static final long serialVersionUID = 1L;
	private Usuario usuario;

	public Usuario getUsuario(){
		return usuario;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	public void logout(){
		this.usuario = null;
	}

}
