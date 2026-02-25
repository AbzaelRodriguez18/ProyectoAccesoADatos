package org.example.proyectoaccesoadatos.Repositorios;

import org.example.proyectoaccesoadatos.Modelos.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropietarioRepositorio extends JpaRepository<Propietario, Long> {
    @Query("SELECT DISTINCT p FROM Propietario p " +
            "LEFT JOIN FETCH p.vehiculos")
    List<Propietario> findAllCompleto();
}
