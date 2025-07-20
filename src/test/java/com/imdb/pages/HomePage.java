package com.imdb.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.imdb.data.TestData;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final SelenideElement searchInput = $("input[placeholder*='Search'], input[name='q'], #suggestion-search");

    public void open() {
        com.codeborne.selenide.Selenide.open(TestData.BASE_URL);
    }

    public void search(String query) {
        searchInput.shouldBe(Condition.visible).setValue(query);
    }

    public void waitForPageLoad() {
        searchInput.shouldBe(Condition.visible);
    }
} 