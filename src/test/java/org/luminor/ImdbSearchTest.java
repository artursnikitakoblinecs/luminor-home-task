package org.luminor;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class ImdbSearchTest extends TestBase {

    private static final String MOVIE_SEARCH_PHRASE = "QA";

    private static final int CAST_MEMBER_INDEX = 2;

    private static final int SEARCH_TITLE_INDEX = 0;

    @Test
    @Description("Imdb Page - Verify movie search and cast member listing")
    public void testCheckMovieSearchAndCastMembers() {
        // Open imdb.com
        openImdbPage();

        // Search for "QA" with the search bar
        imdbMainPage.inputSearchPhrase(MOVIE_SEARCH_PHRASE);

        // When dropdown opens, save the name of the first title
        String movieTitle = imdbMainPage.getCustomSearchResultTitle(SEARCH_TITLE_INDEX);

        // Click on the first title
        imdbMainPage.selectSearchResult(SEARCH_TITLE_INDEX);

        // Verify that page title matches the one saved from the dropdown
        imdbTitleDetailsPage.verifyContentTitle(movieTitle);

        // Verify there are more than 3 members in the "top cast section"
        imdbTitleDetailsPage.verifyTopCastItemsMoreThan(3);

        // Click on the 3rd profile in the "top cast section"
        String actorNameSurname = imdbTitleDetailsPage.getTopCastMemberNameSurname(CAST_MEMBER_INDEX);
        imdbTitleDetailsPage.clickToOpenCastMemberProfile(CAST_MEMBER_INDEX);

        // Verify that correct profile have opened
        imdbPersonDetailsPage.verifyPersonTitle(actorNameSurname);
    }

}