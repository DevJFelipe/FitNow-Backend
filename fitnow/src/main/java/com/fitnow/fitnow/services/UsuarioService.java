package com.fitnow.fitnow.services;

import java.util.List;

import com.fitnow.fitnow.entity.Usuario;

public interface UsuarioService {

	public List<Usuario> findAll();
	
	public Usuario save(Usuario usuario);
	
	public Usuario findById(String idUsuario);
	
	public void delete(Usuario usuario);

}
