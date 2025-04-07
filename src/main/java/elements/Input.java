package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$x;

public class Input {

    private static final String INPUT_STEP_TEST_CASE_LOCATOR = "//*[contains(text(), '%s')]/parent::p/parent::div";
    private final String label;


    public Input(String label) {
        this.label = label;
    }

    public Input hoverOnElementAndRightSpace() {
        SelenideElement element = $x(String.format(INPUT_STEP_TEST_CASE_LOCATOR, label));
        element.scrollIntoView(true);
        element.hover();
        int elementWidth = element.getSize().getWidth();
        int elementHeight = element.getSize().getHeight();
        int offsetX = elementWidth + 50;
        int offsetY = elementHeight / 2;
        new Actions(WebDriverRunner.getWebDriver())
                .moveToElement(element, offsetX, offsetY)
                .click()
                .perform();
        return this;
    }

    public Input writeTextToInput(String text) {
        $x(String.format(INPUT_STEP_TEST_CASE_LOCATOR, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }
}

