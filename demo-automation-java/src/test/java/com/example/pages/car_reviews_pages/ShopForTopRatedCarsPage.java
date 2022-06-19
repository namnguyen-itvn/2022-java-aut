package com.example.pages.car_reviews_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.pages.BasePage;

public class ShopForTopRatedCarsPage extends BasePage{

    public ShopForTopRatedCarsPage(WebDriver driver) {
        super(driver);
    }

    public ShopForTopRatedCarsPage() {
    }
    
//
    // private By txtFord = By.xpath("//*[@id='strc-ford-f150-0']");
    // private By txtChevrolet = By.xpath("//*[@id='strc-chevrolet-silverado-4']");
    // private By txtRam = By.xpath("//*[@id='strc-ram-1500-8']");
    // private By txtToyotaCamry = By.xpath("//*[@id='strc-toyota-camry-1']");
    // private By txtHondaCR = By.xpath("//*[@id='strc-honda-cr-v-5']");
    // private By txtHondaCiviv = By.xpath("//*[@id='strc-honda-civic-9']");
    // private By txtNissan = By.xpath("//*[@id='strc-nissan-rogue-2']");
    // private By txtToyotaCorolla = By.xpath("//*[@id='strc-toyota-corolla-6']");
    // private By txtHondaAccord = By.xpath("//*[@id='strc-honda-accord-10']");
    // private By txtJeep = By.xpath("//*[@id='strc-jeep-wrangler-3']");
    // private By txtFordRanger = By.xpath("//*[@id='strc-ford-ranger-7']");
    // private By txtSubaru = By.xpath("//*[@id='strc-subaru-outback-11']");

//
    // public boolean isDisplayedItem(){
    //     return keyword.findElement(txtFord).isDisplayed() &
    //     keyword.findElement(txtChevrolet).isDisplayed() &
    //     keyword.findElement(txtRam).isDisplayed() &
    //     keyword.findElement(txtToyotaCamry).isDisplayed() &
    //     keyword.findElement(txtHondaCR).isDisplayed() &
    //     keyword.findElement(txtHondaCiviv).isDisplayed() &
    //     keyword.findElement(txtNissan).isDisplayed() &
    //     keyword.findElement(txtToyotaCorolla).isDisplayed() &
    //     keyword.findElement(txtHondaAccord).isDisplayed() &
    //     keyword.findElement(txtJeep).isDisplayed() &
    //     keyword.findElement(txtFordRanger).isDisplayed() &
    //     keyword.findElement(txtSubaru).isDisplayed();
    // }

    private By txtToyotaCamry = By.xpath("//*[@id='strc-toyota-camry-1']");

    private By listOfTopRatedCarsPage = By.xpath("//div[@data-cypress='top-rated-cars']");

    public boolean isDisplayedTopRatedCarsPage() {
        keyword.scrollToElement(keyword.findElement(listOfTopRatedCarsPage));
        return keyword.findElement(listOfTopRatedCarsPage).isDisplayed();
    }
    
//Click  on link
    public void isClickOnItem() {
        keyword.click(keyword.findElement(txtToyotaCamry));
    }
    public boolean isClickOnFordItemCorrect() {
        String expectedUrl = "https://staging.kbb.com/cars-for-sale/new/toyota/camry";
        String actualUrl = driver.getCurrentUrl();
        return actualUrl.equals(expectedUrl);
    }

}
