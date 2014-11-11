package br.com.tsi4.model;

public class TipoDeAtendimento {

	private long pkTipoAtendimento;
	private String descricaoTipo;
	private long tempoEstimado;

	public long getPkTipoAtendimento() {
		return pkTipoAtendimento;
	}

	public void setPkTipoAtendimento(long pkTipoAtendimento) {
		this.pkTipoAtendimento = pkTipoAtendimento;
	}

	public String getDescricaoTipo() {
		return descricaoTipo;
	}

	public void setDescricaoTipo(String descricaoTipo) {
		this.descricaoTipo = descricaoTipo;
	}

	public long getTempoEstimado() {
		return tempoEstimado;
	}

	public void setTempoEstimado(long tempoEstimado) {
		this.tempoEstimado = tempoEstimado;
	}

}
