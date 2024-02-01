package com._3mp0.gestionapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Table(name= "tareas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tareas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tareaId;

    @Column(name = "nombre_tarea")
    private String nombreTarea;

    @Column(name = "desripcion_tarea")
    private String descripcionTarea;

    @ManyToMany
    @JoinTable(
            name = "tareas_empleados",//Se empieza definiendo el nombre de la tarea
            joinColumns = @JoinColumn(name = "tarea_id"), //Se indica columna que lleva llave foranea
            inverseJoinColumns = @JoinColumn(name = "empleado_id")
    )
    private ArrayList<Empleados> tareasEmpleados;


}
