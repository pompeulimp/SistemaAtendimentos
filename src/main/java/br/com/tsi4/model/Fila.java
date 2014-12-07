package br.com.tsi4.model;

import java.util.Calendar;

public class Fila {

	private long pkFila;
	private long pkPaciente;
	private long pkMedico;
	private boolean status;
	private Calendar horaEntrada;
	private Calendar horaSaida;

	/**
	 * esse contrustor é o construtor de entrada na fila
	 * 
	 * @param pkPaciente
	 * @param pkMedico
	 */
	public Fila(long pkPaciente, long pkMedico) {
		this.pkPaciente = pkPaciente;
		this.pkMedico = pkMedico;
		this.horaEntrada = Calendar.getInstance(); // data hora de entrada
		this.setStatus(true); // entrada na fila
	}
	
	public Fila(boolean status) {
		this.status = status;
		this.horaSaida = Calendar.getInstance();

	}
	/**
	 * * esse contrutor recebe todos paramentros para criar um objeto completo
	 * que vem do banco de dados
	 * 
	 * @param pkFila
	 * @param pkPaciente
	 * @param pkMedico
	 * @param horaEntrada
	 */
	public Fila(long pkFila, long pkPaciente, long pkMedico,
			Calendar horaEntrada, Calendar horaSaida) {
		this.pkFila = pkFila;
		this.pkPaciente = pkPaciente;
		this.pkMedico = pkMedico;
		this.setStatus(false);
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
	}

	public long getPkFila() {
		return pkFila;
	}

	public long getPkPaciente() {
		return pkPaciente;
	}

	public long getPkMedico() {
		return pkMedico;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Calendar getHoraEntrada() {
		return horaEntrada;
	}

	public Calendar getHoraSaida() {
		return horaSaida;
	}

	
	@Override
	public String toString() {
		return "Fila [pkFila=" + pkFila + ", pkPaciente=" + pkPaciente
				+ ", pkMedico=" + pkMedico + ", status=" + status
				+ ", horaEntrada=" + horaEntrada + ", horaSaida=" + horaSaida
				+ "]";
	}

}
