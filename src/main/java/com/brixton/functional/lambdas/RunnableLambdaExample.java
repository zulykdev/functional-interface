package com.brixton.functional.lambdas;

public class RunnableLambdaExample {

	public static void main(String[] args) {
		// Before
		Runnable t1 = new Runnable() {			
			@Override
			public void run() {
				System.out.println("Thread 1");				
			}
		};
		
		new Thread(t1).start();

		// After
		Runnable t2 = () -> {System.out.println("Thread 2");};
		Runnable tx = () -> System.out.println("Thread 2");
		new Thread(t2).start();
		
		Runnable t3 = () -> {System.out.println("Thread 3");
			System.out.println("Thread 3.1");  
		};
		
		new Thread(t3).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Thread 4");
				
			}
		}).start();

		new Thread(t2);
		new Thread(() -> {System.out.println("Thread 2");});
		new Thread(() -> System.out.println("Thread 2"));

		
		new Thread(() -> {
			System.out.println("Thread 5");
			System.out.println("Thread 5.1");
		}).start();








	}

	public int sumar(int inputA, int inputB) {
		System.out.println("voy a sumar: " + inputA + " + " + inputB);
		int suma = inputA + inputB;
		return suma;
	}

	
	

}
