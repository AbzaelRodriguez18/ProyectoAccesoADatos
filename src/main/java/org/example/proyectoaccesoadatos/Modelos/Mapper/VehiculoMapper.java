package org.example.proyectoaccesoadatos.Modelos.Mapper;

import org.example.proyectoaccesoadatos.Modelos.DTOS.PolizaDeSeguroDTO;
import org.example.proyectoaccesoadatos.Modelos.DTOS.PropietarioDTO;
import org.example.proyectoaccesoadatos.Modelos.DTOS.VehiculoDTO;
import org.example.proyectoaccesoadatos.Modelos.Propietario;
import org.example.proyectoaccesoadatos.Modelos.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehiculoMapper {

    private PropietarioMapper mapper;

    public VehiculoDTO toDto(Vehiculo vehiculo) {
        VehiculoDTO vehiculoDto = new VehiculoDTO();
        vehiculoDto.setId(vehiculo.getId());

        if (vehiculo.getMatricula() != null ) {
            vehiculoDto.setMatricula(vehiculo.getMatricula().substring(0,6) + "*");
        }

        vehiculoDto.setMarca(vehiculo.getMarca());
        vehiculoDto.setModelo(vehiculo.getModelo());

        if (vehiculo.getPolizaDeSeguro() != null) {
            PolizaDeSeguroDTO polizadto = new PolizaDeSeguroDTO();
            polizadto.setId(vehiculo.getPolizaDeSeguro().getId());
            polizadto.setNumeroDePoliza(vehiculo.getPolizaDeSeguro().getNumeroDePoliza());
            polizadto.setCompaniaAseguradora(vehiculo.getPolizaDeSeguro().getCompaniaAseguradora());
            polizadto.setTipo_cobertura(vehiculo.getPolizaDeSeguro().getTipodecobertura());

            vehiculoDto.setPolizaDeSeguro(polizadto);
        }

        return vehiculoDto;
    }
}
