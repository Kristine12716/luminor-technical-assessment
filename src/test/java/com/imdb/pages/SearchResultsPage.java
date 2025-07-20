package com.imdb.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class SearchResultsPage {
    private final ElementsCollection dropdownTitles = $$x("//div[contains(@class, 'searchResult__constTitle')]");

    public String getSecondTitleName() {
        dropdownTitles.get(1).shouldBe(Condition.visible);
        return dropdownTitles.get(1).getText();
    }

    public void clickSecondTitle() {
        dropdownTitles.get(1).shouldBe(Condition.visible).click();
    }
} 