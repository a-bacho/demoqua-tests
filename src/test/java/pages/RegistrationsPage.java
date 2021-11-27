package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationsPage {

// locators & elements
    private final String FORM_TITLE ="Student Registration Form";
    private SelenideElement
        firstNameInput = $("#firstName"),
        lastNameInput = $("#lastName");

//actions
public void openPage() {
    open("https://demoqa.com/automation-practice-form");
}
    public void typeFirstName(String value) {
        $("#firstName").setValue("value");
}

    public void typeLastName(String value) {
        $("#lastName").setValue("value");
    }