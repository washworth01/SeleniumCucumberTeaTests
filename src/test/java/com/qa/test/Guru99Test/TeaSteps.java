package com.qa.test.Guru99Test;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.william.maven.cucumber.parameters.parametersExercise.ParametersTestRunner;

import Selenium.Constants;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TeaSteps 
{
	
	WebElement element;
	WebDriver driver;
	
	@Before
	public void setup()
	{
		System.setProperty(Constants.CHROMEDRIVER, Constants.CHROMEDRIVERLOCATION);
		driver = new ChromeDriver();
		driver.manage().window();
	}
	
	@After
	public void tearDown()
	{
		driver.close();
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address() 
	{
		TeaTestRunner.test = TeaTestRunner.report.startTest("TestMenu");
	
		driver.get(Constants.LANDINGPAGEURL);
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() throws InterruptedException 
	{
		TeaTestRunner.test.log(LogStatus.INFO, "Navigating to the Menu Page");
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.clickMenuLink();
		TeaTestRunner.test.log(LogStatus.INFO, "Navigation to Menu Page finished");
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products()
	{
		TeaTestRunner.test.log(LogStatus.INFO, "Checking Heading is present");
	    MenuPage menuPage = PageFactory.initElements(driver, MenuPage.class);
	    menuPage.browseAvailableItems();
	    TeaTestRunner.test.log(LogStatus.INFO, "The Heading has been checked");
	    assertEquals("Heading does not match.", "Green Tea", menuPage.browseAvailableItems());
	    if(menuPage.browseAvailableItems() == "Green Tea")
	    {
	    	TeaTestRunner.test.log(LogStatus.PASS, "Result should be Green Tea | Expected: " + "Green Tea" + " | Actual: " + menuPage.browseAvailableItems());
		}
		else
		{
			TeaTestRunner.test.log(LogStatus.FAIL, "Result should be Green Tea | Expected: " + "Green Tea" + " | Actual: " + menuPage.browseAvailableItems());
		}
	    TeaTestRunner.test.log(LogStatus.PASS, "Result should be Green Tea | Expected: " + "Green Tea" + " | Actual: " + menuPage.browseAvailableItems());
	    TeaTestRunner.report.endTest(TeaTestRunner.test);
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button()
	{
		TeaTestRunner.test.log(LogStatus.INFO, "Navigating to the Checkout Page");
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.clickCheckoutLink();
		TeaTestRunner.test.log(LogStatus.INFO, "Navigation to Checkout Page finished");
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page()
	{
		TeaTestRunner.test.log(LogStatus.INFO, "Checking Header innnerText");
	    CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
	    checkoutPage.getCheckoutHeaderText();
	    TeaTestRunner.test.log(LogStatus.INFO, "Header innerText has been checked");
	    if(checkoutPage.getCheckoutHeaderText() == "Check Out")
		{
	    	TeaTestRunner.test.log(LogStatus.PASS, "Result should be Check Out | Expected: " + "Check Out" + " | Actual: " + checkoutPage.getCheckoutHeaderText());

		}
		else
		{
			TeaTestRunner.test.log(LogStatus.FAIL, "Result should be Check Out | Expected: " + "Check Out" + " | Actual: " + checkoutPage.getCheckoutHeaderText());
		}
	    assertEquals("Heading Inner Text does not match", "Check Out", checkoutPage.getCheckoutHeaderText());
	    TeaTestRunner.test.log(LogStatus.PASS, "Result should be Check Out | Expected: " + "Check Out" + " | Actual: " + checkoutPage.getCheckoutHeaderText());
	    TeaTestRunner.report.endTest(TeaTestRunner.test);
	}

}