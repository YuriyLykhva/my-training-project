package io.testomat.api.controllers;

import io.restassured.http.ContentType;
import io.testomat.api.dtos.LoginDto;

public class AuthController extends BaseController<AuthController> {
    public LoginDto loginUser(String login, String password) {
        return baseClient()
                .contentType(ContentType.URLENC)
                .formParams(
                        "email", "yu1.0710@yopmail.com",
                        "password", "ZSx5EN!FHFvrubH"
                )
                .post("/login")
                .as(LoginDto.class);

    }
}
