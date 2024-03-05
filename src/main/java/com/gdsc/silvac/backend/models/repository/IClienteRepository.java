package com.gdsc.silvac.backend.models.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.gdsc.silvac.backend.models.entity.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente,Integer> {
	 Optional<Cliente> findByDni(String dni);
}
