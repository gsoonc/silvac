package com.gdsc.silvac.backend.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.gdsc.silvac.backend.models.entity.Auto;

public interface IAutoRepository extends JpaRepository<Auto,Integer> {

}
