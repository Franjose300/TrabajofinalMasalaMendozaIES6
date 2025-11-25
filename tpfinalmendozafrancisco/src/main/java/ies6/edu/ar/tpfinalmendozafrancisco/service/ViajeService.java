package ies6.edu.ar.tpfinalmendozafrancisco.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ies6.edu.ar.tpfinalmendozafrancisco.model.TipoVehiculo;
import ies6.edu.ar.tpfinalmendozafrancisco.model.TipoViaje;
import ies6.edu.ar.tpfinalmendozafrancisco.model.Viaje;

@Service
public interface ViajeService {

    public void borraViaje(Integer idViaje) throws Exception;
    public Viaje agregarViaje(Viaje viaje);
    public void modificarViaje(Viaje viaje);
    public List<Viaje> listarTodosViajes();
    public Viaje buscarUnViaje(Integer idViaje) throws Exception;
    public Viaje crearNuevoViaje();
    public double calcularPrecio(TipoViaje tipoViaje, TipoVehiculo tipoVehiculo);
    
}
