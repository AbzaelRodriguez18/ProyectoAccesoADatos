package org.example.proyectoaccesoadatos.Modelos.Crear;

import org.example.proyectoaccesoadatos.Modelos.DTOS.PolizaDeSeguroDTO;

public class VehiculoCreateDTO {
    private String matricula;
    private String marca;
    private String modelo;

    private PolizaDeSeguroCreateDTO polizaDeSeguro;

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

    public PolizaDeSeguroCreateDTO getPolizaDeSeguro() {
        return polizaDeSeguro;
    }

    public void setPolizaDeSeguro(PolizaDeSeguroCreateDTO polizaDeSeguro) {
        this.polizaDeSeguro = polizaDeSeguro;
    }
}
