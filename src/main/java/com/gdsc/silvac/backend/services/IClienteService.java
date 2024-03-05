package com.gdsc.silvac.backend.services;

import java.util.List;

import com.gdsc.silvac.backend.models.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();
	
	
	Cliente guardarCliente(Cliente cliente);
}
