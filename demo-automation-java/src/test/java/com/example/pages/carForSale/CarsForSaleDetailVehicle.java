package com.example.pages.carForSale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.pages.BasePage;

public class CarsForSaleDetailVehicle extends BasePage {
    public CarsForSaleDetailVehicle(WebDriver driver) {
        super(driver);
    }

    // car4sale detail vehicle element
    private WebElement lblTypeOfWheelDrive = keyword.findElement(By.xpath("//div[@aria-label='DRIVE TYPE']/parent::div/parent::div/child::div[@class='col-xs-10 margin-bottom-0']"));
    private WebElement lblPrice = keyword.findElement(By.xpath("//div[@data-cmp='pricing']/span"));
    private WebElement lblMileage = keyword.findElement(By.xpath("//div[@aria-label='MILEAGE']/parent::div/parent::div/child::div[@class='col-xs-10 margin-bottom-0']"));
    
    private By lblOptPriceRating = By.xpath("div.ribbon-content-left");

    /**
     *  Return TypeOfWheelDriveDisplayed is correct or not
     * @return
     */
    public boolean isTypeOfWheelDriveDisplayed(String DriveTypeData){
        if (DriveTypeData.contains("AWD/4WD") ) {
            if ((lblTypeOfWheelDrive.getText().contains("All wheel drive")) | (lblTypeOfWheelDrive.getText().contains("4 wheel drive"))){
                return true;
            }
            else return false;
        }
        else if (DriveTypeData.contains("Front Wheel Drive")) {
            if (lblTypeOfWheelDrive.getText().contains("front")) {
                return true;
            }
            else return false;
        }
        else if (DriveTypeData.contains("Rear Wheel Drive")) {
            if (lblTypeOfWheelDrive.getText().contains("rear")) {
                return true;
            }
            else return false;
        }
        else return false;
    }
    
    //wait with No Condition
    public void waitNoCondition(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     *  Return CarPriceCorectWithPricePayment is correct or not
     * @return
     */
    public boolean isCarPriceCorectWithPricePayment(String min, String max){
        double Min = Float.parseFloat(min);
        double Max = Float.parseFloat(max);
        Double Price = parseStringPriceToNumber(lblPrice.getText());
        if (Price>=Min && Price <=Max) {
            return true;
        }
        else return false;
    }

/**
     *  Return CarPriceCorectWithPricePayment is correct or not
     * @return
     */
    public boolean isCarPriceCorectWithMileage(String value){
        double Value = Float.parseFloat(value);
        Double Mile = parseStringMileToNumber(lblMileage.getText());
        if (Mile<=Value && Value!=200000) {
            return true;
        }
        else if(Mile>=Value & Value==200000){
            return true;
        }
        else return false;
    }

    //func convert Price to Number
    public double parseStringPriceToNumber(String input)
    {
        String removeComma = input.replace(",","");
        double number=Float.parseFloat(removeComma);
        return number;
    }

    //func convert Price to Number
    public double parseStringMileToNumber(String input)
    {
        String removeComma = input.replace(",","");
        String removeMile = removeComma.replace(" miles","");
        double number=Float.parseFloat(removeMile);
        return number;
    }

    /**
     *  Return lblPriceRating is correct or not
     * @return
     */
    public boolean isLblPriceRating(String value){
        WebElement lblOptPriceRating1 = keyword.findElement(lblOptPriceRating);
        value = value.toLowerCase();
        if (lblOptPriceRating1.getText().toLowerCase().equals(value)) {
            return true;
        }
        else return false;
    }
}
