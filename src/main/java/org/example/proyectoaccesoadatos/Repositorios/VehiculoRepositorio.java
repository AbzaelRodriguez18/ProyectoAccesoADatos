package org.example.proyectoaccesoadatos.Repositorios;

import org.example.proyectoaccesoadatos.Modelos.Propietario;
import org.example.proyectoaccesoadatos.Modelos.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepositorio extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT DISTINCT v FROM Vehiculo v " +
            "LEFT JOIN FETCH v.propietario")
    List<Vehiculo> findAllCompleto();
}
