package com.backend.clase.sevice;

import com.backend.clase.dao.IDao;
import com.backend.clase.model.Avion;

public class AvionService {
	private final IDao<Avion> avionIDao;

	public AvionService(IDao<Avion> avionIDao) {
		this.avionIDao = avionIDao;
	}

	public Avion registrarAvion(Avion avion) {
		return avionIDao.registrarAvion(avion);
	}
}
