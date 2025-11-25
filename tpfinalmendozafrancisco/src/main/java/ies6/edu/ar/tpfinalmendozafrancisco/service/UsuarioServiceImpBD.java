package ies6.edu.ar.tpfinalmendozafrancisco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ies6.edu.ar.tpfinalmendozafrancisco.model.Usuario;
import ies6.edu.ar.tpfinalmendozafrancisco.repository.UsuarioRepository;

@Primary
@Service
@Qualifier("servicioUsuarioMySQL")
public class UsuarioServiceImpBD implements UsuarioService {

    @Autowired
    Usuario nuevoUsuario;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void borrarUsuario(Integer dni) {
        usuarioRepository.deleteById(dni);

    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarUsuario'");
    }

    @Override
    public List<Usuario> listarTodosUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUnUsuario(Integer dni) throws Exception {
        return usuarioRepository.findById(dni).orElseThrow(() -> new RuntimeException("Usuario no encontrado con DNI: " + dni));
    }

    @Override
    public Usuario buscarPorNombreUsuario(Integer dni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorNombreUsuario'");
    }

    @Override
    public Usuario crearNuevoUsuario() {
        return nuevoUsuario;
    }

    @Override
    public List<Usuario> listarTodosUsuariosActivos() {
        return usuarioRepository.findByEstado(true);
    }

    
}