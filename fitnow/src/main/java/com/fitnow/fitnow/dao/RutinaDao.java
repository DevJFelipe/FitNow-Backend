package com.fitnow.fitnow.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitnow.fitnow.entity.Rutina;
import com.fitnow.fitnow.entity.Usuario;

@Repository
public interface RutinaDao extends JpaRepository<Rutina, Integer>{
	
	Optional<Rutina> findByUsuario(Usuario usuario);

}
