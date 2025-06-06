package org.luminor.pageobject;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

public class ImdbPersonDetailsPage {

    private static final String LBL_PERSON_TITLE = "[data-testid='hero__primary-text']";

    @Step("Verify person Name and Surname is as expected")
    public void verifyPersonTitle(String expectedTitle) {
        final String actualTitle = $(LBL_PERSON_TITLE).getText();
        assertEquals(actualTitle, expectedTitle, "Incorrect Cast Member Name Surname present on page!");
    }

}