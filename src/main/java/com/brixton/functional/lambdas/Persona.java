package com.brixton.functional.lambdas;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Consumer;
import java.util.function.Function;

@Setter
@Getter
public class Persona {

    int edad;
    String nombre;
    String apellidos;
    LocalDate fechaNacimiento;

    Consumer<String> con1 = (s) -> {System.out.println(s.toUpperCase());};
    Consumer<String> con2 = (s) -> {System.out.println(s.toLowerCase());};
    Consumer<String> con3 = (s) -> {System.out.println(s.length());};

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

    public void procesaLambdas(String input){
        con1.andThen(con3).andThen(con2).accept(input);
    }

}
