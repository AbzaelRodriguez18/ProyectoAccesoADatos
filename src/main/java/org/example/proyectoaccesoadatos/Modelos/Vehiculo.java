package org.example.proyectoaccesoadatos.Modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricula;
    private String marca;
    private String modelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "propietario_id")
    @JsonIgnore
    private Propietario propietario;

    @OneToOne(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private PolizaDeSeguro polizaDeSeguro;

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

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
    public PolizaDeSeguro getPolizaDeSeguro() {
        return polizaDeSeguro;
    }

    public void setPolizaDeSeguro(PolizaDeSeguro polizaDeSeguro) {
        this.polizaDeSeguro = polizaDeSeguro;
    }
}
