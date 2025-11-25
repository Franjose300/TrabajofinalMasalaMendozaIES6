package ies6.edu.ar.tpfinalmendozafrancisco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ies6.edu.ar.tpfinalmendozafrancisco.model.Viaje;

@Repository
public interface ViajeRepository extends JpaRepository <Viaje, Integer>{
    
}
