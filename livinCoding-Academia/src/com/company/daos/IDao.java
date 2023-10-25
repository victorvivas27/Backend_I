package com.company.daos;

import java.util.List;

public interface IDao<Tipo>{

	public  Tipo guardar(Tipo tipo);
	public  void  eliminar (Long id);
	public  Tipo  buscar (Long id);
	public List <Tipo> buscarTodo();


}
