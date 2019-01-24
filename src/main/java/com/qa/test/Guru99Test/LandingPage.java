package com.qa.test.Guru99Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage
{
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	private WebElement menuLink;
	
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a")
	private WebElement checkoutLink;
	public void clickMenuLink()
	{
		menuLink.click();
	}
	
	public void clickCheckoutLink()
	{
		checkoutLink.click();
	}
} 
