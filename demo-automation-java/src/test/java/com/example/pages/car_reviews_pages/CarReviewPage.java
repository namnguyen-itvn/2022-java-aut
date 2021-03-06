package com.example.pages.car_reviews_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.core.keyword.WebKeyword.chooseTypeOfSelect;
import com.example.pages.BasePage;

public class CarReviewPage extends BasePage {
    public CarReviewPage(WebDriver driver)
	{
		super(driver);
	}

	private By ddlYear = (By.cssSelector("[aria-label='Year']"));
	private By ddlMake = (By.cssSelector("[aria-label='Make']"));
	private By ddlModel = (By.cssSelector("[aria-label='Model']"));
    private WebElement txtZipCode=driver.findElement(By.cssSelector("[class*='text-input']"));
	private By btnSubmit = (By.cssSelector("[class*='WrappedButton']"));

	//Fill the information of vehicle to redirect to detail page of that vehicle
	public void fillInformation(String year,String make,String model,String zipcode)
	{
		keyword.setValueForSelectElement(keyword.findElement(ddlYear), chooseTypeOfSelect.selectByValue, year);
		keyword.setValueForSelectElement(keyword.findElement(ddlMake), chooseTypeOfSelect.selectByValue, make);
		keyword.setValueForSelectElement(keyword.findElement(ddlModel), chooseTypeOfSelect.selectByValue, model);
        txtZipCode.sendKeys(zipcode);
		keyword.click(keyword.findElement(btnSubmit));
	}
}
