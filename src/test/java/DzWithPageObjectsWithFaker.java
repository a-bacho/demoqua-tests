import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

public class DzWithPageObjectsWithFaker extends TestBase {
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String address = faker.address().streetAddress();
    String email = faker.internet().emailAddress();
    String phone = faker.phoneNumber().cellPhone();
    //Date birth = faker.date().past(2020,12,12);
    @Test
    void dz() {
        registrationsPage.openPage();
        registrationsPage.typeFirstName(firstName)
                         .typeLastName(lastName)
                         .typeEmail(email)
                         .chooseGender("Male")
                         .phoneinput("0000000000")
                         .birthInput("12", "May", "2010")
                         .hobbiesCheckbox("Reading", "Sports")
                         .subjectsInput("science")
                         .pictureUpload()
                         .typeAddress(address)
                         .stateSelect("NCR","Noida");



        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));


    }
}