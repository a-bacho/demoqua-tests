package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Value;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationsPage {


    // locators & elements
    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadio = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            birthInput = $("#dateOfBirthInput"),
            hobbiesCheckbox = $("#hobbiesWrapper"),
            subjectsInput = $("#subjectsInput"),
            pictureUpload = $("#uploadPicture"),
            addressInput =  $("#currentAddress"),
            stateSelect = $("#stateCity-wrapper");


    //actions
    public static void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    public RegistrationsPage typeFirstName(String value) {

        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationsPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationsPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    //public RegistrationsPage typeGender(String value) {
    //  genderSelect.setValue(value);
    public RegistrationsPage chooseGender(String value) {
        genderRadio.find(byText(value)).click();
        return this;
    }

    public RegistrationsPage phoneinput(String value) {
        phoneInput.setValue(value);
        return this;
    }

    public RegistrationsPage birthInput(String day, String month, String year) {
        birthInput.click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $$(".react-datepicker__day").find(text(day)).click();

        return this;
    }

    public RegistrationsPage hobbiesCheckbox(String hobby1, String hobby2) {
        hobbiesCheckbox.findElement(byText(hobby1)).click();
        hobbiesCheckbox.findElement(byText(hobby2)).click();
        return this;
    }
    public RegistrationsPage subjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationsPage pictureUpload() {
        pictureUpload.scrollIntoView(true);
        pictureUpload.uploadFile(new File("src/test/resources/img/peterthegreat.png"));
        return this;
    }
    public RegistrationsPage typeAddress(String value) {
        addressInput.setValue(value);
        return this;
    }
    public RegistrationsPage stateSelect(String value1, String value2) {
        $("#state").click();
        stateSelect.$(byText(value1)).click();
        $("#city").click();
        stateSelect.$(byText(value2)).scrollTo().click();
        return this;
    }


}
