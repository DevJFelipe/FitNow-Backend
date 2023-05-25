package com.fitnow.fitnow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnow.fitnow.dao.UsuarioDao;
import com.fitnow.fitnow.entity.Usuario;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImplement implements UsuarioService{

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	@Transactional
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario){
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public Usuario findById(Integer idUsuario){
		return usuarioDao.findById(idUsuario).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Usuario usuario){
		usuarioDao.delete(usuario);
		
	}

}
