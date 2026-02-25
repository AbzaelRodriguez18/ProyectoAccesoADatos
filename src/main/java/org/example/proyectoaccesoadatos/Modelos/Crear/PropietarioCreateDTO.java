package org.example.proyectoaccesoadatos.Modelos.Crear;

import org.example.proyectoaccesoadatos.Modelos.DTOS.VehiculoDTO;

import java.util.List;

public class PropietarioCreateDTO {
    private String dni;
    private String nombre;
    private String telefono;

    private List<VehiculoCreateDTO> vehiculos;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<VehiculoCreateDTO> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<VehiculoCreateDTO> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
