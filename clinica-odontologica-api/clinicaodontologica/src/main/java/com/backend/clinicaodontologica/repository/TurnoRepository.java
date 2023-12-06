package com.backend.clinicaodontologica.repository;

import com.backend.clinicaodontologica.entity.Turno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends MongoRepository<Turno, String> {
}
