package com.example.pages.car_reviews_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class CarReviewDetailPage extends BasePage {

	public CarReviewDetailPage(WebDriver driver) {
		super(driver);
	}

	private WebElement h4CompareSection = keyword.findElement(By.xpath("//*[text()='Compare to Similar Vehicles']"));
	private WebElement txtTitleOfFirstCar = keyword.findElement(By.xpath("//*[text()='Used']"));
	private WebElement txtNameOfFirstCar = keyword
			.findElement(By.xpath("//*[contains(@class,'ContentWrapper')]//*[text()='Honda Civic']"));
	private WebElement txtTitleOfSecondCar = keyword.findElement(By.xpath("//*[text()='New']"));
	private WebElement txtNameOfSecondCar = keyword
			.findElement(By.xpath("//*[contains(@class,'ContentWrapper')]//*[text()='Hyundai Veloster']"));
	private WebElement btnSeeDetail = keyword.findElement(By.id("columnButton1"));
	private WebElement lnkTextCompareCar = keyword.findElement(By.xpath("//*[text()='Compare More']//span"));

	public boolean verifyTitleCompareSection() {
		keyword.scrollToElement(h4CompareSection);
		return h4CompareSection.getText().equals(expectedTitle);
	}

	public boolean verifyTitleAndNameOfFirstCarInCompareSection() {
		if (txtTitleOfFirstCar.getText().trim().equals(expectedTitleOfFirstCar)) {
			if (txtNameOfFirstCar.getText().trim().equals(expectedNameOfFirstCar)) {
				return true;
			}
		}
		return false;
	}

	public boolean verifySeeDetailButtonClickable() {
		return btnSeeDetail.isEnabled();
	}

	public boolean verifyCompareCarHrefIsClickable() {
		return lnkTextCompareCar.isEnabled();
	}

	public boolean verifyUIOfCompareCarsSection() {
		if (verifyTitleCompareSection()) {
			if (verifyTitleAndNameOfFirstCarInCompareSection()) {
				if (verifySeeDetailButtonClickable()) {
					if (verifyCompareCarHrefIsClickable()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void clickOnSeeDetailButton() {
		keyword.clickByJS(btnSeeDetail);
	}

	public void clickOnCompareMoreLink() {
		keyword.clickByJS(lnkTextCompareCar);
	}

	public String getTitleAndNameOfSecondCar() {
		return txtTitleOfSecondCar + " " + txtNameOfSecondCar;
	}

	public static String expectedTitle = "Compare to Similar Vehicles";
	public static String expectedTitleOfFirstCar = "Used 2019";
	public static String expectedNameOfFirstCar = "Honda Civic";
}
