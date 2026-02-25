package org.example.proyectoaccesoadatos.Modelos.Mapper;

import org.example.proyectoaccesoadatos.Modelos.DTOS.PolizaDeSeguroDTO;
import org.example.proyectoaccesoadatos.Modelos.PolizaDeSeguro;
import org.springframework.stereotype.Component;

@Component
public class PolizaDeSeguroMapper {

    public PolizaDeSeguroDTO toDto(PolizaDeSeguro poliza) {
        PolizaDeSeguroDTO dto = new PolizaDeSeguroDTO();
        dto.setId(poliza.getId());
        dto.setNumeroDePoliza(poliza.getNumeroDePoliza());
        dto.setCompaniaAseguradora(poliza.getCompaniaAseguradora());
        dto.setTipo_cobertura(poliza.getTipodecobertura());

        return dto;
    }
}