package com.backend.clase.service;

import com.backend.clase.dao.IDao;
import com.backend.clase.model.Medicamento;

import java.util.List;

public class MedicamentoService {
	//Capa de logica de negocio que interactua con la capa de persistencia,pero deconoce
	//los detalles de la implementacion de esa persistencia.
	private final IDao<Medicamento> medicamentoIDao;

	public MedicamentoService(IDao<Medicamento> medicamentoIDao) {
		this.medicamentoIDao = medicamentoIDao;
	}

	public Medicamento registrarMedicamento(Medicamento medicamento) {
		return medicamentoIDao.registrar(medicamento);

	}

	public Medicamento buscarMedicamentoId(int id) {
		return medicamentoIDao.buscarPorId(id);
	}

	public Medicamento eliminarMedicamento(int id) {
		return medicamentoIDao.eliminar(id);
	}

	public List<Medicamento> buscarTodosMedicamentos() {
		return medicamentoIDao.buscarTodo();
	}
}
