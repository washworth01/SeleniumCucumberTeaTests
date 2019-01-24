package com.qa.test.Guru99Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage
{
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong")
	private WebElement menuItem1;
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231072\"]/div/p/span/span/strong")
	private WebElement menuItem2;
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231735\"]")
	private WebElement menuItem3;
		
	public String browseAvailableItems()
	{
		return menuItem1.getAttribute("innerText");
	}
}