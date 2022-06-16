package com.example.pages.carForSale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class KbbCarsForSaleDetailVehicle extends BasePage {
    public KbbCarsForSaleDetailVehicle(WebDriver driver,String DriveTypeData) {
        super(driver);
        this.DriveTypeData = DriveTypeData;
    }

    private String DriveTypeData = "";
    private WebElement lblTypeOfWheelDrive = keyword.findElement(By.xpath("//div[@aria-label='DRIVE TYPE']/parent::div/parent::div/child::div[@class='col-xs-10 margin-bottom-0']"));
    //div.col-xs-12.col-sm-7.col-md-8 li:nth-child(4)

    public boolean isTypeOfWheelDriveDisplayed(){
        if (DriveTypeData == "AWD/4WD") {
            if ((lblTypeOfWheelDrive.getText().contains("All wheel drive")) | (lblTypeOfWheelDrive.getText().contains("4 wheel drive"))){
                return true;
            }
            else return false;
        }
        else if (DriveTypeData == "Front Wheel Drive") {
            if (lblTypeOfWheelDrive.getText().contains("Front Wheel Drive")) {
                return true;
            }
            else return false;
        }
        else if (DriveTypeData == "Rear Wheel Drive") {
            if (lblTypeOfWheelDrive.getText().contains("rear wheel default")) {
                return true;
            }
            else return false;
        }
        else return false;
    }
    
}
