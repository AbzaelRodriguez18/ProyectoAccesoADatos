package org.example.proyectoaccesoadatos.Controladores;


import org.example.proyectoaccesoadatos.Modelos.Actualizar.PropietarioUpdateDTO;
import org.example.proyectoaccesoadatos.Modelos.Crear.PropietarioCreateDTO;
import org.example.proyectoaccesoadatos.Modelos.DTOS.PropietarioDTO;
import org.example.proyectoaccesoadatos.Modelos.Propietario;
import org.example.proyectoaccesoadatos.Servicios.PropietarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propietarios")
public class PropietarioControlador {
    @Autowired
    private PropietarioServicio propietarioServicio;

    @GetMapping
    public List<PropietarioDTO> propietarios() {
        return propietarioServicio.obtenerTodos();
    }
    @PostMapping
    public ResponseEntity<PropietarioDTO> crearPropietario(@RequestBody PropietarioCreateDTO Propietariocreate) {
        try {
            PropietarioDTO nuevoPropietario = propietarioServicio.crearPropietario(Propietariocreate);
            return new ResponseEntity<>(nuevoPropietario, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<PropietarioDTO> ActualizarEstudiante(@PathVariable("id") long id, @RequestBody PropietarioUpdateDTO estudianteUpdateDTO) {
        try {
            PropietarioDTO EstudianteActualizado = propietarioServicio.actualizarPropietario(id,estudianteUpdateDTO);
            return new ResponseEntity<>(EstudianteActualizado, HttpStatus.OK);


        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        propietarioServicio.EliminarPropietario(id);
        return ResponseEntity.noContent().build();
    }

}
