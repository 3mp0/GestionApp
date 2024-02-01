package com._3mp0.gestionapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name= "cargo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cargoId;

    @Column(name = "nombre_cargo")
    @NotBlank(message = "El nombre del cargo no puede estar vacio")
    private String nombreCargo;

    @Column(name = "empleados_cargo_num")
    @Size(min = 1, max = 15)
    private Integer empleadosCargoNum;

    @Column(name = "descripcion_cargo")
    @Max(255)
    private String descripcionCargo;

    @Column(name = "promedio_ ganancias_cargo")
    private Double promedioGananciasCargo;

    @OneToOne
    @JoinColumn(name = "empleado_id")
    private Empleados cargoEmpleados;

}