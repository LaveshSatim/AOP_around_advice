package com.lavesh.bean;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

	public int add(int i, int j) {
		System.out.println("inside cal bean");
		return i + j;
	}
}
