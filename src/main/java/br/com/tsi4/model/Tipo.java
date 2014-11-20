package br.com.tsi4.model;







public class Tipo {

	private long pkTipoAtendimento;
	private String descricaoTipo;
	private Double tempoEstimado;
	
	public Tipo() {

	}

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

	public Double getTempoEstimado() {
		return tempoEstimado;
	}

	public void setTempoEstimado(Double tempoEstimado) { 
	this.tempoEstimado = tempoEstimado;
	}
	

	

}
