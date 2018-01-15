package com.excel.tests;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.excel.pages.CalculatorPage;
import com.excel.pages.HomePage;
import com.excel.utilities.ConfigurationReader;
import com.excel.utilities.Driver;
import com.excel.utilities.ExcelUtils;

public class GoogleTest {

	WebDriver driver = Driver.getInstance();
	String excelPath = "./src/test/resources/com/excel/testdata/calculator.xlsx";
	HomePage homepage = new HomePage();
	CalculatorPage calculatorpage = new CalculatorPage();
	String expectedResult;
	String resultString;

	@Before

	public void setUp() {

		driver.get(ConfigurationReader.getProperty("url"));
		homepage.searchField.sendKeys(ConfigurationReader.getProperty("value") + Keys.ENTER);
		Assert.assertTrue(driver.getTitle().contains("calculator"));
	}

	@Test

	public void googleCalculator() {

		calculatorpage.calculatorField.sendKeys("22");
		calculatorpage.addition.click();
		calculatorpage.calculatorField.sendKeys("11");
		calculatorpage.equals.click();
		System.out.println(calculatorpage.calculatorField.getText());

	}

	@Test

	public void dataDriverGoogleTest() {

		ExcelUtils.openExcelFile(excelPath, "Sayfa1");
		int rowCount = ExcelUtils.getUsedRowsCount();

		for (int i = 1; i < rowCount; i++) {

			String executionFlag = ExcelUtils.getCellData(i, 0);
			String operationVar = ExcelUtils.getCellData(i, 1);

			String num1 = ExcelUtils.getCellData(i, 2);
			String num2 = ExcelUtils.getCellData(i, 3);

			if (executionFlag.contains("Y")) {

				switch (operationVar) {

				case "addition":
					calculatorpage.calculatorField.sendKeys(num1);
					calculatorpage.addition.click();
					calculatorpage.calculatorField.sendKeys(num2);
					calculatorpage.equals.click();
					break;
				case "subtraction":
					calculatorpage.calculatorField.sendKeys(num1);
					calculatorpage.subtraction.click();
					calculatorpage.calculatorField.sendKeys(num2);
					calculatorpage.equals.click();
					break;
				case "multiplication":
					calculatorpage.calculatorField.sendKeys(num1);
					calculatorpage.multiplication.click();
					calculatorpage.calculatorField.sendKeys(num2);
					calculatorpage.equals.click();
					break;
				case "division":
					calculatorpage.calculatorField.sendKeys(num1);
					calculatorpage.division.click();
					calculatorpage.calculatorField.sendKeys(num2);
					calculatorpage.equals.click();
					break;
				}

				String googleReadValue = calculatorpage.calculatorField.getText();
				ExcelUtils.setCellData(googleReadValue, i, 5);

			} else {
				ExcelUtils.setCellData("skipped", i, 5);
			}

			expectedResult = ExcelUtils.getCellData(i, 4).replace(".0", "");

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
