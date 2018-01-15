package com.excel.tests;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testMyCalculator() {

		Calculator.Operate("addition", 3.5, 2.1);
		System.out.println(Calculator.Operate("addition", 4.0, 33.0));

		Calculator.Operate("subtraction", 3.5, 2.1);
		System.out.println(Calculator.Operate("subtraction", 12.0, 22.0));

	}
}
