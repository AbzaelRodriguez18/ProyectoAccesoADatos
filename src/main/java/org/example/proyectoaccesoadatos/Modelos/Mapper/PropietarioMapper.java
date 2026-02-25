package org.example.proyectoaccesoadatos.Modelos.Mapper;

import org.example.proyectoaccesoadatos.Modelos.DTOS.PolizaDeSeguroDTO;
import org.example.proyectoaccesoadatos.Modelos.DTOS.PropietarioDTO;
import org.example.proyectoaccesoadatos.Modelos.DTOS.VehiculoDTO;
import org.example.proyectoaccesoadatos.Modelos.Propietario;
import org.example.proyectoaccesoadatos.Modelos.Vehiculo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PropietarioMapper {
    public PropietarioDTO toDto(Propietario propietario) {
        PropietarioDTO dto = new PropietarioDTO();
        dto.setId(propietario.getId());
        dto.setDni(propietario.getDni().substring(0,7) + "**");
        dto.setNombre(propietario.getNombre());
        dto.setTelefono(propietario.getTelefono());
        List<VehiculoDTO> vehiculosDto = new ArrayList<>();
        for (Vehiculo vehiculo : propietario.getVehiculos()) {
            VehiculoDTO vehiculoDto = new VehiculoDTO();
            vehiculoDto.setId(vehiculo.getId());
            vehiculoDto.setMatricula(vehiculo.getMatricula().substring(0,6) + "*");
            vehiculoDto.setMarca(vehiculo.getMarca());
            vehiculoDto.setModelo(vehiculo.getModelo());
            PolizaDeSeguroDTO polizadto = new PolizaDeSeguroDTO();
            polizadto.setId(vehiculo.getPolizaDeSeguro().getId());
            polizadto.setNumeroDePoliza(vehiculo.getPolizaDeSeguro().getNumeroDePoliza());
            polizadto.setCompaniaAseguradora(vehiculo.getPolizaDeSeguro().getCompaniaAseguradora());
            polizadto.setTipo_cobertura(vehiculo.getPolizaDeSeguro().getTipodecobertura());
            vehiculoDto.setPolizaDeSeguro(polizadto);
            vehiculosDto.add(vehiculoDto);
        }
        dto.setVehiculos(vehiculosDto);
        return dto;
    }
}

