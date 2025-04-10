package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NameInput {
    private static final String INPUT_XPATH = "//*[@name='%s']";

    String name;

    public NameInput(String name) {
        this.name = name;
    }

    public NameInput writeTextToInput(String text) {
        $x(String.format(INPUT_XPATH, name)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public NameInput clean() {
        SelenideElement element = $x(String.format(INPUT_XPATH, name));
        element.click();
        element.clear();
        return this;
    }
}