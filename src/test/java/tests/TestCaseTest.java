package tests;

import object.Project;
import object.TestCase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class TestCaseTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();
    Random random = new Random();

    @Test
    public void testCaseCreate() {
        loginSteps.login(EMAIL, PASSWORD, LOGIN_URL);

        Project project = Project.builder()
                .projectName("Web Application" + random.nextInt(5))
                .projectCode("WB" + random.nextInt(5))
                .description("Very Good Project!" + random.nextInt(5))
                .build();
        TestCase testCase = TestCase.builder()
                .titleName("Authorization" + random.nextInt(5))
                .status("Draft")
                .severity("Major")
                .priority("Low")
                .type("Smoke")
                .layer("API")
                .isFlaky("Yes")
                .behavior("Positive")
                .automationStatus("Automated")
                .build();

        String testCaseTitle = testCase.getTitleName();

        projectSteps.createProject(project);
        testCaseSteps.createTestCase(testCase);
        softAssert.assertEquals(projectPage.getTestCaseTitleText(), testCaseTitle);
        softAssert.assertEquals(testCase.getStatus(), "Draft", "Status mismatch");
        softAssert.assertEquals(testCase.getSeverity(), "Major", "Severity mismatch");
        softAssert.assertEquals(testCase.getPriority(), "Low", "Priority mismatch");
        softAssert.assertEquals(testCase.getType(), "Smoke", "Type mismatch");
        softAssert.assertEquals(testCase.getLayer(), "API", "Layer mismatch");
        softAssert.assertEquals(testCase.getIsFlaky(), "Yes", "IsFlaky mismatch");
        softAssert.assertEquals(testCase.getBehavior(), "Positive", "Behavior mismatch");
        softAssert.assertEquals(testCase.getAutomationStatus(), "Automated", "AutomationStatus mismatch");
        testCaseSteps.deleteTestCase();
        softAssert.assertTrue(projectPage.checkEmptySuiteList());
        projectSteps.goToProjects();
        projectSteps.deleteProject();
        softAssert.assertAll();
    }
}
