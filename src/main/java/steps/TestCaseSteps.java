package steps;

import io.qameta.allure.Step;
import object.TestCase;

public class TestCaseSteps extends BaseSteps {

    @Step("Create new test case")
    public TestCaseSteps createTestCase(TestCase testCase) {
        projectPage
                .openNewTestCaseModalWindow()
                .addTestCase(testCase);
        testCasePage.selectHiddenScrollbar();
        return this;
    }

    @Step("Delete test case")
    public void deleteTestCase() {
        testCasePage
                .deleteTestCase();
    }
}