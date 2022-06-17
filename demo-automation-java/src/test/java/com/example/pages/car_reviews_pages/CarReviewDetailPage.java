package com.example.pages.car_reviews_pages;

import java.util.List;

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
	private WebElement img10BestCarDeals = keyword.findElement(By.cssSelector("[alt='10 Best Car Deals']"));
	private WebElement txtTitle10BestCarDeals = keyword.findElement(By.xpath("//*[text()='10 Best Car Deals']"));
	private WebElement btnShopNow = keyword.findElement(By.xpath("//*[text()='Shop Now']"));
	private WebElement txtTitleOfPhotoSection = keyword
			.findElement(By.xpath("//h3[contains(text(),'Photos & Videos')]"));
	private WebElement imgPhotoSection = keyword
			.findElement(By.cssSelector("[class*='ScrollContent'] [class*='GridContainer']"));
	private List<WebElement> listOfPhotoSection = imgPhotoSection.findElements(By.cssSelector("[class='css-bjn8wh']"));
	private WebElement txtTitleAlsoFrom = keyword.findElement(By.xpath("//h4[contains(text(),'Also from')]"));
	private WebElement listVehicleOfAlsoFrom = keyword
			.findElement(By.xpath("//div[h4[contains(text(),'Also from')]]/following-sibling::*/ul"));
	private List<WebElement> itemInListAlsoFrom = listVehicleOfAlsoFrom
			.findElements(By.xpath("//div[h4[contains(text(),'Also from')]]/following-sibling::*/ul/li"));

	/*
	 * Compare Section
	 */
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

	/*
	 * 10 Best Car Deals Section
	 */
	public boolean verifyImgIsDisplayed() {
		return img10BestCarDeals.isDisplayed();
	}

	public boolean verifyTitle10BestDealCar() {
		return txtTitle10BestCarDeals.isDisplayed();
	}

	public boolean verifyImgAndTitle() {
		if (verifyImgIsDisplayed()) {
			if (verifyTitle10BestDealCar()) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Photo Section
	 */
	public boolean verifyTitlePhotoSection() {
		return txtTitleOfPhotoSection.isDisplayed();
	}

	public void getText() {
		System.out.println(keyword.findElement(By.cssSelector("[class*='IndicatorWrapper']")).getText().trim());
	}

	public boolean verifyNumberOfPhotoSection() {
		System.out.println(listOfPhotoSection.size());
		if (listOfPhotoSection.size() == 4) {
			return true;
		}
		return false;
	}

	/*
	 * Also From Section
	 */

	public boolean verifyTitleAlsoFromSection() {
		return txtTitleAlsoFrom.isDisplayed();
	}

	public void verifyNumberOfAlsoFromSection() {
		System.out.println(itemInListAlsoFrom.size());
	}

	/*
	 * Action on page
	 */
	public void clickOnSeeDetailButton() {
		keyword.clickByJS(btnSeeDetail);
	}

	public void clickOnCompareMoreLink() {
		keyword.clickByJS(lnkTextCompareCar);
	}

	public void clickOnShopNowButton() {
		keyword.clickByJS(btnShopNow);
	}

	public String getTitleAndNameOfSecondCar() {
		return txtTitleOfSecondCar + " " + txtNameOfSecondCar;
	}

	public void clickOnFirstItemInListAlsoFrom() {
		keyword.clickByJS(itemInListAlsoFrom.get(0));
	}
	/*
	 * parse string to int
	 * @param input string
	 */
	public int parseStringToNumber(String input)
	{
	String subString= input.substring(input.lastIndexOf("f") + 2);
	int number=Integer.parseInt(subString);
	return number;
	}

	public static String expectedTitle = "Compare to Similar Vehicles";
	public static String expectedTitleOfFirstCar = "Used 2019";
	public static String expectedNameOfFirstCar = "Honda Civic";
}
