package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TestCasePage extends BasePage {
    private static final SelenideElement HIDDEN_SCROLLBAR_BUTTON = $(By.xpath("//button[contains" +
            "(text(), 'Properties')]"));
    private static final SelenideElement DELETE_TEST_CASE_BUTTON = $x("//button[contains(@aria-label, 'Delete')]");
    private static final SelenideElement CONFIRMATION_DELETE_TEST_CASE_BUTTON = $x("//span[contains(text(), 'Delete')]");

    public TestCasePage selectHiddenScrollbar() {
        new Button().click(HIDDEN_SCROLLBAR_BUTTON);
        return this;
    }

    public TestCasePage deleteTestCase() {
        new Button().click(DELETE_TEST_CASE_BUTTON);
        new Button().click(CONFIRMATION_DELETE_TEST_CASE_BUTTON);
        return new TestCasePage();
    }
}
