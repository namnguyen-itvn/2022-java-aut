package com.example.core.datadriven;

import org.testng.annotations.DataProvider;

import com.example.core.helper.JsonHelper;

public class DriveTypeUnderTest {
    @DataProvider(name="DriveTypeUnderTest")
    public static Object[][] dataTest() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/drivetypeoptdata.json");
    }
}
