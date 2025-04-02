package steps;

import pages.LoginPage;
import pages.ProjectPage;
import pages.ProjectsListPage;
import pages.SuitePage;

public class BaseSteps {
    protected ProjectPage projectPage;
    protected ProjectsListPage projectsListPage;
    protected LoginPage loginPage;
    protected SuitePage suitePage;

    public BaseSteps() {
        this.projectsListPage = new ProjectsListPage();
        this.projectPage = new ProjectPage();
        this.loginPage = new LoginPage();
        this.suitePage = new SuitePage();
    }
}