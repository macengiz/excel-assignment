package com.excel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.excel.utilities.Driver;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(id = "lst-ib")
	public WebElement searchField;
}
