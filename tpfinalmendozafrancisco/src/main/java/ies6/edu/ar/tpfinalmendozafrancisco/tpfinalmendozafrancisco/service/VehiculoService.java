package ies6.edu.ar.tpfinalmasalacamila.tpfinalmasalacamila.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ies6.edu.ar.tpfinalmasalacamila.tpfinalmasalacamila.Model.Vehiculo;

@Service
public interface VehiculoService {
    
    public void borrarVehiculo(String patente);
    public void agregarVehiculo(Vehiculo vehiculo);
    public void modificarVehiculo(Vehiculo vehiculo);
    public List<Vehiculo> listarTodosVehiculos();
    public Vehiculo buscarUnVehiculo(String patente);
    public Vehiculo buscarPorNombreVehiculo(String patente);
    public Vehiculo crearNuevoVehiculo();
    public List<Vehiculo> listarTodosVehiculosActivos();
    
}
