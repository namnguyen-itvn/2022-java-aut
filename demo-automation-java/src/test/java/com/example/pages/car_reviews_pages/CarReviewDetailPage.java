package com.example.pages.car_reviews_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.example.pages.BasePage;

public class CarReviewDetailPage extends BasePage {

	public CarReviewDetailPage(WebDriver driver) {
		super(driver);
	}

	private WebElement h4CompareSection = keyword.findElement(By.xpath("//*[text()='Compare to Similar Vehicles']"));
	private WebElement compareCars = keyword.findElement(By.xpath("//thead/tr[1]"));
	private List<WebElement> listOfCompareCars = compareCars
			.findElements(By.cssSelector("th[class*='TableColumnHeader']"));
	private WebElement txtTitleOfFirstCar = listOfCompareCars.get(0)
			.findElement(By.xpath("//thead//*[contains(@class,'GridContainer')]//div[last()]//div[1]"));
	private WebElement txtNameOfFirstCar = listOfCompareCars.get(0)
			.findElement(By.xpath("//thead//*[contains(@class,'GridContainer')]//div[last()]//div[last()]"));
	private WebElement txtTitleOfSecondCar = listOfCompareCars.get(1)
			.findElement(By.xpath("//thead//*[contains(@class,'GridContainer')]//div[last()]//div[1]"));
	private WebElement txtNameOfSecondCar = listOfCompareCars.get(1)
			.findElement(By.xpath("//thead//*[contains(@class,'GridContainer')]//div[last()]//div[last()]"));
	private WebElement btnSeeDetail = keyword.findElement(By.id("columnButton1"));
	private WebElement lnkTextCompareCar = keyword.findElement(By.xpath("//*[text()='Compare More']//span"));
	private WebElement img10BestCarDeals = keyword.findElement(By.cssSelector("[alt='10 Best Car Deals']"));
	private WebElement txtTitle10BestCarDeals = keyword.findElement(By.xpath("//*[text()='10 Best Car Deals']"));
	private WebElement btnShopNow = keyword.findElement(By.cssSelector("[data-analytics='simp_native_temp_fallback_btn']"));
	private WebElement txtTitleOfPhotoSection = keyword
			.findElement(By.xpath("//h3[contains(text(),'Photos & Videos')]"));
	private WebElement imgPhotoSection = keyword
			.findElement(By.cssSelector("[class*='ScrollContent'] [class*='GridContainer']"));
	private List<WebElement> listOfPhotoSection = imgPhotoSection.findElements(By.cssSelector("[class='css-bjn8wh']"));
	private WebElement txtNumberOfPhotoSection = keyword.findElement(By.cssSelector("[class*='IndicatorWrapper']"));
	private WebElement btnRightArrow = keyword.findElement(By.cssSelector("[aria-label='navigate to carousel right']"));
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
	public boolean verifyTitlePhotoSection(String year, String make, String model) {
		String expectedTitle = year + " " + make + " " + model + " " + "Photos & Videos";
		return txtTitleOfPhotoSection.getText().trim().equals(expectedTitle);
	}

	public int getNumberOfPhotoSection() {
		return parseStringToNumber(txtNumberOfPhotoSection.getText().trim());
	}

	public boolean verifyNumberOfPhotoSection() {
		return listOfPhotoSection.size() == getNumberOfPhotoSection();
	}

	public boolean verifyRightArrowButtonIsDisplayedIfNumberOfItemMoreThan4() {
		if (listOfPhotoSection.size() >= 4) {
			return btnRightArrow.isDisplayed();
		}
		return false;
	}

	public boolean verifyTheUIOfPhotosSectionWillBeDisplay(String year, String make, String model) {
		if (verifyTitlePhotoSection(year, make, model)) {
			if (verifyRightArrowButtonIsDisplayedIfNumberOfItemMoreThan4()) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Also From Section
	 */

	public boolean verifyTitleAlsoFromSection(String make) {
		String expectedTitle = "Also from " + make;
		return txtTitleAlsoFrom.getText().trim().equals(expectedTitle.trim());
	}

	public String getTitleOfFirstItemInListAlsoFrom() {
		System.out.println(itemInListAlsoFrom.get(0).getText().trim());
		return itemInListAlsoFrom.get(0).getText().trim();
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
		Actions builder = new Actions(driver);
		builder.moveToElement(itemInListAlsoFrom.get(0)).click(itemInListAlsoFrom.get(0));
		builder.perform();
	}

	/*
	 * parse string to int
	 * 
	 * @param input string
	 */
	public int parseStringToNumber(String input) {
		String subString = input.substring(input.lastIndexOf("f") + 2);
		int number = Integer.parseInt(subString);
		return number;
	}

	public static String expectedTitle = "Compare to Similar Vehicles";
	public static String expectedTitleOfFirstCar = "Used 2019";
	public static String expectedNameOfFirstCar = "Honda Civic";
}
