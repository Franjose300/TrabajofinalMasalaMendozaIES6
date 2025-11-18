package ies6.edu.ar.tpfinalmendozafrancisco.model;

import java.time.LocalDate;



import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Entity
public class Usuario {

    @Id
    private String dni;
    @Column
    private String Nombre;
    @Column
    private String apellido;
    @Column
    private String correoElectronico;
    @Column
    private String telefono;
    @Column
    private LocalDate fechaDeNacimiento;
    @Column
    private Boolean estado = true;

    public Usuario() {
    }

    public Usuario(String dni, String nombre, String apellido, String correoElectronico, String telefono, LocalDate fechaDeNacimiento,
            Boolean estado) {
        this.dni = dni;
        this.Nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.estado = estado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    


}
