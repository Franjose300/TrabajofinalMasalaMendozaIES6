package ies6.edu.ar.tpfinalmendozafrancisco.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ies6.edu.ar.tpfinalmendozafrancisco.model.Conductor;

@Repository
public interface ConductorRepository extends CrudRepository<Conductor,Integer> {

    List<Conductor> findByEstado(boolean estado);
    
}
