package com.example.core.datadriven;

import com.example.core.helper.JsonHelper;
import org.testng.annotations.DataProvider;

public class InfoCarReviewUnderTest {
    @DataProvider(name = "InfoCarReviewUnderTest")
    public static Object[][] dataTest() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/infocarreviewundertest.json");
    }
}
