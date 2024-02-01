package com._3mp0.gestionapp.services;

import com._3mp0.gestionapp.model.Empleados;
import com._3mp0.gestionapp.model.Tareas;
import com._3mp0.gestionapp.repository.EmpleadosRepository;
import com._3mp0.gestionapp.repository.TareasRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //permite a spring tomar este componente cuando necesitemos inyectarlo
@Transactional //Indica que los metodos contenidos en la clase se pueden transaccionar
@AllArgsConstructor
public class EmpleadosServiceImpl implements EmpleadosService {


    private EmpleadosRepository empleadosRepository;

    private TareasRepository tareasRepository;

    @Override
    public Empleados guardarEmpleado(Empleados empleadoParaGuardar) {
        Boolean empleadoExiste = empleadosRepository.existsById(empleadoParaGuardar.getEmpleadoId());
        if (!(empleadoExiste) && empleadoParaGuardar.getAniosAntiguedad() > 1){
            return empleadosRepository.save(empleadoParaGuardar);
        }else{
            return null;
        }
    }

    @Override
    public void borrarEmpleadoPorId(Long id) {
        //Validamos que el empleado existe
        Boolean empleadoExiste = empleadosRepository.existsById(id);

        if (empleadoExiste) {
            empleadosRepository.deleteById(id);
        }
    }

    @Override
    public List<Empleados> listarEmpleados(){
        return empleadosRepository.findAll();
    }

    //Metodo que asigna tareas a empleados que recibe el Id de tarea y de empleado
    public void asignarTareaEmpleado(Long tareaId, Long empleadoId) {
        //Buscamos en la lista de tareas por el id de la tarea indicada
        Tareas tareaParaAsignar = tareasRepository.findById(tareaId).get();
        //Asignar la tarea al empleado
        Empleados empleadoSeleccionado = empleadosRepository.findById(empleadoId).get();

        //Creamos un ArrayList de tareas
        ArrayList<Tareas> tareasEmpleado = new ArrayList<>();
        //Agregamos la tarea encontrada por id
        tareasEmpleado.add(tareaParaAsignar);
        //Le seteamos el ArrayList de tareas al empleado
       /* empleadoSeleccionado.setEmpleadoTareas(tareasEmpleado);

        //Refactorizamos para seleccionar de una vez el ArrayList de tareas del usuario por sugerencia de Pao :3
        empleadoSeleccionado.getEmpleadoTareas().add(tareaParaAsignar); */
    }
}
