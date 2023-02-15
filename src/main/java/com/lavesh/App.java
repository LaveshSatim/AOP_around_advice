package com.lavesh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lavesh.bean.Calculator;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Javaconfig.class);

		Calculator calculator = context.getBean(Calculator.class);

		System.out.println(calculator.add(10, 20));
	}
}
