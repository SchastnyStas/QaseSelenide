package tests;

import object.Project;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class ProjectTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();
    Random random = new Random();

    @Test
    public void successCreate() {

        Project project = Project.builder()
                .projectName("Web Application" + random.nextInt(5))
                .projectCode("WB" + random.nextInt(5))
                .description("Very Good Project!" + random.nextInt(5))
                .build();

        String projectName = project.getProjectName();

        projectSteps.createProject(project).goToProjects();
        softAssert.assertEquals(projectsListPage.getProjectInList(projectName), projectName);
        projectSteps.deleteProject();
        softAssert.assertTrue(projectsListPage.checkEmptyProjectsList());
        softAssert.assertAll();
    }
}


