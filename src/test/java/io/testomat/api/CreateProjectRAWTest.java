package io.testomat.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CreateProjectRAWTest {
    @Test
    @DisplayName("Login user and create project")
    void loginUserAndCreateProject() {

        String projectName = "garden-grocery";

        var testomatSpecification = RestAssured.given()
                .baseUri("https://app.testomat.io")
                .log().all()
                .basePath("/api");

        String token = testomatSpecification
                .formParams(
                        "email", "yu1.0710@yopmail.com",
                        "password", "ZSx5EN!FHFvrubH"
                )
                .post("/login")//   це з документації
                .prettyPeek()
                .jsonPath()
                .getString("jwt");

 /*       testomatSpecification           ======================= цей метод не дозволений для testomat.io
                .header("Authorization", token)
                .formParams(
                        "project[lang]", "js",
                        "project[title]", new Faker().book().title(),
                        "commit", "Create")
                .post("/projects")
                .prettyPeek()
        ;

  */
        List<String> projectID = testomatSpecification
                .header("Authorization", token)
//                .get("/{projectName}/suites", projectName)
                .get("/projects")
                .jsonPath()
                .getList("data.id");

        System.out.println("All project names: ");
        for (String s : projectID) {
            System.out.println("  Project name: " + s);
        }

//        testomatSpecification
//                .get("/{projectName}/suites", projectID.get(9))
//                .prettyPrint();

    }

}