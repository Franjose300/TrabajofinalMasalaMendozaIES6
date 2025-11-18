package ies6.edu.ar.tpfinalmendozafrancisco.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import ies6.edu.ar.tpfinalmendozafrancisco.model.Usuario;
import ies6.edu.ar.tpfinalmendozafrancisco.service.UsuarioService;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UsuarioController {

    @Qualifier("servicioUsuarioMySQL")
    @Autowired
    UsuarioService usuarioService;
        

    @GetMapping ("/usuario")
    public ModelAndView getUsuario() {

        //Usuario nuevoUsuario = new Usuario();
        //nuevoUsuario.setApellido("Nuevo Apellido");
        //nuevoUsuario.setNombre("Nuevo Nombre");

        ModelAndView carrito = new ModelAndView("usuario");
        carrito.addObject("nuevoUsuario", usuarioService.crearNuevoUsuario());
        carrito.addObject("band", false);
        return carrito;
    } 

    @PostMapping("/guardarUsuario")
    public ModelAndView saveUsuario(@ModelAttribute ("nuevoUsuario") Usuario usuarioParaGuardar) {

        usuarioService.agregarUsuario(usuarioParaGuardar);
        //estructura de datos que permite almacenar datos
        //guardar el alumno

        ModelAndView modelView = new ModelAndView("listaUsuarios");


        //System.out.println("usuario guardado");
        
        modelView.addObject("listadoUsuario", usuarioService.listarTodosUsuarios());
        

        return modelView;
    }

    //eliminar
    @GetMapping("/eliminarUsuario/{dni}")
    public ModelAndView eliminarUsuario(@PathVariable("dni") String dni) {
        ModelAndView carritoDeEliminar = new ModelAndView("listaUsuarios");
        usuarioService.borrarUsuario(dni);
        carritoDeEliminar.addObject("listadoUsuario", usuarioService.listarTodosUsuariosActivos());
        return carritoDeEliminar;
    }


      //modificar
    @GetMapping("/modificarUsuario/{dni}")
    public ModelAndView buscarUsuarioParaModificar(@PathVariable("dni") String dni) throws Exception {
        ModelAndView carritoParaModificarUsuario = new ModelAndView("usuario");
        carritoParaModificarUsuario.addObject("nuevoUsuario", usuarioService.buscarUnUsuario(dni));
        carritoParaModificarUsuario.addObject("band", true);
        return carritoParaModificarUsuario;
    }

  @PostMapping("/modificarUsuario")
    public ModelAndView modificarUsuario(@ModelAttribute("nuevoUsuario") Usuario usuarioModificado){
        ModelAndView listadoEditado = new ModelAndView("listaUsuario");
        usuarioService.agregarUsuario(usuarioModificado);
        listadoEditado.addObject("listadoUsuario", usuarioService.listarTodosUsuariosActivos());
        
        return listadoEditado;
    }

    @GetMapping("/listarUsuario")
    public ModelAndView listarUsuariosActivos() {
        ModelAndView carritoParaMostrarUsuarios = new ModelAndView("listaUsuario");
        carritoParaMostrarUsuarios.addObject("listadoUsuario", usuarioService.listarTodosUsuariosActivos());
        return carritoParaMostrarUsuarios;
    }

}
