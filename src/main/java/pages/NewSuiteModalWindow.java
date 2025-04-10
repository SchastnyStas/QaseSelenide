package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.IdInput;
import object.Suite;

import static com.codeborne.selenide.Selenide.$x;

public class NewSuiteModalWindow extends BasePage {

    private static final SelenideElement CREATE_SUITE_BUTTON = $x("//button[@type='submit']");

    public ProjectPage addSuite(Suite suite) {
        new IdInput("title").writeTextToInput(suite.getSuiteName());
        new Button().click(CREATE_SUITE_BUTTON);
        return new ProjectPage();
    }
}
