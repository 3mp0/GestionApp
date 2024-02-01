package com._3mp0.gestionapp.repository;

import com._3mp0.gestionapp.model.Tareas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareasRepository extends JpaRepository<Tareas, Long> {
}
