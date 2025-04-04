package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.ComboBox;
import elements.IdInput;
import object.TestCase;

import static com.codeborne.selenide.Selenide.$x;

public class NewTestCaseModalWindow extends BasePage {

    private static final SelenideElement SAVE_TEST_CASE_BUTTON = $x("//span[text()='Save']");

    public ProjectPage addTestCase(TestCase testCase) {
        new IdInput("title").writeTextToInput(testCase.getTitleName());
        new ComboBox("Actual").selectComboBoxOption(testCase.getStatus());
        new ComboBox("Normal").selectComboBoxOption(testCase.getSeverity());
        new ComboBox("Not set").selectComboBoxOption(testCase.getPriority());
        new ComboBox("Other").selectComboBoxOption(testCase.getType());
        new ComboBox("Not set").selectComboBoxOption(testCase.getLayer());
        new ComboBox("No").selectComboBoxOption(testCase.getIsFlaky());
        new ComboBox("Not set").selectComboBoxOption(testCase.getBehavior());
        new ComboBox("Manual").selectComboBoxOption(testCase.getAutomationStatus());
        new Button().click(SAVE_TEST_CASE_BUTTON);
        return new ProjectPage();
    }
}
