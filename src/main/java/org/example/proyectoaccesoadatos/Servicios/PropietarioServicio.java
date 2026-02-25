package org.example.proyectoaccesoadatos.Servicios;

import org.example.proyectoaccesoadatos.Modelos.Actualizar.PropietarioUpdateDTO;
import org.example.proyectoaccesoadatos.Modelos.Crear.PropietarioCreateDTO;
import org.example.proyectoaccesoadatos.Modelos.Crear.VehiculoCreateDTO;
import org.example.proyectoaccesoadatos.Modelos.DTOS.PropietarioDTO;
import org.example.proyectoaccesoadatos.Modelos.DTOS.VehiculoDTO;
import org.example.proyectoaccesoadatos.Modelos.Mapper.PropietarioMapper;
import org.example.proyectoaccesoadatos.Modelos.PolizaDeSeguro;
import org.example.proyectoaccesoadatos.Modelos.Propietario;
import org.example.proyectoaccesoadatos.Modelos.Vehiculo;
import org.example.proyectoaccesoadatos.Repositorios.PolizaDeSeguroRepositorio;
import org.example.proyectoaccesoadatos.Repositorios.PropietarioRepositorio;
import org.example.proyectoaccesoadatos.Repositorios.VehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropietarioServicio {
    @Autowired
    private PropietarioRepositorio propietarioRepositorio;

    @Autowired
    private VehiculoRepositorio VehiculoRepositorio;

    @Autowired
    private PolizaDeSeguroRepositorio PolizaDeSeguroRepositorio;

    @Autowired
    private PropietarioMapper mapper;

    public List<PropietarioDTO> obtenerTodos() {
        List<Propietario> propietarios = propietarioRepositorio.findAllCompleto();

        List<PropietarioDTO> dtos = new ArrayList<>();

        for (int i = 0; i < propietarios.size(); i++) {
            dtos.add(mapper.toDto(propietarios.get(i)));
        }
        return dtos;
    }

    @Transactional
    public PropietarioDTO crearPropietario(PropietarioCreateDTO dto) {
        if (dto.getNombre() == null ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre es obligatorio");
        }
        if (dto.getDni() == null ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El DNi es obligatorio");
        }
        if (dto.getTelefono() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El numero de telefono es obligatorio");
        }
        if (dto.getVehiculos() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Los vehiculos son obligatorios ");
        }

        Propietario p = new Propietario();
        p.setNombre(dto.getNombre());
        p.setDni(dto.getDni());
        p.setTelefono(dto.getTelefono());

        List<Vehiculo> vehiculos = new ArrayList<>();

        for (VehiculoCreateDTO vehiculoDto : dto.getVehiculos()) {
            Vehiculo v = new Vehiculo();
            v.setMarca(vehiculoDto.getMarca());
            v.setModelo(vehiculoDto.getModelo());
            v.setMatricula(vehiculoDto.getMatricula());

            v.setPropietario(p);

            PolizaDeSeguro polizaDeSeguro = new PolizaDeSeguro();
            polizaDeSeguro.setCompaniaAseguradora(vehiculoDto.getPolizaDeSeguro().getCompaniaAseguradora());
            polizaDeSeguro.setNumeroDePoliza(vehiculoDto.getPolizaDeSeguro().getNumeroDePoliza());
            polizaDeSeguro.setTipodecobertura(vehiculoDto.getPolizaDeSeguro().getTipo_cobertura());

            polizaDeSeguro.setVehiculo(v);
            v.setPolizaDeSeguro(polizaDeSeguro);

            vehiculos.add(v);
        }

        p.setVehiculos(vehiculos);

        p = propietarioRepositorio.save(p);

        return mapper.toDto(p);
    }
    @Transactional
    public PropietarioDTO actualizarPropietario(long id, PropietarioUpdateDTO dtoNuevaInfo) {
        Propietario propietario = propietarioRepositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe ese propietario"));

        propietario.setNombre(dtoNuevaInfo.getNombre());
        propietario.setTelefono(dtoNuevaInfo.getTelefono());

        List<Vehiculo> vehiculosActuales = propietario.getVehiculos();

        if (dtoNuevaInfo.getVehiculos() != null) {
            for (VehiculoCreateDTO vehiculoNuevo : dtoNuevaInfo.getVehiculos()) {

                boolean matriculaExiste = vehiculosActuales.stream()
                        .anyMatch(v -> v.getMatricula().equalsIgnoreCase(vehiculoNuevo.getMatricula()));

                if (matriculaExiste) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                            "La matrícula " + vehiculoNuevo.getMatricula() + " ya pertenece a este propietario.");
                } else {
                    Vehiculo v = new Vehiculo();
                    v.setMarca(vehiculoNuevo.getMarca());
                    v.setModelo(vehiculoNuevo.getModelo());
                    v.setMatricula(vehiculoNuevo.getMatricula());

                    v.setPropietario(propietario);

                    PolizaDeSeguro polizaDeSeguro = new PolizaDeSeguro();
                    polizaDeSeguro.setNumeroDePoliza(vehiculoNuevo.getPolizaDeSeguro().getNumeroDePoliza());
                    polizaDeSeguro.setCompaniaAseguradora(vehiculoNuevo.getPolizaDeSeguro().getCompaniaAseguradora());
                    polizaDeSeguro.setTipodecobertura(vehiculoNuevo.getPolizaDeSeguro().getTipo_cobertura());
                    polizaDeSeguro.setVehiculo(v);
                    v.setPolizaDeSeguro(polizaDeSeguro);
                    vehiculosActuales.add(v);
                }
            }
        }


        propietario = propietarioRepositorio.save(propietario);

        return mapper.toDto(propietario);
    }
    @Transactional
    public void EliminarPropietario(Long id) {
        Propietario e = propietarioRepositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Propietario no encontrado con id :" + id));

        propietarioRepositorio.delete(e);
    }
}
