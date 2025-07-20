package com.imdb.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class TitlePage {
    private final SelenideElement titleHeader = $x("//*[@data-testid='hero__pageTitle']");
    private final ElementsCollection castActorAnchors = $$x("//a[@data-testid='title-cast-item__actor']");

    public String getTitle() {
        return titleHeader.getText();
    }

    public int getTopCastCount() {
        return castActorAnchors.size();
    }

    public void clickThirdProfile() {
        castActorAnchors.get(2).shouldBe(Condition.visible).click();
    }

    public String getThirdProfileName() {
        return castActorAnchors.get(2).shouldBe(Condition.visible).getText();
    }
} 