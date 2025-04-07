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
                .stepAction("Go" + random.nextInt(5))
                .data("Good task" + random.nextInt(5))
                .expectedResult("You win!")
                .build();

        String testCaseTitle = testCase.getTitleName();

        projectSteps.createProject(project);
        testCaseSteps.createTestCase(testCase);

        softAssert.assertEquals(testCasePage.assertComboBoxOption("Status"), "Draft");
        softAssert.assertEquals(testCasePage.assertComboBoxOption("Severity"), "Major");
        softAssert.assertEquals(testCasePage.assertComboBoxOption("Priority"), "Low");
        softAssert.assertEquals(testCasePage.assertComboBoxOption("Type"), "Smoke");
        softAssert.assertEquals(testCasePage.assertComboBoxOption("Layer"), "API");
        softAssert.assertEquals(testCasePage.assertComboBoxOption("Is flaky"), "Yes");
        softAssert.assertEquals(testCasePage.assertComboBoxOption("Behavior"), "Positive");
        softAssert.assertEquals(testCasePage.assertComboBoxOption("Automation status"),
                "Automated");
        softAssert.assertEquals(testCasePage.getTestCaseTitleText(),
                testCaseTitle);
        testCaseSteps.closeTestCaseCard();
        softAssert.assertEquals(projectPage.checkVisibilityTestCase(testCaseTitle), testCaseTitle);

        testCaseSteps.deleteTestCase(testCaseTitle);
        projectSteps.goToProjects();
        projectSteps.deleteProject();
        softAssert.assertAll();
    }
}
