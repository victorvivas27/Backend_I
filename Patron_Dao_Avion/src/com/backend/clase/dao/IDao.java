package com.backend.clase.dao;

import java.util.List;

public interface IDao<T> {
	T registrarAvion(T t);

	T buscarAvionPorId(int id);

	T eliminarAvion(int id);

	List<T> buscarTodosAviones();
}
