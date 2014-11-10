package br.com.tsi4.model;

public class Especialidade {
	
	private long pkEspecialidade;
	private String descricao;

	public Especialidade() {

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

	@Override
	public String toString() {
		return "Especialidade [pkEspecialidade=" + pkEspecialidade
				+ ", descricao=" + descricao + "]";
	}
	
}
