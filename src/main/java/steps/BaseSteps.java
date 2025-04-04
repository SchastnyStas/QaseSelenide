package steps;

import pages.LoginPage;
import pages.ProjectPage;
import pages.ProjectsListPage;
import pages.TestCasePage;

public class BaseSteps {
    protected ProjectPage projectPage;
    protected ProjectsListPage projectsListPage;
    protected LoginPage loginPage;
    protected TestCasePage testCasePage;

    public BaseSteps() {
        this.projectsListPage = new ProjectsListPage();
        this.projectPage = new ProjectPage();
        this.loginPage = new LoginPage();
        this.testCasePage = new TestCasePage();

    }
}