package steps;

import io.qameta.allure.Step;
import object.TestCase;

public class TestCaseSteps extends BaseSteps {

    @Step("Create a new test case")
    public TestCaseSteps createTestCase(TestCase testCase) {
        projectPage
                .openNewTestCaseModalWindow()
                .addTestCase(testCase);
        testCasePage.selectHiddenScrollbar();
        return this;
    }

    @Step("Delete test case")
    public void deleteTestCase(String testCaseName) {
        projectPage.openTestCase(testCaseName);
        testCasePage.deleteTestCase();
    }

    @Step("Close test case card")
    public void closeTestCaseCard() {
        testCasePage.closeTestCase();
    }
}