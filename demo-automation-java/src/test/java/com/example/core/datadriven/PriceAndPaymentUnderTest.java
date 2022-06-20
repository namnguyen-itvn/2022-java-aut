package com.example.core.datadriven;

import org.testng.annotations.DataProvider;

import com.example.core.helper.JsonHelper;

public class PriceAndPaymentUnderTest {
    @DataProvider(name = "PriceAndPaymentUnderTest")
    public static Object[][] dataTest() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/priceandpaymentdata.json");
    }
}
