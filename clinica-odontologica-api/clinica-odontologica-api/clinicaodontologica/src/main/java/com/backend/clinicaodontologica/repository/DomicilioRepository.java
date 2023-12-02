package com.backend.clinicaodontologica.repository;

import com.backend.clinicaodontologica.entity.Domicilio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends MongoRepository<Domicilio, String> {
}
