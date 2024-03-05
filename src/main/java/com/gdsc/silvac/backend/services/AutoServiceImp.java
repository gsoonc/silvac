package com.gdsc.silvac.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdsc.silvac.backend.models.entity.Auto;
import com.gdsc.silvac.backend.models.repository.IAutoRepository;
import com.gdsc.silvac.backend.services.exception.AutoAlreadyExists;
import com.gdsc.silvac.backend.services.exception.AutoNotFound;

@Service
public class AutoServiceImp implements IAutoService{

	@Autowired
	private IAutoRepository	autoDao;
	@Override
	@Transactional (readOnly = true)
	public List<Auto> findAll() {
		
		return (List<Auto>)autoDao.findAll();
	}
	

	@Override
	public Auto getAutoInformation(Integer codauto) {
		
		return autoDao.findById(codauto).orElseThrow(()->
			new AutoNotFound("Auto no encontrado"));
	}

	@Override
	public Auto registerAuto(Auto auto) {
	Auto existAuto = autoDao.findById(auto.getCodauto()).orElse(null);
		if(existAuto == null) {
			autoDao.save(auto);
			return auto;
		}
		else throw new AutoAlreadyExists("El auto ya existe");
	}

	@Override
	public Auto updateAuto(Auto auto) {
		Auto existAuto = autoDao.findById(auto.getCodauto()).orElse(null);
		if(existAuto == null)throw new AutoNotFound("Auto no existe");
		else {
			existAuto.setMarca(auto.getMarca());
			existAuto.setModelo(auto.getModelo());
			existAuto.setMatricula(auto.getMatricula());
			existAuto.setColor(auto.getColor());
			existAuto.setGaraje(auto.getGaraje());
			existAuto.setLitraje(auto.getLitraje());
			existAuto.setEntregado(auto.isEntregado());
			autoDao.save(existAuto);
			return existAuto;
		}

	}

	@Override
	public void removeAuto(Integer codauto) {
		Auto existAuto = autoDao.findById(codauto).orElse(null);
		if(existAuto == null)throw new AutoNotFound("Auto no existe");
		else {
			autoDao.delete(existAuto);
			autoDao.flush();
		}
	}


}
