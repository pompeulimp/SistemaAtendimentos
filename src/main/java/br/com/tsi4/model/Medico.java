package br.com.tsi4.model;

import java.util.List;

public class Medico {

	private int pkMedico;
	private String crm;
	private String nomeMedico;
	private String telMedico;
	private String disponibilidade;
	private List<Especialidade> especialidades;

	public Medico() {

	}

	public int getPkMedico() {
		return pkMedico;
	}

	public void setPkMedico(int pkmedico) {
		this.pkMedico = pkmedico;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public String getTelMedico() {
		return telMedico;
	}

	public void setTelMedico(String telMedico) {
		this.telMedico = telMedico;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	/**
	 * Recebe uma especialidade e adiciona a lista do medico
	 * 
	 * @param especialidade
	 */
	public void addEspecialidade(Especialidade especialidade) {
		especialidades.add(especialidade);
	}

	@Override
	public String toString() {
		return "Medico [pkMedico=" + pkMedico + ", crm=" + crm
				+ ", nomeMedico=" + nomeMedico + ", telMedico=" + telMedico
				+ ", disponibilidade=" + disponibilidade + ", especialidades="
				+ especialidades + "]";
	}

}
