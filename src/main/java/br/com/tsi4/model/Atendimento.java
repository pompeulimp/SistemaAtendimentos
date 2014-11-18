package br.com.tsi4.model;


public class Atendimento {
	
	private long pk_atendimento;
	private int pk_paciente;
	private int pk_tipo;
	private int pk_usuario;
	private int pk_medico;
	private java.sql.Timestamp datainicio;
	private java.sql.Timestamp datatermino;
	private String status;
	
	public  Atendimento()
	{
		
		
	}

	public long getPk_atendimento() {
		return pk_atendimento;
	}

	public void setPk_atendimento(long pk_atendimento) {
		this.pk_atendimento = pk_atendimento;
	}

	public int getPk_paciente() {
		return pk_paciente;
	}

	public void setPk_paciente(int pk_paciente) {
		this.pk_paciente = pk_paciente;
	}

	public int getPk_tipo() {
		return pk_tipo;
	}

	public void setPk_tipo(int pk_tipo) {
		this.pk_tipo = pk_tipo;
	}

	public int getPk_usuario() {
		return pk_usuario;
	}

	public void setPk_usuario(int pk_usuario) {
		this.pk_usuario = pk_usuario;
	}

	public int getPk_medico() {
		return pk_medico;
	}

	public void setPk_medico(int pk_medico) {
		this.pk_medico = pk_medico;
	}

	public java.sql.Timestamp getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(java.sql.Timestamp datainicio) {
		 this.datainicio = datainicio;    
	       
	}

	public java.sql.Timestamp getDatatermino() {
		return datatermino;
	}

	public void setDatatermino(java.sql.Timestamp datatermino) {
		 this.datatermino = datatermino;    
	       
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
