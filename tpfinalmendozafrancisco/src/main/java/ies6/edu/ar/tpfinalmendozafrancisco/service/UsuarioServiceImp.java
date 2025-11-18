package ies6.edu.ar.tpfinalmendozafrancisco.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ies6.edu.ar.tpfinalmendozafrancisco.model.Usuario;

@Service
@Qualifier("servicioUsuarioMySQL")
public class UsuarioServiceImp implements UsuarioService {

    List<Usuario> listadoDeUsuarios = new ArrayList<Usuario>();

    @Autowired
    Usuario nuevoUsuario;

    @Override
    public void borrarUsuario(String dni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarUsuario'");
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        
        listadoDeUsuarios.add(usuario);
        System.out.println(listadoDeUsuarios.size());
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarUsuario'");
    }

    @Override
    public List<Usuario> listarTodosUsuarios() {

        return listadoDeUsuarios;
    }

    @Override
    public Usuario buscarUnUsuario(String dni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarUnUsuario'");
    }

    @Override
    public Usuario buscarPorNombreUsuario(String dni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorNombreUsuario'");
    }

    @Override
    public Usuario crearNuevoUsuario() {
        //Usuario nuevoUsuario = new Usuario();
        return nuevoUsuario;
    

    }

    @Override
    public List<Usuario> listarTodosUsuariosActivos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodosUsuariosActivos'");
    }
    
}
