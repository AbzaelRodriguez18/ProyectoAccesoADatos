package org.example.proyectoaccesoadatos.Modelos.Actualizar;

import org.example.proyectoaccesoadatos.Modelos.Crear.VehiculoCreateDTO;

import java.util.List;

public class PropietarioUpdateDTO {
    private String nombre;
    private String telefono;
    private List<VehiculoCreateDTO> vehiculos;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<VehiculoCreateDTO> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<VehiculoCreateDTO> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
