package com.example.core.datadriven;

import com.example.core.helper.JsonHelper;

import org.testng.annotations.DataProvider;

public class CarUnderTest {
    // * DataProvider 
    @DataProvider(name = "dataForGetCarReviews")
    public static Object carData() {
        return JsonHelper.ReadJsonFromFile("src\\test\\java\\com\\example\\core\\resources\\cardata.json");
    } 
}
