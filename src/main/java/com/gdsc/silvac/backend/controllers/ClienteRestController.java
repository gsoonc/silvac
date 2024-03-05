package com.gdsc.silvac.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdsc.silvac.backend.models.entity.Cliente;
import com.gdsc.silvac.backend.services.IClienteService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private IClienteService Clienteservice;
	
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return Clienteservice.findAll();
	}
	
	 @PostMapping("/clientes")
	    public Cliente guardarCliente(@RequestBody Cliente cliente) {
		 System.out.println("Datos recibidos desde Postman: " + cliente.toString());
	        return Clienteservice.guardarCliente(cliente);
	    }
}
