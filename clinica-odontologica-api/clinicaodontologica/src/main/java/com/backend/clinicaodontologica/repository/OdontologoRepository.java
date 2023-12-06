package com.backend.clinicaodontologica.repository;

import com.backend.clinicaodontologica.entity.Odontologo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends MongoRepository<Odontologo, String> {

}
