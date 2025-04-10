package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.ComboBox;
import elements.IdInput;
import elements.Input;
import object.TestCase;

import static com.codeborne.selenide.Selenide.$x;

public class NewTestCaseModalWindow extends BasePage {

    private static final SelenideElement SAVE_TEST_CASE_BUTTON = $x("//button[@id='save-case']");
    private static final SelenideElement ADD_STEP_BUTTON = $x("//button[@type='button']//span[contains(text(), 'Add step')]");

    public ProjectPage addTestCase(TestCase testCase) {
        new IdInput("title").writeTextToInput(testCase.getTitleName());
        new ComboBox("Status").selectComboBoxOption(testCase.getStatus());
        new ComboBox("Severity").selectComboBoxOption(testCase.getSeverity());
        new ComboBox("Priority").selectComboBoxOption(testCase.getPriority());
        new ComboBox("Type").selectComboBoxOption(testCase.getType());
        new ComboBox("Layer").selectComboBoxOption(testCase.getLayer());
        new ComboBox("Is flaky").selectComboBoxOption(testCase.getIsFlaky());
        new ComboBox("Behavior").selectComboBoxOption(testCase.getBehavior());
        new ComboBox("Automation status").selectComboBoxOption(testCase.getAutomationStatus());
        new Button().click(ADD_STEP_BUTTON);
        new Input("Step Action").hoverOnElementAndRightSpace();
        new Input("Step Action").writeTextToInput(testCase.getStepAction());
        new Input("Data").hoverOnElementAndRightSpace();
        new Input("Data").writeTextToInput(testCase.getData());
        new Input("Expected result").writeTextToInput(testCase.getExpectedResult());
        new Button().click(SAVE_TEST_CASE_BUTTON);
        return new ProjectPage();
    }
}
