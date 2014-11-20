package br.com.tsi4.model;

import java.io.Serializable;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private long pkUsuario;
	private String nomeUsuario;
	private String senha;
	private String nivelUsuario;

	public Usuario() {

	}

	public long getPkUsuario() {
		return pkUsuario;
	}

	public void setPkUsuario(long pkUsuario) {
		this.pkUsuario = pkUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNivelUsuario() {
		return nivelUsuario;
	}

	public void setNivelUsuario(String nivelUsuario) {
		this.nivelUsuario = nivelUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [pkUsuario=" + pkUsuario + ", nomeUsuario="
				+ nomeUsuario + ", senha=" + senha + ", nivelUsuario="
				+ nivelUsuario + "]";
	}
}
