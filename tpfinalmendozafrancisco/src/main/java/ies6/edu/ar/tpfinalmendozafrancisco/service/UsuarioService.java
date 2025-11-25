package ies6.edu.ar.tpfinalmendozafrancisco.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ies6.edu.ar.tpfinalmendozafrancisco.model.Usuario;

@Service
public interface UsuarioService {
    public void borrarUsuario (Integer dni);
    public void agregarUsuario(Usuario usuario);
    public void modificarUsuario(Usuario usuario);
    public List<Usuario> listarTodosUsuarios();
    public Usuario buscarUnUsuario(Integer dni) throws Exception;
    public Usuario buscarPorNombreUsuario(Integer dni) throws Exception;
    public Usuario crearNuevoUsuario();
    public List<Usuario> listarTodosUsuariosActivos();
    
}
