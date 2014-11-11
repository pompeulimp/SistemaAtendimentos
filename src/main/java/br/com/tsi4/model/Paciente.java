package br.com.tsi4.model;

public class Paciente {
	private long pk_paciente;
	private String nomePaciente;
	private String cpfPaciente;
	private String enderecoPaciente;
	private String telefonePaciente;

	public Paciente() {

	}

	public long getPk_paciente() {
		return pk_paciente;
	}

	public void setPk_paciente(long pk_paciente) {
		this.pk_paciente = pk_paciente;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getCpfPaciente() {
		return cpfPaciente;
	}

	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}

	public String getEnderecoPaciente() {
		return enderecoPaciente;
	}

	public void setEnderecoPaciente(String enderecoPaciente) {
		this.enderecoPaciente = enderecoPaciente;
	}

	public String getTelefonePaciente() {
		return telefonePaciente;
	}

	public void setTelefonePaciente(String telefonePaciente) {
		this.telefonePaciente = telefonePaciente;
	}

	@Override
	public String toString() {
		return "Paciente [pk_paciente=" + pk_paciente + ", nomePaciente="
				+ nomePaciente + ", cpfPaciente=" + cpfPaciente
				+ ", enderecoPaciente=" + enderecoPaciente
				+ ", telefonePaciente=" + telefonePaciente + "]";
	}

}
