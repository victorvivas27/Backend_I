package com.test;

import com.model.Estudiante;
import com.service.EstudianteService;
import com.utilidades.EstudianteDaoEnMemoria;
import com.utilidades.EstudianteDaoH2;
import com.utilidades.IDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EstudianteServiceTest {
	private IDao<Estudiante> estudianteDaoEnMemoria = new EstudianteDaoEnMemoria(new ArrayList());
	private IDao<Estudiante> estudianteDaoH2 = new EstudianteDaoH2();
	private EstudianteService estudianteService = new EstudianteService();

	@Before
	public void cargarEstudiantesCambiandoImplementacionDAO() {
		estudianteDaoEnMemoria = new EstudianteDaoEnMemoria(new ArrayList<>());
		estudianteDaoH2 = new EstudianteDaoH2();
		estudianteService.setEstudianteDao(estudianteDaoEnMemoria);
		estudianteService.guardarEstudiante(new Estudiante(1L, "EstudianteUno", "ApellidoUno"));
		estudianteService.setEstudianteDao(estudianteDaoH2);
		estudianteService.guardarEstudiante(new Estudiante(2L, "EstudianteDos", "ApellidoDos"));
	}
	@Test
	public void buscarEstudiantesCambiandoImplementacionDAO(){
		//En este caso estudianteDao estará apuntando a un objeto del tipo EstudianteDaoEnMemoria
		estudianteService.setEstudianteDao(estudianteDaoEnMemoria);
		//Siguiendo el principio de polimorfismo el método buscar se comportará de acuerdo al comportamiento indicado en la clase EstudianteDaoEnMemoria
		Estudiante estudiante = estudianteService.buscar(1L);
		Assert.assertEquals(estudiante.getNombre(),"EstudianteUno");
		Assert.assertEquals(estudiante.getApellido(),"ApellidoUno");
//En este caso estudianteDao estará apuntando a un objeto del tipo EstudianteDaoH2 estudianteService.setEstudianteDao(estudianteDaoH2);
		//Siguiendo el principio de polimorfismo el método buscar se comportará de acuerdo al comportamiento indicado en la clase EstudianteDaoH2
		estudiante = estudianteService.buscar(2L); Assert.assertEquals(estudiante.getNombre(),"EstudianteDos"); Assert.assertEquals(estudiante.getApellido(),"ApellidoDos");
//Conclusión el método buscar se comporta diferente de acuerdo al objeto que estamos referenciando en cada momento.
	}
}