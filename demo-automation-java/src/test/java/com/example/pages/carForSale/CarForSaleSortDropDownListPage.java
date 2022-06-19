package com.example.pages.carForSale;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.core.configuration.Configuration;
import com.example.pages.BasePage;

public class CarForSaleSortDropDownListPage extends BasePage {

    public CarForSaleSortDropDownListPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    WebElement listOptionOfSort = keyword.findElement(By.cssSelector("select[name='sortBy']"));
    Select selectSort = new Select(listOptionOfSort);
    public Configuration config;
    
    
    /**
     * check sort dropdown list should be displayed 'Revalance' as default
     * @return boolean check
     */
    public boolean checkSortDropDownListIsDisplayedRevalanceAsDefault() {
        boolean check = false;
        System.out.println(selectSort.getAllSelectedOptions().get(0).getText());
        if(selectSort.getAllSelectedOptions().get(0).getText().equals("Relevance")) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    /**
     * check all items on sort dropdown list is sorted by chosen sort option expect sponsored cars 
     * @return boolean check
     * @throws IOException
     * @throws NumberFormatException
     */

    public boolean checkSortDropdownListIsSortedByChosenSortOptionExpectSponsoredCars() throws NumberFormatException, IOException {
        boolean check = false;     
        System.out.println(selectSort.getOptions().get(1).getText());
        keyword.click(selectSort.getOptions().get(1));
        
        WebElement listPrice = keyword.findElement(By.xpath("//div[@data-qaid='cntnr-listings-tier-listings']/div[@data-cmp='delayedImpressionWaypoint']//span[@class='first-price']"));
        System.out.println(listPrice.getText());
        return check;
    } 

    
}
