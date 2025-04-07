package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.IdInput;
import object.Project;

import static com.codeborne.selenide.Selenide.$x;

public class NewProjectModalWindow extends BasePage {

    private static final SelenideElement CREATE_PROJECT_BUTTON = $x("//button[@type='submit']");

    public ProjectPage createNewProject(Project project) {
        new IdInput("project-name").writeTextToInput(project.getProjectName());
        new IdInput("project-code").writeTextToInput(project.getProjectCode());
        new IdInput("description-area").writeTextToInput(project.getDescription());
        new Button().click(CREATE_PROJECT_BUTTON);
        return new ProjectPage();
    }
}
