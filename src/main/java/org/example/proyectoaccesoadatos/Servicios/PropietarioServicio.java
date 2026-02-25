package org.example.proyectoaccesoadatos.Servicios;

import org.example.proyectoaccesoadatos.Modelos.Propietario;
import org.example.proyectoaccesoadatos.Repositorios.PropietarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioServicio {
    @Autowired
    private PropietarioRepositorio propietarioRepositorio;

    public List<Propietario> obtenerTodos() {
        return propietarioRepositorio.findAllCompleto();
    }
}
