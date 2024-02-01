package com._3mp0.gestionapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Entity
@Table(name = "empleados")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Incremental
    private long empleadoId;


    @Column(name= "nombre_empleado")//Especifica nombre de una columna
    @Size(min = 3, max = 15) // Validacion para ingreso de nombre
    private String nombreEmpleado;

    @Column(name="direccion")
    @Size(min = 10, max = 50) //Validación de tamaño del string
    private String direccionEmpleado;


    @Min(1)
    @Max(10)
    private Integer aniosAntiguedad;

    @Email(message = "No es un correo valido") //Valida que lo ingresado sea un correo
    private String correoEmpleado;

    @ManyToOne //Indico relacion n:1
    @JoinColumn(name = "departamento_id") //Indicamosnombre de columna que lleva llave foranea
    private Departamento departamentoEmpleados;

   // @ManyToMany(mappedBy = "tareasEmpleados")
    // private ArrayList<Tareas> empleadoTareas;

}
