package com.brixton.functional.consumer;

import com.brixton.functional.lambdas.Persona;
import com.brixton.functional.repo.Person;

import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args) {
		Consumer<String> con1 = (s) -> {System.out.println(s.toUpperCase());};
		Consumer<String> con2 = (s) -> {System.out.println(s.toLowerCase());};
		Consumer<String> con3 = (s) -> {System.out.println(s.length());};

		//con1.accept("hans");

		//con2.accept("YOSELIN");

		con1.andThen(con2).accept("hans");
		con1.andThen(con3).andThen(con2).accept("YoSeLin");

		Persona x = new Persona();
		x.procesaLambdas("EduarDO");

		//con1.accept("java8");
		//Consumer<String> con2 = (s) -> System.out.println(s.toLowerCase());
		//con2.accept("java8");
		//con1.andThen(con2).accept("java8");
	}

}
