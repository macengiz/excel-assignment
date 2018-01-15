package com.excel.tests;

public class Calculator {

	public static double Operate(String Operation, double num1, double num2) {

		double result = 0.0;

		switch (Operation) {

		case "addition":
			result = num1 + num2;
			break;

		case "subtraction":
			result = num1 - num2;
			break;

		case "multiplication":
			result = num1 * num2;
			break;

		case "division":
			if (num2 != 0)
				result = num1 / num2;
			else
				System.out.println("dividing number is 0 !");
			break;
		}

		return result;
	}
}
