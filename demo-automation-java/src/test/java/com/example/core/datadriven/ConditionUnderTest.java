package com.example.core.datadriven;

import org.testng.annotations.DataProvider;

import com.example.core.helper.JsonHelper;

public class ConditionUnderTest {
    @DataProvider(name = "optionCondition")
    public static Object[][] dataTest() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/conditiondata.json");
    }

    @DataProvider(name = "conditioncheckdata")
    public static Object[][] dataTest1() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/conditioncheckdata.json");
    }
}
