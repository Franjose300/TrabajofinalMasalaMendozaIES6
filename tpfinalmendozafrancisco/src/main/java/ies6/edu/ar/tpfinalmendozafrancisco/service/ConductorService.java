package ies6.edu.ar.tpfinalmendozafrancisco.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ies6.edu.ar.tpfinalmendozafrancisco.model.Conductor;

@Service
public interface ConductorService {
    public void borraConductor(Integer dni) throws Exception;
    public void agregarConductor(Conductor conductor);
    public void modificarConductor(Conductor conductor);
    public List<Conductor> listarTodosConductor();
    public Conductor buscarUnConductor(Integer dni) throws Exception;
    public Conductor crearNuevoConductor();
    public List<Conductor> listarTodosConductorActivos();
}
