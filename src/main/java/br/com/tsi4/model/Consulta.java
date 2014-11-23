package br.com.tsi4.model;

import java.util.Date;

public class Consulta {

	private long pk_consulta;
	private long pk_medico;
	private long pk_hospital;
	private long pk_paciente;
	private long pk_atendimento;
	private String statusConsulta;
	private Date inicioConsulta;
	private Date fimConsulta;

	public Consulta() {
	}

	public long getPk_consulta() {
		return pk_consulta;
	}

	public void setPk_consulta(long pk_consulta) {
		this.pk_consulta = pk_consulta;
	}

	public long getPk_medico() {
		return pk_medico;
	}

	public void setPk_medico(long pk_medico) {
		this.pk_medico = pk_medico;
	}

	public long getPk_hospital() {
		return pk_hospital;
	}

	public void setPk_hospital(long pk_hospital) {
		this.pk_hospital = pk_hospital;
	}

	public long getPk_paciente() {
		return pk_paciente;
	}

	public void setPk_paciente(long pk_paciente) {
		this.pk_paciente = pk_paciente;
	}

	public long getPk_atendimento() {
		return pk_atendimento;
	}

	public void setPk_atendimento(long pk_atendimento) {
		this.pk_atendimento = pk_atendimento;
	}

	public String getStatusConsulta() {
		return statusConsulta;
	}

	public void setStatusConsulta(String statusConsulta) {
		this.statusConsulta = statusConsulta;
	}

	public Date getInicioConsulta() {
		return inicioConsulta;
	}

	public void setInicioConsulta(Date inicioConsulta) {
		this.inicioConsulta = inicioConsulta;
	}

	public Date getFimConsulta() {
		return fimConsulta;
	}

	public void setFimConsulta(Date fimConsulta) {
		this.fimConsulta = fimConsulta;
	}

}