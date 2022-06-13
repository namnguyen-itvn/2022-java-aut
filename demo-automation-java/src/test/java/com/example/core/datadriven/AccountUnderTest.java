package com.example.core.datadriven;

import com.example.core.helper.JsonHelper;

import org.testng.annotations.DataProvider;

public class AccountUnderTest {

    @DataProvider(name = "AccountUnderTest")
    public static Object[][] dataTest() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/accountdata.json");
    }
    
}
