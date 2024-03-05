package com.gdsc.silvac.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdsc.silvac.backend.models.entity.Auto;
import com.gdsc.silvac.backend.services.IAutoService;

@RestController
@RequestMapping("/api/autos")
public class AutoRestController {

	@Autowired
	private IAutoService Autoservice;
	
	@GetMapping("/autos")
	public List<Auto>index(){
		return Autoservice.findAll();
	}
	
	//Obtener un auto por id
	@GetMapping("/{id}")
	 public Auto verAuto(@PathVariable("id")Integer id) {
		return Autoservice.getAutoInformation(id);
	}
	
	//Agregar un auto
	@PostMapping()
	public Auto agregarAuto(@RequestBody Auto auto) {
		return Autoservice.registerAuto(auto);
	}
	
	//Actualizar Auto
	@PutMapping()
	public Auto actualizarAuto(@RequestBody Auto auto) {
		return Autoservice.updateAuto(auto);
	}
	
	//Eliminar Auto
	@DeleteMapping("/{id}")
	public void eliminarAuto(@PathVariable("id")Integer id) {
		Autoservice.removeAuto(id);
	}
	
	
	
	
}
