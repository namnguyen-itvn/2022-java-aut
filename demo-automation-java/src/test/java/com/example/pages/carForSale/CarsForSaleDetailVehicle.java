package com.example.pages.carForSale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class CarsForSaleDetailVehicle extends BasePage {
    public CarsForSaleDetailVehicle(WebDriver driver,String DriveTypeData) {
        super(driver);
        this.DriveTypeData = DriveTypeData;
    }

    public CarsForSaleDetailVehicle(WebDriver driver) {
        super(driver);
    }

    // car4sale detail vehicle element
    private String DriveTypeData = "";
    private WebElement lblTypeOfWheelDrive = keyword.findElement(By.xpath("//div[@aria-label='DRIVE TYPE']/parent::div/parent::div/child::div[@class='col-xs-10 margin-bottom-0']"));
    private WebElement lblPrice = keyword.findElement(By.xpath("//div[@data-cmp='pricing']/span"));
    private WebElement lblMileage = keyword.findElement(By.xpath("//div[@aria-label='MILEAGE']/parent::div/parent::div/child::div[@class='col-xs-10 margin-bottom-0']"));
        /**
     *  Return TypeOfWheelDriveDisplayed is correct or not
     * @return
     */
    public boolean isTypeOfWheelDriveDisplayed(){
        if (DriveTypeData == "AWD/4WD") {
            if ((lblTypeOfWheelDrive.getText().contains("All wheel drive")) | (lblTypeOfWheelDrive.getText().contains("4 wheel drive"))){
                return true;
            }
            else return false;
        }
        else if (DriveTypeData == "Front Wheel Drive") {
            if (lblTypeOfWheelDrive.getText().contains("front")) {
                return true;
            }
            else return false;
        }
        else if (DriveTypeData == "Rear Wheel Drive") {
            if (lblTypeOfWheelDrive.getText().contains("rear")) {
                return true;
            }
            else return false;
        }
        else return false;
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
}
