package io.testomat.web.pages.pw;

import io.testomat.web.common.pw.conditions.Condition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

public class LoginPagePW extends BasePage {

    public LoginPagePW isLoaded() {
        f("h2").shouldHave(Condition.text("Sign in"));
        return this;
    }

    public void loginUser(String mail, String password) {
        fillEmail(mail);
        fillPassword(password);
        submitLogin();
    }

    public void loginUser(io.testomat.web.pages.LoginPage.CredsWithRoles targetUser) {
        fillEmail(targetUser.mail);
        fillPassword(targetUser.password);
        submitLogin();
    }

    public LoginPagePW submitLogin() {
        f("[name='commit']").click();
        return this;
    }

    public LoginPagePW fillPassword(String password) {
        f("#user_password").setValue(password);
        return this;
    }

    public LoginPagePW fillEmail(String mail) {
        f("#user_email").setValue(mail);
        return this;
    }

    @Data
    @AllArgsConstructor
    public static class Creds {
        public String mail;
        public String password;
    }

    @AllArgsConstructor
    public enum CredsWithRoles {

        MANAGER("mmax68955@gmail.com", "d#6m@$MnPzEyg7Z"),
        YUKO("yu1.0710@yopmail.com", "ZSx5EN!FHFvrubH");

        private final String mail;
        private final String password;

    }

    //just for example
    @AllArgsConstructor
    @Getter
    public enum CredsWithRolesAnother {

        MANAGER(new io.testomat.web.pages.LoginPage.Creds("mmax68955@gmail.com", "d#6m@$MnPzEyg7Z"));

        private final io.testomat.web.pages.LoginPage.Creds creds;

    }
}
