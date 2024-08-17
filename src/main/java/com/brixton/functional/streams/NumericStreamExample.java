package com.brixton.functional.streams;

import com.brixton.functional.lambdas.Persona;
import com.brixton.functional.repo.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class NumericStreamExample {

	static BinaryOperator<Integer> bo = (x, y) -> x + y;

	static int calculateSum(List<Integer> l1) {
		return l1.stream().reduce(0, bo);
	}
	
	static int calculateSumWithStream(IntStream intStream) {
		return intStream.sum();
	}

	public static void main(String [] args) {
		List<Integer> l1 = Arrays.asList(1,2,3,4,5,6);

		List<String> nombres = new ArrayList<>();
		nombres.add("ISAI");
		nombres.add("YOSELIN");
		nombres.add("HANS");

		List<String> nombres2 = Arrays.asList("HANS", "YOSELIN", "ISAI");

		System.out.println("Total is :"+calculateSum(l1));
		IntStream intStream = IntStream.rangeClosed(1, 6);
		System.out.println("Total Using Stream :"+calculateSumWithStream(intStream));

		casa(100, 100, 500, new Persona(), new Persona(), new Persona());

		//de la lista de datos recibida, seleccionar los nombres que contengan "A" y "S" y indicar cuantos son.
		System.out.println("contador de acuerdo a la regla");
		System.out.println(contarDeAcuerdoARegla(nombres2));

		Predicate<String> contieneA = x -> x.contains("A");
		Predicate<String> contieneS = y -> y.contains("S");
		Predicate<String> contieneI = y -> y.contains("I");

		Function<String, Integer> cuentaLetras = x -> x.length();

		long candiqueCumpleRegla = nombres2.stream().filter(contieneA.and(contieneS)).count();
		long candiqueCumpleRegla2 = nombres2.stream().filter(contieneA.and(contieneS)).count();

		System.out.println("contador de acuerdo a la regla con STREAM: " + candiqueCumpleRegla);

		System.out.println("cantidad Letras: " + contarDeLetras(nombres2));
		System.out.println("cantidad Letras count: " + nombres2.stream().count() );
		nombres2.stream().filter(contieneI).map(cuentaLetras).forEach(x-> {
            System.out.println(x);
        });
		System.out.println("cantidad Letras reduce: " );
		System.out.println("cantidad letras con reduce: " + nombres2.stream().filter(contieneI).map(cuentaLetras).reduce(0, Integer::sum));
		System.out.println("cantidad letras con reduce: " + nombres2.stream().filter(contieneI).mapToInt(String::length).reduce(0, Integer::sum));

	}

	public static int contarDeAcuerdoARegla(List<String> inputList){
		int cantidadDeStringQueCumpleLaRegla = 0;
		for(String x : inputList) {
			if(x.contains("A") && x.contains("S")){
				cantidadDeStringQueCumpleLaRegla++;
			}
		}
		return cantidadDeStringQueCumpleLaRegla;
	}

	public static int contarDeLetras(List<String> inputList){
		int sumaLetras = 0; //Acumulador
		for(String x : inputList) {
			if(x.contains("I")) {
				int cantidadLetrasxFor = x.length();
				sumaLetras += cantidadLetrasxFor;
			}
		}
		return sumaLetras;
	}

	public static void casa( int alto, int largo, int ancho, Persona ... personas){

	}

}
