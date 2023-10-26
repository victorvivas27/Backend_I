package com.backend.clase.dao;

import java.util.List;

public interface IDao<T> {
	T registrar(T t);

	T buscarPorId(int id);

	T eliminar(int id);

	List<T> buscarTodo();
}
