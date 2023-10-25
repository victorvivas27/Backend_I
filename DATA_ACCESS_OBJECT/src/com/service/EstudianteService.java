
package com.service;
import com.model.Estudiante;
import com.utilidades.IDao;
import java.util.List;

public class EstudianteService {
	private IDao<Estudiante> estudianteDao;

	public EstudianteService() {
	}

	public EstudianteService(IDao<Estudiante> estudianteDao) {
		this.estudianteDao = estudianteDao;
	}

	public void setEstudianteDao(IDao<Estudiante> estudianteDao) {
		this.estudianteDao = estudianteDao;
	}

	public Estudiante guardarEstudiante(Estudiante estudiante){
		if (estudianteDao != null) {
			estudianteDao.guardar(estudiante);
			return estudiante;
		} else {
			throw new IllegalStateException("El estudianteDao no está inicializado.");
		}
	}

	public void eliminarEstudiante(Long id){
		if (estudianteDao != null) {
			estudianteDao.eliminar(id);
		} else {
			throw new IllegalStateException("El estudianteDao no está inicializado.");
		}
	}

	public Estudiante buscar(Long id){
		if (estudianteDao != null) {
			return estudianteDao.buscar(id);
		} else {
			throw new IllegalStateException("El estudianteDao no está inicializado.");
		}
	}

	public List<Estudiante> buscarTodos(){
		if (estudianteDao != null) {
			return estudianteDao.buscarTodos();
		} else {
			throw new IllegalStateException("El estudianteDao no está inicializado.");
		}
	}
}