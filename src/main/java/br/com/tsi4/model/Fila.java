package br.com.tsi4.model;

import java.util.Calendar;

public class Fila {

	private long pkFila;
	private long pkPaciente;
	private long pkMedico;
	private boolean status;
	private final Calendar horaEntrada;
	private Calendar horaSaida;

	/**
	 * esse contrustor é o construtor de entrada na fila
	 * 
	 * @param pkPaciente
	 * @param pkMedico
	 */
	public Fila(long pkPaciente, long pkMedico) {
		this.pkPaciente = pkPaciente;
		this.setPkMedico(pkMedico);
		this.horaEntrada = Calendar.getInstance(); // data hora de entrada
		this.setStatus(true); // entrada na fila
	}

	/**
	 * * 	esse contrutor recebe todos paramentros para criar um objeto completo
	 * 		que vem do banco de dados
	 * 
	 * @param pkFila
	 * @param pkPaciente
	 * @param pkMedico
	 * @param horaEntrada
	 */
	public Fila(long pkFila, long pkPaciente, long pkMedico,
			Calendar horaEntrada) {
		this.pkFila = pkFila;
		this.pkPaciente = pkPaciente;
		this.pkMedico = pkMedico;
		this.setStatus(false);
		this.horaEntrada = horaEntrada;
		this.setHoraSaida(Calendar.getInstance());
	}

	public void setHoraSaida(Calendar horaSaida) {
		this.horaSaida = horaSaida;
	}

	public long getpkFila() {
		return pkFila;
	}

	public long getpkPaciente() {
		return pkPaciente;
	}

	public Calendar getHoraEntrada() {
		return horaEntrada;
	}

	public Calendar getHoraSaida() {
		return horaSaida;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public long getPkMedico() {
		return pkMedico;
	}

	public void setPkMedico(long pkMedico) {
		this.pkMedico = pkMedico;
	}

	@Override
	public String toString() {
		return "Fila [pkFila=" + pkFila + ", pkPaciente=" + pkPaciente
				+ ", pkMedico=" + pkMedico + ", status=" + status
				+ ", horaEntrada=" + horaEntrada + ", horaSaida=" + horaSaida
				+ "]";
	}

}
