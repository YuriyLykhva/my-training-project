package io.testomat.web.pages.pw;

import io.testomat.web.common.pw.LocatorActions;
import io.testomat.web.asserts.pw.TestSuitesPageAssertsPW;

import static io.testomat.web.common.pw.PlaywrightWrapper.$;
import static io.testomat.web.common.pw.conditions.Condition.visible;


public class TestSuitesPagePW extends BasePage {

    private LocatorActions firstTestSuite = $("[placeholder='First Suite']");
    protected String suitesListItem = ".list-group-wrapper .dragSortItem";

    public TestSuitesPagePW isLoaded() {
        firstTestSuite = $("[placeholder='First Suite']");
        firstTestSuite.shouldBe(visible);
        return this;
    }

    public TestSuitesPagePW closeReadmeModal() {
        $(".back").click();
        return this;
    }

    public TestSuitesPagePW fillFirstTestSuiteName(String targetTestSuite) {
        firstTestSuite
                .setValue(targetTestSuite)
                .press("Enter");
        return this;
    }


    public TestSuitesPageAssertsPW asserts() {
        return new TestSuitesPageAssertsPW();
    }
}
