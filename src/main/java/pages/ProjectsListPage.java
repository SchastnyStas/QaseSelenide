package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;

import static com.codeborne.selenide.Selenide.$x;


public class ProjectsListPage extends BasePage {

    private static final SelenideElement CREATE_NEW_PROJECT = $x("//*[text()='Create new project']");
    private static final String GET_PROJECT_NAME = "//*[contains(text(), '%s')]";
    private static final SelenideElement REMOVE_PROJECT_BUTTON = $x("//*[@data-testid='remove']");
    private static final SelenideElement NO_PROJECTS_MESSAGE = $x("//div[text()='Looks like you don’t have any projects yet.']");
    private static final SelenideElement KEBAB_MENU_BUTTON = $x("//button[contains(@aria-label, 'Open action menu')]");
    private static final SelenideElement DELETE_PROJECT_BUTTON = $x("//button[@type='button']//span[contains(text(), 'Delete project')]");

    public ProjectsListPage waitToPageToLoad() {
        CREATE_NEW_PROJECT.shouldBe(Condition.visible);
        return this;
    }

    public NewProjectModalWindow openNewProjectModalWindow() {
        CREATE_NEW_PROJECT.click();
        return new NewProjectModalWindow();
    }

    public String getProjectInList(String projectName) {
        SelenideElement projectElement = $x(String.format(GET_PROJECT_NAME,
                projectName));
        return projectElement.getText();
    }

    public boolean checkEmptyProjectsList() {
        NO_PROJECTS_MESSAGE.shouldBe(Condition.visible);
        return NO_PROJECTS_MESSAGE.isDisplayed();
    }

    public ProjectsListPage deleteProject() {
        new Button().click(KEBAB_MENU_BUTTON);
        new Button().click(REMOVE_PROJECT_BUTTON);
        new Button().click(DELETE_PROJECT_BUTTON);
        return new ProjectsListPage();
    }

}
