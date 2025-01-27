package io.testomat.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.testomat.web.asserts.TestSuitesPageAsserts;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TestSuitesPage extends BasePage {

    String firstTestSuiteSelector = "[placeholder='First Suite']";

    private SelenideElement firstTestSuite;

    public TestSuitesPage isLoaded() {
        firstTestSuite = $("[placeholder='First Suite']");
        firstTestSuite.shouldBe(visible, Duration.ofSeconds(30));
        return this;
    }

    public TestSuitesPage closeReadmeModal() {
        $(".back").click();
        return this;
    }

    public TestSuitesPage fillFirstTestSuiteName(String targetTestSuite) {
        firstTestSuite
                .setValue(targetTestSuite)
                .pressEnter();
        return this;
    }


    public TestSuitesPageAsserts asserts() {
        return new TestSuitesPageAsserts();
    }
}
