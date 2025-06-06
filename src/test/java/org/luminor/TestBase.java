package org.luminor;

import org.luminor.framework.CommonUtils;
import org.luminor.pageobject.ImdbMainPage;
import org.luminor.pageobject.ImdbPersonDetailsPage;
import org.luminor.pageobject.ImdbTitleDetailsPage;

import static com.codeborne.selenide.Selenide.open;

public class TestBase extends CommonUtils {

    ImdbMainPage imdbMainPage = new ImdbMainPage();

    ImdbTitleDetailsPage imdbTitleDetailsPage = new ImdbTitleDetailsPage();

    ImdbPersonDetailsPage imdbPersonDetailsPage = new ImdbPersonDetailsPage();

    public void openImdbPage() {
        open("https://www.imdb.com/");
        imdbMainPage.verifyImdbMainPageOpened();
        imdbMainPage.clickAcceptCookieStorageBanner();
    }

}