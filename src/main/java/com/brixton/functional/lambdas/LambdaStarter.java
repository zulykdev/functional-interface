package com.brixton.functional.lambdas;

import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaStarter {

    public static void main(String[] args) {

        //USO DE METODO
        int totales = sumar(1, 6);
        totales = sumar(9, 5);
        ///////////////
        //Ahora con Lambdas :)
        //el equivalente al metodo sumar // es el simil a definir un metodo.
        //DEFINICION
        BiFunction<Integer, Integer, Double> operacionSuma = (inputA, inputB) -> {
            System.out.println("voy a sumar: " + inputA + " + " + inputB);
            Double suma = (double)(inputA + inputB);
            System.out.println("suma es = " + suma);
            return  suma;
        };

        Function<Numeros, Double> operacionSumaHasta6Numeros = (input) -> {
            System.out.println("voy a sumar: " + input.getNumero1());
            System.out.println("voy a sumar: " + input.getNumero2());
            System.out.println("voy a sumar: " + input.getNumero3());
            System.out.println("voy a sumar: " + input.getNumero4());
            System.out.println("voy a sumar: " + input.getNumero5());
            System.out.println("voy a sumar: " + input.getNumero6());
            Double suma = (double)(input.getNumero1() + input.getNumero2() + input.getNumero3() + input.getNumero4() + input.getNumero5() + input.getNumero6());
            System.out.println("suma es = " + suma);
            for(int x = 0; x < 50 ; x++) {
                System.out.println("x: " + x);
            }

            return  suma;
        };
        System.out.println("IMPRIMIENDO USO DE LAMBDAS");
        //USO
        Double x = operacionSuma.apply(1, 6);
        Double y = operacionSumaHasta6Numeros.apply(new Numeros(1,2,3,4,5,6));
    }

    //DEFINICION DE METODO
    public static int sumar(int inputA, int inputB) {
        System.out.println("voy a sumar: " + inputA + " + " + inputB);
        int suma = inputA + inputB;
        System.out.println("suma es = " + suma);
        return suma;
    }

    public static int sumarLimpio(int inputA, int inputB) {
        return inputA + inputB;
    }

    public static void lambaDesdeMetodo() {

    }

}
