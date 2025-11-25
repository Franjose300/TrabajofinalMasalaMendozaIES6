package ies6.edu.ar.tpfinalmendozafrancisco.controller;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ies6.edu.ar.tpfinalmendozafrancisco.model.TipoVehiculo;
import ies6.edu.ar.tpfinalmendozafrancisco.model.TipoViaje;
import ies6.edu.ar.tpfinalmendozafrancisco.model.Viaje;
import ies6.edu.ar.tpfinalmendozafrancisco.service.UsuarioService;
import ies6.edu.ar.tpfinalmendozafrancisco.service.VehiculoService;
import ies6.edu.ar.tpfinalmendozafrancisco.service.ViajeService;

@Controller
public class ViajeController {

    @Qualifier("servicioViajeMySQL")
    @Autowired
    ViajeService viajeService;

    @Qualifier("servicioVehiculoMySQL")
    @Autowired
    VehiculoService vehiculoService;

    @Qualifier("servicioUsuarioMySQL")
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/viaje/{patente}")
    public ModelAndView getViaje(@PathVariable("patente") String patente) throws Exception {

        // carrito para la vista
        ModelAndView carrito = new ModelAndView("viaje");
        // crea un viaje nuevo
        Viaje viajeNuevo = viajeService.crearNuevoViaje();
        // asiga el vehiculando usando la patente
        viajeNuevo.setVehiculo(vehiculoService.buscarUnVehiculo(patente));
        // agrega al carrito el viaje vacio pero con el vehiculo ya cargado
        carrito.addObject("nuevoViaje", viajeNuevo);
        // lista de los usuarios
        carrito.addObject("listadoUsuario", usuarioService.listarTodosUsuariosActivos());
        return carrito;
    }

    @PostMapping("/guardarViaje")
    public ModelAndView saveViaje(@ModelAttribute("nuevoViaje") Viaje viajeParaGuardar) {

        ModelAndView modelAndView = new ModelAndView("ticketViaje");

        try {
            // 1️⃣ Obtener la patente y el dni desde el objeto viaje
            String patente = viajeParaGuardar.getVehiculo().getPatente();
            Integer dni = viajeParaGuardar.getUsuario().getDni();

            // 2️⃣ Volver a buscar los objetos completos en la BD
            viajeParaGuardar.setVehiculo(vehiculoService.buscarUnVehiculo(patente));
            viajeParaGuardar.setUsuario(usuarioService.buscarUnUsuario(dni));

            // 3️⃣ Calcular el precio
            TipoViaje tipoViaje = viajeParaGuardar.getTipoViaje();
            TipoVehiculo tipoVehiculo = viajeParaGuardar.getVehiculo().getTipoVehiculo();
            double precioFinal = viajeService.calcularPrecio(tipoViaje, tipoVehiculo);
            viajeParaGuardar.setPrecio(precioFinal);

            // 4️⃣ Guardar el viaje completo
            Viaje viajeGuardado = viajeService.agregarViaje(viajeParaGuardar);

            // 5️⃣ Enviar el viaje guardado a la vista ticket
            modelAndView.addObject("viaje", viajeGuardado);

        } catch (Exception e) {
            modelAndView.setViewName("viaje"); // si hay error, vuelve al formulario
            modelAndView.addObject("errorViaje", "Error al guardar el viaje: " + e.getMessage());
        }

        return modelAndView;
    }

    // vista para listar los viajes
    @GetMapping("/listarViajes")
    public ModelAndView mostrarViajes() {
        ModelAndView carritoParaMostrarViajes = new ModelAndView("listaViajes");
        carritoParaMostrarViajes.addObject("listadoViajes", viajeService.listarTodosViajes());
        return carritoParaMostrarViajes;
    }

    // vista de los vehiculo para realizar los viajes
    @GetMapping("/realizarViajes")
    public ModelAndView listarviaje() {
        ModelAndView carritoParaMostrarVehiculos = new ModelAndView("realizarViaje");
        carritoParaMostrarVehiculos.addObject("listadoVehiculo", vehiculoService.listarTodosVehiculosActivos());
        return carritoParaMostrarVehiculos;
    }

}
