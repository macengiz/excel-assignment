package com.excel.tests;

import java.time.LocalDateTime;

import org.junit.Test;

import com.excel.utilities.ExcelUtils;

public class DataDrivenTest {

	String excelPath = "./src/test/resources/com/excel/testdata/calculator.xlsx";

	@Test
	public void test1() {

		ExcelUtils.openExcelFile(excelPath, "Sayfa1");
		int rowCount = ExcelUtils.getUsedRowsCount();

		for (int i = 1; i < rowCount; i++) {

			String executionFlag = ExcelUtils.getCellData(i, 0);
			String operationVar = ExcelUtils.getCellData(i, 1);

			String num1 = ExcelUtils.getCellData(i, 2);
			double num1Double = Double.parseDouble(num1);
			String num2 = ExcelUtils.getCellData(i, 3);
			double num2Double = Double.parseDouble(num2);

			String expectedResult = ExcelUtils.getCellData(i, 4);

			if (executionFlag.contains("Y")) {
				double calculationResult = Calculator.Operate(operationVar, num1Double, num2Double);
				String resultString = String.valueOf(calculationResult);
				ExcelUtils.setCellData(resultString, i, 5);

			} else {
				ExcelUtils.setCellData("skipped", i, 5);
			}

			// if(resultString.equals(epectedResult)){}

			if (ExcelUtils.getCellData(i, 4).equals(ExcelUtils.getCellData(i, 5))) {
				ExcelUtils.setCellData("passed", i, 6);
			} else if (ExcelUtils.getCellData(i, 0).equals("N")) {
				ExcelUtils.setCellData("skipped", i, 6);
			} else {
				ExcelUtils.setCellData("failed", i, 6);
			}

			String timeStamp = LocalDateTime.now().toString();
			ExcelUtils.setCellData(timeStamp, i, 7);

		}

	}
}
