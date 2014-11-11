package br.com.tsi4.model.DAO;

import java.sql.SQLException;
import java.util.List;

public interface ICRUD<T> {
	/**
	 * recebe um objeto de um tipo qualquer e grava esse tipo no banco;
	 * 
	 * @param obj
	 * @return Primary key do objeto gravado. 
	 * @throws SQLException 
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
	 * Deleta um determidado objeto do banco usando 
	 * deve retornar um boolan;
	 * @param pkKey
	 * @throws SQLException 
	 */
	public boolean delete(long pkKey) throws SQLException;
	/**
	 * retorna todos do mesmo Tipo no banco de dados;
	 * @return arrayList<T>
	 * @throws SQLException 
	 */
	public List<T> restriveAll() throws SQLException;
	/**
	 * Recebe uma chave primaria e torna o Objeto daquele tipo
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
