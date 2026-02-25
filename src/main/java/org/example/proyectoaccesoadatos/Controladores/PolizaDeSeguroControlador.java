package org.example.proyectoaccesoadatos.Controladores;

import org.example.proyectoaccesoadatos.Modelos.DTOS.PolizaDeSeguroDTO;
import org.example.proyectoaccesoadatos.Modelos.DTOS.VehiculoDTO;
import org.example.proyectoaccesoadatos.Repositorios.PolizaDeSeguroRepositorio;
import org.example.proyectoaccesoadatos.Servicios.PolizaDeSeguroServicio;
import org.example.proyectoaccesoadatos.Servicios.VehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/polizasdeseguro")
public class PolizaDeSeguroControlador {

    @Autowired
    private PolizaDeSeguroServicio polizaDeSeguroServicio;

    @GetMapping
    public List<PolizaDeSeguroDTO> polizaDeSeguro() {
        return polizaDeSeguroServicio.obtenerTodos();
    }
}
