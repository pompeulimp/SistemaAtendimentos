package br.com.tsi4.model;

public class EspecialidadeMedica {
	
	private long pkEspecialidade;
	private String descricao;

	public EspecialidadeMedica() {

	}

	public long getPkEspecialidade() {
		return pkEspecialidade;
	}

	public void setPkEspecialidade(long pkEspecialidade) {
		this.pkEspecialidade = pkEspecialidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
