package com.fitnow.fitnow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fitnow.fitnow.entity.Rutina;
import com.fitnow.fitnow.entity.RutinaResponse;
import com.fitnow.fitnow.services.UsuarioService;
import com.fitnow.fitnow.dao.RutinaDao;
import com.fitnow.fitnow.entity.Usuario;

@RestController
@RequestMapping("/api/v1/rutina")
public class RutinaController {
	
	@Autowired
	private RutinaDao rutinaDao;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/list")
	public List<Rutina> findAll(){
		return rutinaDao.findAll();
	}
	
	@PostMapping()
	public ResponseEntity<Object> create(@RequestBody Rutina rutina){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Rutina res = rutinaDao.save(rutina);  
			return new ResponseEntity<Object>(res,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}
	
	@PostMapping("/assign/{idUsuario}/{idRutina}")
	public Rutina assignByUser(@PathVariable int idUsuario,@PathVariable int idRutina) {
		Rutina rutina = rutinaDao.findById(idRutina).orElseThrow();
		Usuario usuario = usuarioService.findById(idUsuario);
		rutina.setUsuario(usuario);
		return rutinaDao.save(rutina);
	}
	
	@GetMapping("/rutina/{idUsuario}")
	public RutinaResponse findAllByUser(@PathVariable int idUsuario) {
		Usuario usuario = usuarioService.findById(idUsuario);
		RutinaResponse rutinaResponse = new RutinaResponse();
		Rutina rutina = rutinaDao.findByUsuario(usuario).orElseThrow();
		rutinaResponse.setRutina(rutina);
		rutinaResponse.setUsuario(usuario);
		return rutinaResponse;
		
	}
	
	
}
