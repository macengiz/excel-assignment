package com.excel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.excel.utilities.Driver;

public class CalculatorPage {

	public CalculatorPage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(id = "cwtltblr")
	public WebElement calculatorField;

	@FindBy(xpath = "(//div[@class='cwbtpl cwdgb-tpl cwbbts']/span[@class='cwbts'])[4]")
	public WebElement addition;

	@FindBy(xpath = "(//div[@class='cwbtpl cwdgb-tpl cwbbts']/span[@class='cwbts'])[3]")
	public WebElement subtraction;

	@FindBy(xpath = "(//div[@class='cwbtpl cwdgb-tpl cwbbts']/span[@class='cwbts'])[2]")
	public WebElement multiplication;

	@FindBy(xpath = "(//div[@class='cwbtpl cwdgb-tpl cwbbts']/span[@class='cwbts'])[1]")
	public WebElement division;

	@FindBy(xpath = "//*[@id='cwbt45']/div/span")
	public WebElement equals;

}
