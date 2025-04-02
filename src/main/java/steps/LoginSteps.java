package steps;

import io.qameta.allure.Step;
import pages.LoginPage;
import pages.ProjectsListPage;


public class LoginSteps extends BaseSteps {


    @Step("Login by user: {email}")
    public void login(String email, String password, String url) {
        loginPage
                .openLoginPage(url)
                .login(email, password)
                .waitToPageToLoad();
    }
}
