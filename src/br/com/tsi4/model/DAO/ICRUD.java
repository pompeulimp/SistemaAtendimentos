package br.com.tsi4.model.DAO;

import java.sql.SQLException;
import java.util.List;

public interface ICRUD<T> {
	/**
	 * recebe um objeto de um tipo qualquer e grava esse tipo no banco;
	 * 
	 * @param obj
	 * @return Primary key do objeto gravado ou -1 se não gravar. 
	 * @throws SQLException deve ser tratada com try cat
	 */
	public long create (T obj) throws SQLException;
	/**
	 * Atualiza os dados de um determinado
	 * 
	 * @param pkKey
	 * @return Primary key do objeto;
	 * @throws SQLException 
	 */
	public long update(T obj) throws SQLException;
	/**
	 * Deletar um determidado objeto do banco de dados 
	 * deve retornar um boolean;
	 * @param um objeto do tipo desejado
	 * @throws SQLException 
	 */
	public boolean delete(T obj) throws SQLException;
	/**
	 * retorna todos objetos do mesmo Tipo no banco de dados;
	 * @return arrayList<T>
	 * @throws SQLException 
	 */
	public List<T> restriveAll() throws SQLException;
	/**
	 * Recebe uma chave primaria e retorna e retoronara um
	 * objeto do banco que tenha essa chave
	 * @param pkKLey
	 * @return T
	 * @throws SQLException 
	 */
	public T retriveOneByPkKey(long pkKLey) throws SQLException;
	/**
	 * Deve receber um nome com parametro e retornar uma lista de objetos
	 * com esses nomes.
	 * @param nome
	 * @return arrayList<T>
	 * @throws SQLException 
	 */
	public List<T> retriveByName(String  nome) throws SQLException;
}
