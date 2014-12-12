package br.com.tsi4.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;

import br.com.tsi4.model.Atendimento;
import br.com.tsi4.model.Consulta;
import br.com.tsi4.model.Hospital;
import br.com.tsi4.model.Medico;
import br.com.tsi4.model.Paciente;
import br.com.tsi4.model.DAO.ConsultaDAO;
import br.com.tsi4.model.DAO.ICRUD;

public class ConsultaController implements Serializable {
	private static final long serialVersionUID = 1L;
	private Consulta consulta;
	private ICRUD<Consulta> icrud;

	public void iniciarConsulta(Medico medico, Hospital hospital,
			Atendimento atendimento, Paciente paciente) {
		consulta = new Consulta();
		consulta.setInicioConsulta(new Date());

		if (medico != null && medico.getPkMedico() != 0) {
			consulta.setPk_atendimento(atendimento.getPk_atendimento());
		}
		if (hospital != null && hospital.getPkHospital() != 0) {
			consulta.setPk_hospital(hospital.getPkHospital());
		}
		if (atendimento != null && atendimento.getPk_atendimento() != 0) {
			consulta.setPk_medico(medico.getPkMedico());
		}
		if (paciente != null && paciente.getPk_paciente() != 0) {
			consulta.setPk_paciente(paciente.getPk_paciente());
		}
	}

	public void finalizarConsulta() throws SQLException {
		if (consulta.getInicioConsulta() != null) {
			consulta.setFimConsulta(new Date());
			
			icrud.create(consulta);
		}
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public ICRUD<Consulta> getIcrud() {
		return icrud;
	}

	public void setIcrud(ICRUD<Consulta> icrud) {
		this.icrud = icrud;
	}

}