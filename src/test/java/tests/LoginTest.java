package tests;

import org.testng.annotations.Test;
import pages.ProjectsListPage;

public class LoginTest extends BaseTest{
    @Test
    public void successLogin(){
        loginSteps.login(EMAIL, PASSWORD, LOGIN_URL);
        projectsListPage.openNewProjectModalWindow();

    }
}
