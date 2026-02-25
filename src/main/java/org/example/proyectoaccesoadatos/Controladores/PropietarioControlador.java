package org.example.proyectoaccesoadatos.Controladores;


import org.example.proyectoaccesoadatos.Modelos.Propietario;
import org.example.proyectoaccesoadatos.Servicios.PropietarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/propietarios")
public class PropietarioControlador {
    @Autowired
    private PropietarioServicio propietarioServicio;

    @GetMapping
    public List<Propietario> propietarios() {
        return propietarioServicio.obtenerTodos();
    }
}
