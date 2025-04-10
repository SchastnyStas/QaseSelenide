package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class IdInput {
    private static final String INPUT_XPATH = "//*[@id='%s']";

    String id;

    public IdInput(String id) {
        this.id = id;
    }

    public IdInput writeTextToInput(String text) {
        $x(String.format(INPUT_XPATH, id)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public IdInput clean() {
        SelenideElement element = $x(String.format(INPUT_XPATH, id));
        element.click();
        element.clear();
        return this;
    }
}
