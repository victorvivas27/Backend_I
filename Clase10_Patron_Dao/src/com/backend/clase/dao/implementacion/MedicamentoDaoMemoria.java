package com.backend.clase.dao.implementacion;

import com.backend.clase.dao.IDao;
import com.backend.clase.model.Medicamento;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MedicamentoDaoMemoria implements IDao<Medicamento> {
	private final Logger LOGGER = Logger.getLogger(MedicamentoDaoMemoria.class);
	private final List<Medicamento> repositorioMedicamento = new ArrayList<>();

	@Override
	public Medicamento registrar(Medicamento medicamento) {
		repositorioMedicamento.add(medicamento);
		return medicamento;
	}

	@Override
	public Medicamento buscarPorId(int id) {
		for (Medicamento medicamento : repositorioMedicamento) {
			if (medicamento.getId() == id) {
				return medicamento;
			}

		}
		return null;

	}

	@Override
	public Medicamento eliminar(int id) {
		Medicamento medicamentoElimnar = null;
		for (Medicamento medicamento : repositorioMedicamento) {
			if (medicamento.getId() == id) {
				medicamentoElimnar = medicamento;
				break;
			}
			if (medicamentoElimnar != null) {
				repositorioMedicamento.remove(medicamentoElimnar);
			}
		}
		return medicamentoElimnar;
	}

	@Override
	public List<Medicamento> buscarTodo() {
		return new ArrayList<>(repositorioMedicamento);
	}
}
