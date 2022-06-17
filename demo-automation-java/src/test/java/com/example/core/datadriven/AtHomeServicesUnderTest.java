package com.example.core.datadriven;

import org.testng.annotations.DataProvider;

import com.example.core.helper.JsonHelper;

public class AtHomeServicesUnderTest {
    @DataProvider(name = "optionAtHomeServices")
    public static Object[][] dataTest() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/atHomeServicesData.json");
    }
}
