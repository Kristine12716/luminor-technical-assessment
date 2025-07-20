package com.imdb.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    private final SelenideElement profileHeader = $x("//*[@data-testid='hero__pageTitle']");

    public String getProfileName() {
        return profileHeader.getText();
    }
} 