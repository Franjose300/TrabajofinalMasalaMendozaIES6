package ies6.edu.ar.tpfinalmendozafrancisco.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ies6.edu.ar.tpfinalmendozafrancisco.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {
    public List<Usuario> findByEstado (Boolean estado);
      
}
