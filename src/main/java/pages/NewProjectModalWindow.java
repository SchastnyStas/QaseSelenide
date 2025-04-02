package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.IdInput;
import object.Project;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class NewProjectModalWindow extends BasePage {

    private static final SelenideElement CREATE_PROJECT_BUTTON = $x("//span[@class='B9YsTi' and text()='Create project']");

    public ProjectPage createNewProject(Project project) {
        new IdInput("project-name").writeTextToInput(project.getProjectName());
        new IdInput("project-code").writeTextToInput(project.getProjectCode());
        new IdInput("description-area").writeTextToInput(project.getDescription());
        new Button().click(CREATE_PROJECT_BUTTON);
        return new ProjectPage();
    }

//      public ProjectsListPage clickOnProjectList() {
//        return new ProjectsListPage().open("user");
//    }
}
