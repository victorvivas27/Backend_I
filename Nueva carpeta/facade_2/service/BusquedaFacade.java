package com.facade.facade_2.service;

import com.facade.facade_2.model.Hotel;
import com.facade.facade_2.model.Vuelo;

import java.util.List;

public class BusquedaFacade {
	private SistemaVuelo sistemaVuelo;
	private SistemaHotel sistemaHotel;

	public BusquedaFacade(SistemaVuelo sistemaVuelo, SistemaHotel sistemaHotel) {
		this.sistemaVuelo = sistemaVuelo;
		this.sistemaHotel = sistemaHotel;
	}

	public void buscarVueloYHotel(String ciudad, String fechaDesde) {
		// Realiza la búsqueda de vuelos en el sistema de vuelo
		List<Vuelo> vuelosDisponibles = sistemaVuelo.buscarVuelos(ciudad, fechaDesde);

		// Realiza la búsqueda de hoteles en el sistema de hotel
		List<Hotel> hotelesDisponibles = sistemaHotel.buscarHoteles(ciudad, fechaDesde);

		// Muestra los vuelos disponibles por pantalla
		System.out.println("Vuelos disponibles:");
		for (Vuelo vuelo : vuelosDisponibles) {
			System.out.println(vuelo);
		}

		// Muestra los hoteles disponibles por pantalla
		System.out.println("Hoteles disponibles:");
		for (Hotel hotel : hotelesDisponibles) {
			System.out.println(hotel);
		}
	}



}

