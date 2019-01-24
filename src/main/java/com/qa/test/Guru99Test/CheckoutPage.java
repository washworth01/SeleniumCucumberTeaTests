package com.qa.test.Guru99Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage
{
	@FindBy(xpath = "/html/head/title")
	private WebElement checkoutHeaderText;
	
	public String getCheckoutHeaderText()
	{
		return checkoutHeaderText.getAttribute("innerText");
	}
}