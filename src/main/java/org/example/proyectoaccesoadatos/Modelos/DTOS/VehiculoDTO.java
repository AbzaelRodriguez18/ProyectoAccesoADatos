package org.example.proyectoaccesoadatos.Modelos.DTOS;

import org.example.proyectoaccesoadatos.Modelos.PolizaDeSeguro;
import org.example.proyectoaccesoadatos.Modelos.Propietario;

public class VehiculoDTO {
    private Long id;
    private String matricula;
    private String marca;
    private String modelo;

    private PolizaDeSeguroDTO polizaDeSeguro;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public PolizaDeSeguroDTO getPolizaDeSeguro() {
        return polizaDeSeguro;
    }

    public void setPolizaDeSeguro(PolizaDeSeguroDTO polizaDeSeguro) {
        this.polizaDeSeguro = polizaDeSeguro;
    }
}
