package com._3mp0.gestionapp.services;

import com._3mp0.gestionapp.model.Empleados;

import java.util.List;

public interface EmpleadosService {
    //En esta interfaz declaro los métodos solamente

    Empleados guardarEmpleado(Empleados empleadoParaGuardar);

    void borrarEmpleadoPorId(Long empleadoId);

    List<Empleados> listarEmpleados();
}
