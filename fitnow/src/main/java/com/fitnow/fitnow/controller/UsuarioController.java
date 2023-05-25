package com.fitnow.fitnow.controller;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitnow.fitnow.entity.Usuario;
import com.fitnow.fitnow.services.UsuarioService;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
	
	//Usuarios

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value="/usuarios")
	public ResponseEntity<Object> get(){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Usuario> list = usuarioService.findAll();
			return new ResponseEntity<Object>(list,HttpStatus.OK);
		}
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/usuarios/{idUsuario}")
	public ResponseEntity<Object> getById(@PathVariable Integer idUsuario){
		try {
			Usuario data = usuarioService.findById(idUsuario);
			return new ResponseEntity<Object>(data,HttpStatus.OK);
		}
		catch (Exception e ) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/usuarios")
	public ResponseEntity<Object> create(@RequestBody Usuario usuarios){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Usuario res = usuarioService.save(usuarios);  
			return new ResponseEntity<Object>(res,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}
	
	@PutMapping("/usuarios/{idUsuario}")
	public ResponseEntity<Object> update(@RequestBody Usuario usuarios, @PathVariable Integer idUsuario){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			Usuario currentUsuario = usuarioService.findById(idUsuario);
			
			currentUsuario.setNombreCompleto(usuarios.getNombreCompleto());
			currentUsuario.setFechaNacimiento(usuarios.getFechaNacimiento());
			currentUsuario.setGenero(usuarios.getGenero());
			currentUsuario.setCorreoElectronico(usuarios.getCorreoElectronico());
			currentUsuario.setAlturaCm(usuarios.getAlturaCm());
			currentUsuario.setPesoKg(usuarios.getPesoKg());
			currentUsuario.setNivelActividad(usuarios.getNivelActividad());
			currentUsuario.setFechaRegistro(usuarios.getFechaRegistro());
			currentUsuario.setEdad(usuarios.getEdad());
			currentUsuario.setContrasena(usuarios.getContrasena());
			//currentUsuario.setObjetivos(usuario.getObjetivos());
			
			
			Usuario res = usuarioService.save(usuarios);
			
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		}
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/usuarios/{idUsuario}")
	public ResponseEntity<Object> deleteUser(@PathVariable Integer idUsuario){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Usuario currentUsuario = usuarioService.findById(idUsuario);
			usuarioService.delete(currentUsuario);
			map.put("deleted", true);
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}







