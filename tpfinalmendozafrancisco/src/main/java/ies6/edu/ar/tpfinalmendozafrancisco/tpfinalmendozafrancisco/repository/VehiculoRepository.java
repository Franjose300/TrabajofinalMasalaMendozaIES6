package ies6.edu.ar.tpfinalmasalacamila.tpfinalmasalacamila.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ies6.edu.ar.tpfinalmasalacamila.tpfinalmasalacamila.Model.Vehiculo;

@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo,String> {

    List<Vehiculo> findByEstado(boolean estado);
    
}
