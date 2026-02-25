package org.example.proyectoaccesoadatos.Servicios;

import org.example.proyectoaccesoadatos.Modelos.DTOS.PolizaDeSeguroDTO;
import org.example.proyectoaccesoadatos.Modelos.DTOS.VehiculoDTO;
import org.example.proyectoaccesoadatos.Modelos.Mapper.PolizaDeSeguroMapper;
import org.example.proyectoaccesoadatos.Modelos.Mapper.VehiculoMapper;
import org.example.proyectoaccesoadatos.Modelos.PolizaDeSeguro;
import org.example.proyectoaccesoadatos.Modelos.Vehiculo;
import org.example.proyectoaccesoadatos.Repositorios.PolizaDeSeguroRepositorio;
import org.example.proyectoaccesoadatos.Repositorios.VehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PolizaDeSeguroServicio {
    @Autowired
    private PolizaDeSeguroRepositorio polizadesegurorepositorio;

    @Autowired
    private PolizaDeSeguroMapper mapper;

    public List<PolizaDeSeguroDTO> obtenerTodos() {
        List<PolizaDeSeguro> polizas = polizadesegurorepositorio.findAllCompleto();
        List<PolizaDeSeguroDTO> polizaDeSeguroDTOS = new ArrayList<>();

        for (int i = 0; i < polizas.size(); i++) {
            polizaDeSeguroDTOS.add(mapper.toDto(polizas.get(i)));
        }
        return polizaDeSeguroDTOS;
    }
}