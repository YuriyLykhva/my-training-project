package io.testomat.web.asserts;

import io.testomat.web.pages.TestSuitesPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TestSuitesPageAsserts extends TestSuitesPage {

    public TestSuitesPageAsserts listShouldHaveSize(int expectedSize) {
        $$(".dragSortItem").shouldHave(size(expectedSize));
        return this;
    }

    public TestSuitesPageAsserts firstTestSuiteInListShouldHaveText(String expectedTestSuiteTitle) {
        $(".dragSortList").shouldHave(text(expectedTestSuiteTitle));
        return this;
    }
}
