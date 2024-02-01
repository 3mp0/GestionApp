package com._3mp0.gestionapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.ArrayList;

@Entity
@Table(name = "Departamentos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Incremental
    private long departamentoId;


    @Column(name= "nombre_departamento")//Especifica nombre de una columna
    @Size(min = 3, max = 15) // Validacion para ingreso de nombre
    private String nombreDepartamento;

    @Column(name="jefe_departamento")
    @Size(min = 10, max = 50) //Validación de tamaño del string
    private String jefeDepartamento;

    @OneToMany(mappedBy = "departamentoEmpleados") //se indica columna que mapea esta columna
    private ArrayList<Empleados> empleadosDepartamento;

}
