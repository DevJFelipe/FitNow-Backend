package com.fitnow.fitnow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitnow.fitnow.entity.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Integer>{


}
