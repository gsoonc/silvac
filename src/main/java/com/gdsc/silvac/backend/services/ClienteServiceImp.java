package com.gdsc.silvac.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdsc.silvac.backend.models.entity.Cliente;
import com.gdsc.silvac.backend.models.repository.IClienteRepository;
import com.gdsc.silvac.backend.services.exception.ClienteAlreadyExists;

//PARA INDICAR QUE ESTA CLASE DARÁ SERVICIO A OTRAS SE COLOCA EL SERVICE.
@Service
public class ClienteServiceImp implements IClienteService {
	//INYECCIÓN DE DEPENDENCIAS se usa autowired.
	@Autowired
	private IClienteRepository clienteDao;
	
	
	
	@Override
	@Transactional (readOnly = true)
	public List<Cliente> findAll() {
		
		//Retorna los clientes		
		return (List<Cliente>) clienteDao.findAll();

	}



	@Override
    @Transactional
    public Cliente guardarCliente(Cliente cliente) {
		 // Verificar si el campo DNI no es nulo
	    if (cliente.getDni() == null) {
	        throw new IllegalArgumentException("El campo DNI no puede ser nulo.");
	    }
        // Verificar si el cliente ya existe en la base de datos
        Optional<Cliente> clienteExistente = clienteDao.findByDni(cliente.getDni());
        if (clienteExistente.isPresent()) {
            // Si el cliente ya existe, podrías lanzar una excepción o manejar el caso según tus necesidades
            throw new ClienteAlreadyExists("El cliente con DNI " + cliente.getDni() + " ya está registrado.");
        } else {
            // Si el cliente no existe, guardar el nuevo cliente en la base de datos
            return clienteDao.save(cliente);
        }
    }

}
