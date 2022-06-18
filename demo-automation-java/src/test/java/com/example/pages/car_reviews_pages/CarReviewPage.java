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
	


	public void fillInformation()
	{
		keyword.setValueForSelectElement(keyword.findElement(ddlYear), chooseTypeOfSelect.selectByValue, yearString);
		keyword.setValueForSelectElement(keyword.findElement(ddlMake), chooseTypeOfSelect.selectByValue, makeString);
		keyword.setValueForSelectElement(keyword.findElement(ddlModel), chooseTypeOfSelect.selectByValue, modelString);
		// keyword.setText(keyword.findElement(txtZipCode), zipcodeString);
        txtZipCode.sendKeys(zipcodeString);
		keyword.click(keyword.findElement(btnSubmit));
	}

	public static String yearString = "2019";
	public static String makeString = "Honda";
	public static String modelString = "Civic";
	public static String zipcodeString = "12345";
}
