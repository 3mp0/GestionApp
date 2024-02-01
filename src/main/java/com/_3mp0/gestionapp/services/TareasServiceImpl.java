package com._3mp0.gestionapp.services;

import com._3mp0.gestionapp.model.Tareas;
import com._3mp0.gestionapp.repository.EmpleadosRepository;
import com._3mp0.gestionapp.repository.TareasRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class TareasServiceImpl implements TareasService{


    private EmpleadosRepository empleadosRepository;

    private TareasRepository tareasRepository;

    @Override
    public List<Tareas> obtenerListaTareas() {
        return tareasRepository.findAll();
    }
}


