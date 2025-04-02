package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends BasePage {
    private static final SelenideElement NEW_TEST_BUTTON = $(By.id("create-case-button"));
    private static final SelenideElement PROJECTS_LIST_BUTTON = $(By.xpath("//a[@href='/projects']"));
    private static final SelenideElement CREATE_SUITE_BUTTON = $(By.id("create-suite-button"));
    private static final SelenideElement DELETE_SUITE_BUTTON = $x("//button[contains(@aria-label, 'Delete suite')]");
    private static final SelenideElement CONFIRMATION_DELETE_SUITE_BUTTON = $x("//button[@type='submit" +
            "']//span[contains(text(), 'Delete')]");

    private static final SelenideElement NO_SUITE_MESSAGE = $x("//span[text()='Create new suite']");

     private static final String LOCATOR = "//h3[text()='%s']";


    public ProjectPage waitForPageToLoad() {
        NEW_TEST_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    public ProjectsListPage goToProjects() {
        new Button().click(PROJECTS_LIST_BUTTON);
        return new ProjectsListPage().waitToPageToLoad();
    }

    public NewSuiteModalWindow openNewSuiteModalWindow() {
        new Button().click(CREATE_SUITE_BUTTON);
        return new NewSuiteModalWindow();
    }

    public String getSuiteNameText(String suiteName){
         SelenideElement locatorText = $x(String.format(LOCATOR,
                       suiteName));
         return locatorText.getText();
    }

    public ProjectPage deleteSuite() {
        new Button().click(DELETE_SUITE_BUTTON);
        new Button().click(CONFIRMATION_DELETE_SUITE_BUTTON);
        return new ProjectPage();
    }


    public boolean checkEmptySuiteList() {
        NO_SUITE_MESSAGE.shouldBe(Condition.visible);
        return NO_SUITE_MESSAGE.isDisplayed();
    }
}
