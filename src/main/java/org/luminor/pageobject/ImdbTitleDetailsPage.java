package org.luminor.pageobject;

import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertEquals;

public class ImdbTitleDetailsPage {

    private static final String LBL_CONTENT_TITLE = "[data-testid='hero__primary-text']";

    private static final String LIST_ITEMS_CAST_MEMBER_NAME_SURNAME = "[data-testid='title-cast-item__actor']";

    private static final String LIST_ITEMS_TOP_CAST = "[data-testid='title-cast-item']";

    @Step("Verify imdb title name is as expected")
    public void verifyContentTitle(String expectedTitle) {
        final String actualTitle = $(LBL_CONTENT_TITLE).getText();
        assertEquals(actualTitle, expectedTitle, "Incorrect content title present on page!");
    }

    @Step("Verify Top Cast member count more than expected")
    public void verifyTopCastItemsMoreThan(int moreThanCount) {
        $$(LIST_ITEMS_TOP_CAST).shouldHave(sizeGreaterThan(moreThanCount));
    }

    @Step("Open Cast member details Page")
    public void clickToOpenCastMemberProfile(int index) {
        $$(LIST_ITEMS_TOP_CAST).get(index)
                .$(LIST_ITEMS_CAST_MEMBER_NAME_SURNAME).click();
    }

    public String getTopCastMemberNameSurname(int index) {
        return $$(LIST_ITEMS_TOP_CAST).get(index)
                .$(LIST_ITEMS_CAST_MEMBER_NAME_SURNAME).getText();
    }

}