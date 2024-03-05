package com.gdsc.silvac.backend.services;

import java.util.List;

import com.gdsc.silvac.backend.models.entity.Auto;

public interface IAutoService {
	public Auto getAutoInformation(Integer codauto);
	public Auto registerAuto(Auto auto);
	public Auto updateAuto(Auto auto);
	public void removeAuto(Integer codauto);
	public List<Auto> findAll();
	
}
