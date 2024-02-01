package com._3mp0.gestionapp.repository;

import com._3mp0.gestionapp.model.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleados, Long> {
//Hereda de JpaRepository, aporta metodos para realizar CRUD, y paginación
}
