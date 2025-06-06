package org.luminor.pageobject;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ImdbMainPage {

    private static final String BOX_SEARCH_SUGGESTION = "[id='react-autowhatever-navSuggestionSearch']";

    private static final String BUTTON_ACCEPT_COOKIE_PREFERENCES = "[data-testid='accept-button']";

    private static final String FIELD_SEARCH_RESULT = "[data-testid='search-result--const'][href*='title']";

    private static final String IMG_HOME = "[id='home_img']";

    private static final String INPUT_SEARCH = "[data-testid='suggestion-search']";

    private static final String TEXT_MOVIE_TITLE = "div[class*='searchResult__constTitle']";

    @Step("Verify Main imdb Page opened")
    public void verifyImdbMainPageOpened() {
        $(IMG_HOME).shouldBe(visible, enabled);
    }

    @Step("Input search phrase into search box")
    public void inputSearchPhrase(String text) {
        $(INPUT_SEARCH).setValue(text);
    }

    public String getCustomSearchResultTitle(Integer id) {
        if(!$(BOX_SEARCH_SUGGESTION).isDisplayed()){
            $(INPUT_SEARCH).click();
        }
        $$(FIELD_SEARCH_RESULT).get(id)
                .shouldBe(visible)
                .shouldBe(enabled);
        return $$(FIELD_SEARCH_RESULT).get(id).$(TEXT_MOVIE_TITLE)
                .getText();
    }

    @Step("Select search result")
    public void selectSearchResult(Integer id){
        $$(FIELD_SEARCH_RESULT).get(id).click();
    }

    @Step("Accept Cookie disclaimer")
    public void clickAcceptCookieStorageBanner(){
        $(BUTTON_ACCEPT_COOKIE_PREFERENCES).click();
    }

}