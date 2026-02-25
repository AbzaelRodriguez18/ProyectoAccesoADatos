package org.example.proyectoaccesoadatos.Controladores;

import org.example.proyectoaccesoadatos.Modelos.DTOS.PropietarioDTO;
import org.example.proyectoaccesoadatos.Modelos.DTOS.VehiculoDTO;
import org.example.proyectoaccesoadatos.Modelos.Propietario;
import org.example.proyectoaccesoadatos.Modelos.Vehiculo;
import org.example.proyectoaccesoadatos.Repositorios.VehiculoRepositorio;
import org.example.proyectoaccesoadatos.Servicios.PropietarioServicio;
import org.example.proyectoaccesoadatos.Servicios.VehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoControlador {


    @Autowired
    private VehiculoServicio VehiculoServicio;

    @GetMapping
    public List<VehiculoDTO> vehiculos() {
        return VehiculoServicio.obtenerTodos();
    }
}