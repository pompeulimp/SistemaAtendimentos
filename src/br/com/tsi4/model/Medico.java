package br.com.tsi4.model;

import java.util.List;

public class Medico {
	
	private Long pkMedico;
	private String crm;
	private String nomeMedico;
	private String telMedico;
	private char disponibilidade;
	private List<EspecialidadeMedica> especialidades;

	public Medico() {

	}

	public Long getPkMedico() {
		return pkMedico;
	}

	public void setPkMedico(Long pkMedico) {
		this.pkMedico = pkMedico;
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

	public char getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(char disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public List<EspecialidadeMedica> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<EspecialidadeMedica> especialidades) {
		this.especialidades = especialidades;
	}

	

}
