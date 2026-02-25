package org.example.proyectoaccesoadatos.Servicios;

import org.example.proyectoaccesoadatos.Modelos.DTOS.PropietarioDTO;
import org.example.proyectoaccesoadatos.Modelos.DTOS.VehiculoDTO;
import org.example.proyectoaccesoadatos.Modelos.Mapper.PropietarioMapper;
import org.example.proyectoaccesoadatos.Modelos.Mapper.VehiculoMapper;
import org.example.proyectoaccesoadatos.Modelos.Propietario;
import org.example.proyectoaccesoadatos.Modelos.Vehiculo;
import org.example.proyectoaccesoadatos.Repositorios.PolizaDeSeguroRepositorio;
import org.example.proyectoaccesoadatos.Repositorios.PropietarioRepositorio;
import org.example.proyectoaccesoadatos.Repositorios.VehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoServicio {

    @Autowired
    private VehiculoRepositorio VehiculoRepositorio;

    @Autowired
    private VehiculoMapper mapper;

    public List<VehiculoDTO> obtenerTodos() {
        List<Vehiculo> vehiculos = VehiculoRepositorio.findAllCompleto();
        List<VehiculoDTO> dtos = new ArrayList<>();

        for (int i = 0; i < vehiculos.size(); i++) {
            dtos.add(mapper.toDto(vehiculos.get(i)));
        }
        return dtos;
    }
}
