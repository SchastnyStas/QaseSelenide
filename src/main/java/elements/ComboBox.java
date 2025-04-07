package elements;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class ComboBox {
    private static final String COMBOBOX_XPATH = "//label[contains(text(), '%s')]/following-sibling::div[@role='combobox']";
    private static final String COMBOBOX_OPTION_XPATH = "//div[contains(@role, 'option') and contains(., '%s')]";

    String label;

    public ComboBox(String label) {
        this.label = label;
    }

    public void selectComboBoxOption(String option) {
        $x(String.format(COMBOBOX_XPATH, label)).click();
        $x(String.format(COMBOBOX_OPTION_XPATH, option)).shouldBe(Condition.visible).click();
    }

    public String getComboboxText(){
        return $x(String.format(COMBOBOX_XPATH, this.label)).getText();
    }
}
