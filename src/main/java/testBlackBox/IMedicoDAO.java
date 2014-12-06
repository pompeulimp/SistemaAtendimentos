package testBlackBox;

import java.sql.SQLException;

import br.com.tsi4.model.Medico;

public interface IMedicoDAO {

	Medico retriveByCRM(String string) throws SQLException;

}
