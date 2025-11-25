package ies6.edu.ar.tpfinalmendozafrancisco.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ies6.edu.ar.tpfinalmendozafrancisco.model.Vehiculo;

@Service
@Qualifier("servicioVehiculoArrayLIst")
public class VehiculoServiceImp implements VehiculoService {

     List<Vehiculo> listadoDeVehiculos = new ArrayList<Vehiculo>();

    @Autowired
    Vehiculo nuevoVehiculo;

    @Override
    public void borrarVehiculo(String patente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarVehiculo'");
    }

    @Override
    public void agregarVehiculo(Vehiculo vehiculo) {
        listadoDeVehiculos.add(vehiculo);
        System.out.println(listadoDeVehiculos.size());
    }

    @Override
    public void modificarVehiculo(Vehiculo vehiculo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarVehiculo'");
    }

    @Override
    public List<Vehiculo> listarTodosVehiculos() {
        return listadoDeVehiculos;
    }

    @Override
    public Vehiculo buscarUnVehiculo(String patente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarUnVehiculo'");
    }

    @Override
    public Vehiculo buscarPorNombreVehiculo(String patente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorNombreVehiculo'");
    }

    @Override
    public Vehiculo crearNuevoVehiculo() {
        return nuevoVehiculo;
    }

    @Override
    public List<Vehiculo> listarTodosVehiculosActivos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodosVehiculosActivos'");
    }

    


}