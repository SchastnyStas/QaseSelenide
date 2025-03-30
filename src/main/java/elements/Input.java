package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Input {
    public String loginLocator = "//*[@name='%s']";
    String label;

    public Input(String label) {
        this.label = label;
    }

    public Input write(String text) {
        $x(String.format(loginLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input clean() {
        SelenideElement element = $x(String.format(loginLocator, label));
        element.click();
        element.clear();
        return this;
    }
}