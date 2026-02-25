package org.example.proyectoaccesoadatos.Repositorios;

import org.example.proyectoaccesoadatos.Modelos.PolizaDeSeguro;
import org.example.proyectoaccesoadatos.Modelos.Propietario;
import org.example.proyectoaccesoadatos.Modelos.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolizaDeSeguroRepositorio extends JpaRepository<PolizaDeSeguro, Long> {
    @Query("SELECT DISTINCT p FROM PolizaDeSeguro p " +
            "LEFT JOIN FETCH p.vehiculo")
    List<PolizaDeSeguro> findAllCompleto();
}