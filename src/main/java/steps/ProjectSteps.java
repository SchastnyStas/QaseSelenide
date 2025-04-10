package steps;

import io.qameta.allure.Step;
import object.Project;

public class ProjectSteps extends BaseSteps {

    @Step("Create new project")
    public ProjectSteps createProject(Project project) {
        projectsListPage
                .openNewProjectModalWindow()
                .createNewProject(project)
                .waitForPageToLoad();
        return this;
    }

    @Step("Go to projects list")
    public ProjectSteps goToProjects() {
        projectPage.goToProjects()
                .waitToPageToLoad();
        return this;
    }

    @Step("Delete project")
    public void deleteProject() {
        projectsListPage
                .deleteProject();
    }
}
