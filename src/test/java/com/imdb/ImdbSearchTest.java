package com.imdb;

import com.imdb.base.BaseTest;
import com.imdb.data.TestData;
import com.imdb.pages.*;
import io.qameta.allure.*;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Epic("IMDB Search")
@Feature("Search and Profile Navigation")
public class ImdbSearchTest extends BaseTest {

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private TitlePage titlePage;
    private ProfilePage profilePage;

    @BeforeMethod
    public void setUpPages() {
        homePage = new HomePage();
        searchResultsPage = new SearchResultsPage();
        titlePage = new TitlePage();
        profilePage = new ProfilePage();
    }

    @Test(description = "IMDB QA Search and Profile Navigation")
    @Description("Automates the regression test case for IMDB search and profile navigation using POM")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User searches for content and navigates to profile")
    public void testImdbSearchAndProfile() {
        // 1) Open imdb.com
        homePage.open();
        homePage.waitForPageLoad();

        // 2) Search for "QA" with the search bar
        homePage.search(TestData.SEARCH_QUERY_QA);

        // 3) When dropdown opens, save the name of the second title
        String secondTitleName = searchResultsPage.getSecondTitleName();

        // 4) Click on the second title
        searchResultsPage.clickSecondTitle();

        // 5) Verify that page title matches the one saved from the dropdown
        assertEquals(titlePage.getTitle(), secondTitleName, "Title page header should match dropdown");

        // 6) Verify there are more than 3 members in the "top cast section"
        assertTrue(titlePage.getTopCastCount() > TestData.MIN_CAST_MEMBERS, 
                  "Top cast should have more than " + TestData.MIN_CAST_MEMBERS + " members");

        // 7) Click on the 3rd profile in the "top cast section"
        String thirdProfileName = titlePage.getThirdProfileName();
        titlePage.clickThirdProfile();

        // 8) Verify that correct profile have opened
        assertTrue(profilePage.getProfileName().contains(thirdProfileName),
    "Profile page header should contain the 3rd cast member name");
    }
} 