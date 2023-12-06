package com.backend.clinicaodontologica.service.inplementacion;

import com.backend.clinicaodontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaodontologica.dto.modificacion.OdontologoModificacionEntradaDto;
import com.backend.clinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaodontologica.entity.Odontologo;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.backend.clinicaodontologica.repository.OdontologoRepository;
import com.backend.clinicaodontologica.service.IOdontologoService;
import com.backend.clinicaodontologica.util.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService implements IOdontologoService {
	private final Logger LOGGER = LoggerFactory.getLogger(OdontologoService.class);

	private final OdontologoRepository odontologoRepository;

	private final ModelMapper modelMapper;

	public OdontologoService(OdontologoRepository odontologoRepository, ModelMapper modelMapper) {
		this.odontologoRepository = odontologoRepository;
		this.modelMapper = modelMapper;


	}

	@Override
	public OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo) {
		Odontologo odontologoAPersistir = odontologoRepository.save(dtoEntradaAEntidad(odontologo));
		OdontologoSalidaDto odontologoSalidaDto = modelMapper.map(odontologoAPersistir, OdontologoSalidaDto.class);
		LOGGER.info("Odontologo guardado: {}", JsonPrinter.toString(odontologoSalidaDto));
		return odontologoSalidaDto;
	}

	@Override
	public List<OdontologoSalidaDto> listarOdontologos() {
		List<OdontologoSalidaDto> odontologoSalidaDtos = odontologoRepository.findAll().stream()
				.map(odontologo -> modelMapper.map(odontologo, OdontologoSalidaDto.class)).toList();
		LOGGER.info("Listado de todos los Odontologos:{}", JsonPrinter.toString(odontologoSalidaDtos));

		return odontologoSalidaDtos;
	}

	@Override
	public OdontologoSalidaDto buscarOdontologoPorId(String id) throws ResourceNotFoundException {
		Odontologo odontologoBuscado = odontologoRepository.findById(id).orElse(null);
		OdontologoSalidaDto odontologoEncontrado = null;
		if (odontologoBuscado != null) {

			odontologoEncontrado = modelMapper.map(odontologoBuscado, OdontologoSalidaDto.class);
			LOGGER.info("Odontologo encontrado:{}", JsonPrinter.toString(odontologoBuscado));
		} else {
			LOGGER.error("El id no se encuentra registrado en la base de datos");
			throw new ResourceNotFoundException("No se ha encontrado el odontologo con id " + id);
		}
		return odontologoEncontrado;
	}

	@Override
	public OdontologoSalidaDto actualizarOdontologo(OdontologoModificacionEntradaDto odontologo)
			throws ResourceNotFoundException {
		Odontologo odontologoRecibido = modelMapper.map(odontologo, Odontologo.class);
		Odontologo odontologoAActualizar = odontologoRepository.findById(odontologo.getId()).orElse(null);

		OdontologoSalidaDto odontologoSalidaDto = null;

		if (odontologoAActualizar != null) {
			odontologoAActualizar = odontologoRecibido;
			odontologoRepository.save(odontologoAActualizar);
			odontologoSalidaDto = modelMapper.map(odontologoAActualizar, OdontologoSalidaDto.class);
			LOGGER.warn("Odontologo actualizado: {}", JsonPrinter.toString(odontologoSalidaDto));

		} else {
			LOGGER.error("No fue posible actualizar el domicilio porque no se encuentra en nuestra base de datos");
			throw new ResourceNotFoundException("No fue posible actualizar los datos ya que el odontologo no se encuentra registrado");
		}

		return odontologoSalidaDto;
	}

	@Override
	public void eliminarOdontologo(String id) throws ResourceNotFoundException {

		if (buscarOdontologoPorId(id) != null) {
			odontologoRepository.deleteById(id);
			LOGGER.warn("Odontologo eliminado con id: {}", id);

		} else {
			LOGGER.error("No se ha podido encontrar el odontologo con id:{} ", id);
			throw new ResourceNotFoundException("No se ha encontrado el odontologo con id " + id);
		}
	}

	private Odontologo dtoEntradaAEntidad(OdontologoEntradaDto odontologoEntradaDto) {
		return modelMapper.map(odontologoEntradaDto, Odontologo.class);
	}
}
