package com.brixton.functional.lambdas;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

@Setter
@Getter
public class Persona {

    int edad;
    String nombre;
    String apellidos;
    LocalDate fechaNacimiento;

    Function<LocalDate, Integer> calculaEdad = (fnac) -> { LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fnac, fechaActual);
        try {
        getNombreCompleto();
        } catch (Exception ex) {
            return 0;
        }
        return periodo.getYears();
    };

    public String getNombreCompleto(){
        return getNombre() + " " + getApellidos();
    }

    public int calcularEdad() {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }

}
