package com.example.core.datadriven;

import org.testng.annotations.DataProvider;

import com.example.core.helper.JsonHelper;

public class CarForSaleTestData {
    @DataProvider(name="distanceData")
    public static Object[][] dataDistanceTest() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/distancedata.json");
    }

    @DataProvider(name="zipCodeData")
    public static Object[][] dataZipcodeTest() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/zipcodedata.json");
    }

    @DataProvider(name="expectedFuelEconomyDataForTest")
    public static Object[][] dataExpectedFuelEconomyDataForTest() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/expectedfueleconomydata.json");
    }
}
