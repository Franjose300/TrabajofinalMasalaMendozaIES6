package ies6.edu.ar.tpfinalmasalacamila.tpfinalmasalacamila.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ies6.edu.ar.tpfinalmasalacamila.tpfinalmasalacamila.Model.Vehiculo;
import ies6.edu.ar.tpfinalmasalacamila.tpfinalmasalacamila.repository.VehiculoRepository;

@Service
@Qualifier("servicioVehiculoMySQL")
public class VehiculoServiceImpBD implements VehiculoService {

    private final VehiculoServiceImp vehiculoServiceImp;

    
    @Autowired
    Vehiculo nuevoVehiculo;
    //VehiculoService vehiculoService;

    @Autowired
    VehiculoRepository vehiculoRepository;


    VehiculoServiceImpBD(VehiculoServiceImp vehiculoServiceImp) {
        this.vehiculoServiceImp = vehiculoServiceImp;
    }



    @Override
    public void borrarVehiculo(String patente) {
       vehiculoRepository.deleteById(patente);
    }

    @Override
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
    }

    @Override
    public void modificarVehiculo(Vehiculo vehiculo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarVehiculo'");
    }

    @Override
    public List<Vehiculo> listarTodosVehiculos() {
       return (List<Vehiculo>) vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo buscarUnVehiculo(String patente) {
        return vehiculoRepository.findById(patente).orElseThrow(() -> new RuntimeException("Vehiculo no encontrado con patente: " + patente));
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
        return vehiculoRepository.findByEstado(true);
    }

    
    
}
