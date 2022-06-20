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

	
	//Compare Section
	/*
     * Check the title page after redirected change or not
     * Return true if title change as expected
     */
	public boolean verifyTitleCompareSection() {
		keyword.scrollToElement(h4CompareSection);
		return h4CompareSection.getText().equals(expectedTitle);
	}

	/*
     * Check the title and name of first car at compare cars section
     * Return true if title and name display
     */
	public boolean verifyTitleAndNameOfFirstCarInCompareSection() {
		if (txtTitleOfFirstCar.getText().trim().equals(expectedTitleOfFirstCar)) {
			if (txtNameOfFirstCar.getText().trim().equals(expectedNameOfFirstCar)) {
				return true;
			}
		}
		return false;
	}

	/*
     * Check the see detail button at compare cars section display or not
     * Return true if see detail button display
     */
	public boolean verifySeeDetailButtonClickable() {
		return btnSeeDetail.isDisplayed();
	}

	/*
     * Check the compare more link at compare cars section display or not
     * Return true if see detail button display
     */
	public boolean verifyCompareCarHrefIsClickable() {
		return lnkTextCompareCar.isDisplayed();
	}

	/*
     * Check the UI of compare cars section display or not
     * Return true if all UI of compare cars section display
	 * UI include title of section,title and name of car, see detail button, compare more link
     */
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

	//10 Best Car Deals Section
	/*
	 * Check the Img of 10 Best Car Deals section display or not
	 * Return true if the Img of 10 Best Car Deals section display
	 */
	public boolean verifyImgIsDisplayed() {
		return img10BestCarDeals.isDisplayed();
	}

	/*
	 * Check the title of 10 Best Car Deals section display or not
	 * Return true if the title of 10 Best Car Deals section display
	 */
	public boolean verifyTitle10BestDealCar() {
		return txtTitle10BestCarDeals.isDisplayed();
	}

	/*
     * Check the UI of compare cars section display or not
     * Return true if all UI of compare cars section display
	 * UI include title and Img of section
     */
	public boolean verifyImgAndTitle() {
		if (verifyImgIsDisplayed()) {
			if (verifyTitle10BestDealCar()) {
				return true;
			}
		}
		return false;
	}

	
	 //Photos Section
	/*
	 * Check the title of Photos section display following form [Year] + [Make] + [Model] + Photos & Videos
	 * Return true if the title of Photos section display following form [Year] + [Make] + [Model] + Photos & Videos 
	 */
	public boolean verifyTitlePhotoSection(String year, String make, String model) {
		String expectedTitle = year + " " + make + " " + model + " " + "Photos & Videos";
		return txtTitleOfPhotoSection.getText().trim().equals(expectedTitle);
	}

	/*
	 * Get number of photo of Photos section
	 * Return number of photos
	 */
	public int getNumberOfPhotoSection() {
		return parseStringToNumber(txtNumberOfPhotoSection.getText().trim());
	}

	/*
	 * Check the right arrow button of Photos section display or not
	 * Return true if the right arrow button of Photos section display if the number of photo > 4
	 */
	public boolean verifyRightArrowButtonIsDisplayedIfNumberOfItemMoreThan4() {
		if (listOfPhotoSection.size() > 4) {
			return btnRightArrow.isDisplayed();
		}
		return false;
	}

	/*
     * Check the UI of Photos section display or not
     * Return true if all UI of Photos section display
	 * UI include title and right arrow button of section
     */
	public boolean verifyTheUIOfPhotosSectionWillBeDisplay(String year, String make, String model) {
		if (verifyTitlePhotoSection(year, make, model)) {
			if (verifyRightArrowButtonIsDisplayedIfNumberOfItemMoreThan4()) {
				return true;
			}
		}
		return false;
	}

	//Also From Section
	/*
	 * Check the title of Also From section display
	 * Return true if the title of Also From section display following form Also from  + [Make]
	 * @param make of vehicle
	 */
	public boolean verifyTitleAlsoFromSection(String make) {
		String expectedTitle = "Also from " + make;
		return txtTitleAlsoFrom.getText().trim().equals(expectedTitle.trim());
	}

	/*
	 * Get title of first item of Also from section
	 * Return string title of first item of Also from
	 */
	public String getTitleOfFirstItemInListAlsoFrom() {
		return itemInListAlsoFrom.get(0).getText().trim();
	}

	//Click on see detail button to redirect to see detail page
	public void clickOnSeeDetailButton() {
		keyword.clickByJS(btnSeeDetail);
	}

	//Click on compare more link to redirect to compare more page
	public void clickOnCompareMoreLink() {
		keyword.clickByJS(lnkTextCompareCar);
	}

	//Click on shop now button to redirect to 10 Best Car Deals page
	public void clickOnShopNowButton() {
		keyword.clickByJS(btnShopNow);
	}

	/*
	 * Get title and name of second item of Compare section
	 * Return string of title and name of second item of Compare section
	 */
	public String getTitleAndNameOfSecondCar() {
		return txtTitleOfSecondCar + " " + txtNameOfSecondCar;
	}

	//Click on first item in list Also from to redirect to Car Review page of that item
	public void clickOnFirstItemInListAlsoFrom() {
		Actions builder = new Actions(driver);
		builder.moveToElement(itemInListAlsoFrom.get(0)).click(itemInListAlsoFrom.get(0));
		builder.perform();
	}

	/*
	 * parse string to int
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
