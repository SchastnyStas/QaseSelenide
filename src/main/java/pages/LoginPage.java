package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Input;

import java.awt.*;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {

    private static final SelenideElement SIGN_IN = $x("//*[@type='submit']");

    public LoginPage() {
    }

       public LoginPage openLogin(String url) {
        open(url);
        return this;
    }


    private LoginPage fillLoginForm(String email, String password) {
        new Input("email").write(email);
        new Input("password").write(password);
        new Button().click(SIGN_IN);
        return this;
    }
    public static ProjectsListPage login(String email, String password) {
        fillLoginForm(email, password);
        return new ProjectsListPage();
    }
}