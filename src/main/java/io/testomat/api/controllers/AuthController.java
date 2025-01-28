package io.testomat.api.controllers;

import io.restassured.http.ContentType;
import io.testomat.api.dtos.LoginDto;

public class AuthController extends BaseController<AuthController> {
    public LoginDto loginUser(String login, String password) {
        return baseClient()
                .contentType(ContentType.URLENC)
                .formParams(
                        "email", "ceivoyacabrau-4233@yopmail.com",
                        "password", "mag7q4s86@AXK5K"
                )
                .post("/login")
                .as(LoginDto.class);

    }
}
