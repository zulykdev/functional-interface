package com.brixton.functional.consumer;

import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		Predicate<Integer> lessThan = a -> (a <= 50);
		Predicate<Integer> greaterThan = a -> (a >= 100);
		Predicate<Integer> equalTo = a -> (a == 0);

		Predicate<Integer> menorQue50 = input -> input < 50;
		Predicate<Integer> mayorQue30 = z -> z > 30;
		Predicate<Integer> igualA40 = input -> input == 40;


		//(a < 50 && a > 30 && a == 40)
		System.out.println("todo true: " + menorQue50.and(mayorQue30).and(igualA40).test(41));
		//(a < 50 || a > 30 || a == 40)
		System.out.println("comprativo or : " + menorQue50.or(mayorQue30).or(igualA40).test(48));

		
		/*boolean result = lessThan.test(15);
		System.out.println("Result :"+result);*/
		
		System.out.println("Greater Than :"+greaterThan.test(150));
		System.out.println("Less Than :"+lessThan.test(150));
		System.out.println("Equal :"+equalTo.test(0));
		
		boolean result1 = lessThan.and(greaterThan).and(equalTo).test(150);
		System.out.println("Result 1:"+result1);
		
		boolean result2 = lessThan.or(greaterThan).test(150);
		System.out.println("Result 2:"+result2);
		
		boolean result3 = lessThan.or(greaterThan).negate().test(150);
		System.out.println("Result 3:"+result3);
		
		
		
	}

}
