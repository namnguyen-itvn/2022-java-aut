package com.example.core.datadriven;

import org.testng.annotations.DataProvider;

import com.example.core.helper.JsonHelper;

public class DataCarSearch {
    @DataProvider(name = "DataCarSearch")
    public static Object[][] dataHonda() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/DataCar.json");    
    }
    @DataProvider(name = "DataNotHasExpertReview")
    public static Object[][] dataEagle() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/DataHasNotExpertReview.json");


    }
}

