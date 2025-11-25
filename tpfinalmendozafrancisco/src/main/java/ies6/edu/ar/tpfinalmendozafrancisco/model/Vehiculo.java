package ies6.edu.ar.tpfinalmendozafrancisco.model;


import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Component
@Entity
public class Vehiculo {
                                          
    @Id
    private String patente;
    @Column
     @NotBlank(message = "El nombre es obligatorio")
    private String marca;
    @Column
     @NotBlank(message = "El nombre es obligatorio")
    private String modelo;
    @Column
    private String año;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoVehiculo tipoVehiculo;

    @Column
    @NotBlank(message = "El nombre es obligatorio")
    private String color;
    @Column
    private Boolean estado=true;

    

    @OneToOne
    @JoinColumn(name = "dni_conductor")
    private Conductor conductor;


    public Vehiculo() {
    }


    public Vehiculo(String patente, @NotBlank(message = "El nombre es obligatorio") String marca,
            @NotBlank(message = "El nombre es obligatorio") String modelo, String año, TipoVehiculo tipoVehiculo,
            @NotBlank(message = "El nombre es obligatorio") String color, Boolean estado, Conductor conductor) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.tipoVehiculo = tipoVehiculo;
        this.color = color;
        this.estado = estado;
        this.conductor = conductor;
    }


    public String getPatente() {
        return patente;
    }


    public void setPatente(String patente) {
        this.patente = patente;
    }


    public String getMarca() {
        return marca;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String getAño() {
        return año;
    }


    public void setAño(String año) {
        this.año = año;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public Boolean getEstado() {
        return estado;
    }


    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


    public Conductor getConductor() {
        return conductor;
    }


    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }


    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    
    


    
    

}