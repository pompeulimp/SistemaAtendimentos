package testBlackBox;

import java.sql.SQLException;

import br.com.tsi4.model.Paciente;

public interface IPacienteDAO {
	Paciente retriveByCPF(String cpf) throws SQLException;
}
