package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.ComboBox;
import object.TestCase;

import static com.codeborne.selenide.Selenide.$x;

public class TestCasePage extends BasePage {
    private static final SelenideElement HIDDEN_SCROLLBAR_BUTTON = $x("//button[contains" +
            "(text(), 'Properties')]");
    private static final SelenideElement DELETE_TEST_CASE_BUTTON = $x("//button[contains(@aria-label, 'Delete')]");
    private static final SelenideElement CONFIRMATION_DELETE_TEST_CASE_BUTTON = $x("//span[contains(text(), 'Delete')]");
    private static final SelenideElement CLOSE_TEST_CASE = $x("//button[@aria-label='Close']");
    private static final SelenideElement GET_TEST_CASE_NAME_VISIBLE = $x("//div[@id='suitecases" +
            "-container" +
            "']//h1//span");

    public TestCasePage selectHiddenScrollbar() {
        new Button().click(HIDDEN_SCROLLBAR_BUTTON);
        return this;
    }

    public TestCasePage deleteTestCase() {
        new Button().click(DELETE_TEST_CASE_BUTTON);
        new Button().click(CONFIRMATION_DELETE_TEST_CASE_BUTTON);
        return this;
    }

    public String assertComboBoxOption(String label) {
        return new ComboBox(label).getComboboxText();
    }

    public String getTestCaseTitleText() {
        return GET_TEST_CASE_NAME_VISIBLE.getText();
    }

    public ProjectPage closeTestCase() {
        new Button().click(CLOSE_TEST_CASE);
        return new ProjectPage();
    }
}
