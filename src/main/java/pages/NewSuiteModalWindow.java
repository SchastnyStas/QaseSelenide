package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.IdInput;
import object.Suite;

import static com.codeborne.selenide.Selenide.$x;

public class NewSuiteModalWindow extends BasePage {

    private static final SelenideElement CREATE_SUITE_BUTTON = $x("//span[text()='Create']");

    public ProjectPage addSuite(Suite suite) {
        new IdInput("title").writeTextToInput(suite.getSuiteName());
        // new IdInput("description").writeTextToInput(suite.getDescription());
        //  new IdInput("preconditions").writeTextToInput(suite.getPreconditions());
        new Button().click(CREATE_SUITE_BUTTON);

        return new ProjectPage();
    }
//    public SuitePage suitePage(){
//        return new SuitePage();
//    }
}
