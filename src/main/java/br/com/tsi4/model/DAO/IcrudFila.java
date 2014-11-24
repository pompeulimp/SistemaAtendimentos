package br.com.tsi4.model.DAO;

import java.sql.SQLException;
import java.util.List;

import br.com.tsi4.model.Fila;
import br.com.tsi4.model.Medico;

public interface IcrudFila {
	/**
	 * Insere pacientes na fila de atendimentos
	 * 
	 * @param fila
	 * @return Primary key do objeto gravado.
	 * @throws SQLException
	 */
	public long create(Fila fila) throws SQLException;

	/**
	 * Atualiza os dados de uma fila
	 * 
	 * @param pkKey
	 * @return Primary key do objeto;
	 * @throws SQLException
	 */
	public long update(Fila fila) throws SQLException;

	/**
	 * Deleta um posição da fila
	 * 
	 * @param pkKey
	 * @throws SQLException
	 */
	public boolean delete(long pkKey) throws SQLException;

	/**
	 * Rertorna
	 * 
	 * @return arrayList<T>
	 * @throws SQLException
	 */
	public List<Fila> restriveAllByMedico(Medico medico) throws SQLException;

	/**
	 * Recebe uma chave primaria e torna o Objeto daquele tipo
	 * 
	 * @param pkKLey
	 * @return T
	 * @throws SQLException
	 */
	public Fila retriveOneByPkKey(long pkKLey) throws SQLException;

}
