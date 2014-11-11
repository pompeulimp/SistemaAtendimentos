package br.com.tsi4.model;

import java.util.Queue;

public class Hospital {

	private long pkHospital;
	private long pkFila;
	private String razaosocial;
	private String nomeFantasia;
	private String cnpj;
	private String enderecoHospital;
	private String telefonehospital;
	private Queue<Paciente>filaAtendimento;
	
	public Hospital() {

	}

	public long getPkHospital() {
		return pkHospital;
	}

	public void setPkHospital(long pkHospital) {
		this.pkHospital = pkHospital;
	}

	public long getPkFila() {
		return pkFila;
	}

	public void setPkFila(long pkFila) {
		this.pkFila = pkFila;
	}

	public String getRazaosocial() {
		return razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEnderecoHospital() {
		return enderecoHospital;
	}

	public void setEnderecoHospital(String enderecoHospital) {
		this.enderecoHospital = enderecoHospital;
	}

	public String getTelefonehospital() {
		return telefonehospital;
	}

	public void setTelefonehospital(String telefonehospital) {
		this.telefonehospital = telefonehospital;
	}

	public Queue<Paciente> getFilaAtendimento() {
		return filaAtendimento;
	}

	public void setFilaAtendimento(Queue<Paciente> filaAtendimento) {
		this.filaAtendimento = filaAtendimento;
	}
	
	@Override
	public String toString() {
		return "Hospital [pkHospital=" + pkHospital + ", razaosocila=" + razaosocial
				+ ", nomeFantasia=" + nomeFantasia + ", cnpj=" + cnpj
				+ ", enderecoHospital=" + enderecoHospital + ", telefonehospital="
				+ telefonehospital + ", filaAtendimento =" + filaAtendimento +"]";
	}
	
}
