package ies6.edu.ar.tpfinalmendozafrancisco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ies6.edu.ar.tpfinalmendozafrancisco.model.Vehiculo;
import ies6.edu.ar.tpfinalmendozafrancisco.service.VehiculoService;

@Controller
public class VehiculoController {

    @Autowired
    @Qualifier("servicioVehiculoMySQL")
    VehiculoService vehiculoService;

    @GetMapping("/vehiculo")
    public ModelAndView getVehiculo() {

       // Vehiculo nuevoVehiculo = new Vehiculo();

        ModelAndView carrito = new ModelAndView("vehiculo");
        carrito.addObject("nuevoVehiculo", vehiculoService.crearNuevoVehiculo());
        return carrito;
    }

    @PostMapping("/guardarVehiculo")
    public ModelAndView saveVehiculo(@ModelAttribute("nuevoVehiculo")Vehiculo vehiculoParaGuardar) {

        vehiculoService.agregarVehiculo(vehiculoParaGuardar);

        //vehiculoService.agregarVehiculo(vehiculoParaGuardar);
        ModelAndView modelAndView = new ModelAndView("listaVehiculos");
        System.out.println("vehiculo guardado correctamente");
        modelAndView.addObject("listadoVehiculo", vehiculoService.listarTodosVehiculos());
        return modelAndView;

    } 

    //eliminar
    @GetMapping("/eliminarVehiculo/{patente}")
    public ModelAndView eliminarVehiculo(@PathVariable("patente") String patente) {
        ModelAndView carritoDeEliminar = new ModelAndView("listaVehiculos");
        vehiculoService.borrarVehiculo(patente);
        carritoDeEliminar.addObject("listadoVehiculo", vehiculoService.listarTodosVehiculosActivos());
        return carritoDeEliminar;
    }


      //modificar
    @GetMapping("/modificarVehiculos/{patente}")
    public ModelAndView buscarVehiculoParaModificar(@PathVariable("patente") String patente) throws Exception {
        ModelAndView carritoParaModificarVehiculo = new ModelAndView("vehiculo");
        carritoParaModificarVehiculo.addObject("nuevoVehiculo", vehiculoService.buscarUnVehiculo(patente));
        carritoParaModificarVehiculo.addObject("band", true);
        return carritoParaModificarVehiculo;
    }

  @PostMapping("/modificarVehiculo")
    public ModelAndView modificarVehiculo(@ModelAttribute("nuevoVehiculo") Vehiculo vehiculoModificado){
        ModelAndView listadoEditado = new ModelAndView("listaVehiculo");
        vehiculoService.agregarVehiculo(vehiculoModificado);
        listadoEditado.addObject("listadoVehiculo", vehiculoService.listarTodosVehiculosActivos());
        
        return listadoEditado;
    }

    @GetMapping("/listarVehiculo")
    public ModelAndView listarVehiculosActivos() {
        ModelAndView carritoParaMostrarVehiculo = new ModelAndView("listaVehiculo");
        carritoParaMostrarVehiculo.addObject("listadoVehiculo", vehiculoService.listarTodosVehiculosActivos());
        return carritoParaMostrarVehiculo;
    }



}