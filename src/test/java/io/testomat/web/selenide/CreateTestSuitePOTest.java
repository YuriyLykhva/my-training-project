package io.testomat.web.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.github.javafaker.Faker;
import io.testomat.web.asserts.TestSuitesPageAsserts;
import io.testomat.web.pages.LoginPage;
import io.testomat.web.pages.ProjectsPage;
import io.testomat.web.pages.TestSuitesPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.*;
import static io.testomat.web.pages.LoginPage.CredsWithRoles.*;

@ExtendWith(TextReportExtension.class)
public class CreateTestSuitePOTest {

    Faker faker = new Faker();

    private final LoginPage loginPage = new LoginPage();

    static {
        Configuration.baseUrl = "https://app.testomat.io";
    }

    @Test
    @DisplayName("Should Be Possible To Create Test Suite For New Project")
    void shouldBePossibleToCreateTestSuiteForNewProject() {

        open("/users/sign_in");
        loginPage
                .isLoaded()
//                .loginUser("mmax68955@gmail.com", "d#6m@$MnPzEyg7Z");
//                .loginUser("yu1.0710@yopmail.com", "ZSx5EN!FHFvrubH");
                .loginUser(YUKO);

        new ProjectsPage()
                .isLoaded()
                .clickOnNewProjectButton()
                .fillProjectTitle(faker.commerce().department())
                .submitProjectCreation();

        String targetTestSuite = faker.commerce().productName();

        new TestSuitesPage()
                .isLoaded()
                .closeReadmeModal()
                .fillFirstTestSuiteName(targetTestSuite)

                //todo just as an option:
                .asserts()
                .listShouldHaveSize(1)
                .firstTestSuiteInListShouldHaveText(targetTestSuite);


        //just for example
        new TestSuitesPageAsserts()
                .listShouldHaveSize(1)
                .firstTestSuiteInListShouldHaveText(targetTestSuite);

    }

}
