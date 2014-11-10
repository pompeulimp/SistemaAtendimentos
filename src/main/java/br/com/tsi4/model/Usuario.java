package br.com.tsi4.model;

import java.io.Serializable;

public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;

	private long pkUsuario;
	private long pkHospital;
	private String nomeusuario;
	private String senha;
	private String nivelusuario;

	public Usuario() {

	}

	public long getPkUsuario() {
		return pkUsuario;
	}

	public void setPkUsuario(long pkUsuario) {
		this.pkUsuario = pkUsuario;
	}

	public long getPkHospital() {
		return pkHospital;
	}

	public void setPkHospital(long pkHospital) {
		this.pkHospital = pkHospital;
	}

	public String getNomeUsuario() {
		return nomeusuario;
	}

	public void setNomeUsuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNivelusuario() {
		return nivelusuario;
	}

	public void setNivelusuario(String nivelusuario) {
		this.nivelusuario = nivelusuario;
	}

}
