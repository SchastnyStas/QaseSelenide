package steps;

import io.qameta.allure.Step;
import object.Suite;

public class SuiteSteps extends BaseSteps {

    @Step("Create new suite")
    public SuiteSteps createSuite(Suite suite) {
        projectPage
                .openNewSuiteModalWindow()
                .addSuite(suite);
        return this;
    }

    @Step("Delete suite")
    public void deleteSuite() {
        projectPage
                .deleteSuite();
    }
}
