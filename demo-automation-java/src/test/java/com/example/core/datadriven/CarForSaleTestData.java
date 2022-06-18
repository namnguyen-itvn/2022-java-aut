package com.example.core.datadriven;

import org.testng.annotations.DataProvider;

import com.example.core.helper.JsonHelper;

public class CarForSaleTestData {
    @DataProvider(name="distanceDataForTest")
    public static Object[][] dataDistanceTest() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/distancedata.json");
    }

    @DataProvider(name="zipCodeDataForTest")
    public static Object[][] dataZipcodeTest() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/zipcodedata.json");
    }

    @DataProvider(name="yearDataForTest")
    public static Object[][] dataYearTest() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/yeardata.json");
    }

    @DataProvider(name="expectedFuelEconomyDataForTest")
    public static Object[][] expectedFuelEconomyDataForTest() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/expectedfueleconomydata.json");
    }

    @DataProvider(name="fuelEconomyDataForTest")
    public static Object[][] fuelEconomyDataForTest() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/fueleconomydata.json");
    }

    @DataProvider(name="expectedYearData")
    public static Object[][] expectedYearData() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/expectedyeardata.json");
    }

    @DataProvider(name="expectedDistanceData")
    public static Object[][] expectedDistanceData() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/expecteddistancedata.json");
    }
}
