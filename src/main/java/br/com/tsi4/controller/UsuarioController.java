package br.com.tsi4.controller;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.tsi4.model.Usuario;
import br.com.tsi4.model.DAO.ICRUD;
import br.com.tsi4.model.DAO.UsuarioDAO;

@Controller
public class UsuarioController {
	
	@Inject
	private Result result;
	private ICRUD<Usuario> icrud;
	@Inject
	private Usuario usuario;
	private String mensagen = null;

	public UsuarioController() {
		this.icrud = new UsuarioDAO();
	}

	public void formulario() {
	}

	public void editar(long pkKey) {
		try {
			this.usuario = icrud.retriveOneByPkKey(pkKey);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include(this.usuario);
		result.of(this).formulario();
	}

	public void deletar(long pkKey){
		try {
			if(icrud.delete(pkKey)){
				mensagen = "deletado";
			}else{
				mensagen = "não econtroado";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include("mensagem", "Usuario " + mensagen);
		result.redirectTo(this).listar();
	}

	public void create(Usuario usuario) {
		System.out.println(usuario.toString());
		try {
			if (usuario.getPkUsuario() != 0) {
				icrud.update(usuario);
				mensagen = "atualisado";
			} else {
				icrud.create(usuario);
				mensagen = "criado";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		result.include("mensagem", "Usuario " + mensagen + " com sucesso!");
		result.redirectTo(this).listar();
	}

	public List<Usuario> listar() {
		try {
			return icrud.restriveAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
