package ies6.edu.ar.tpfinalmendozafrancisco.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ies6.edu.ar.tpfinalmendozafrancisco.model.Vehiculo;

@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo, String> {

    List<Vehiculo> findByEstado(boolean estado);

    
}
