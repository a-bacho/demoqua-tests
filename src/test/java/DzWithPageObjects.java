import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DzWithPageObjects extends TestBase {

    @Test
    void dz() {
        registrationsPage.openPage();
        registrationsPage.typeFirstName("Johny")
                        .typeLastName("Depp")
                        .typeEmail("johny@Depp.com")
                        .chooseGender("Male")
                        .phoneinput("0000000000")
                        .birthInput("12", "May", "2010")
                        .hobbiesCheckbox("Reading", "Sports")
                        .subjectsInput("science");



        $("#uploadPicture").uploadFile(new File("src/test/resources/img/peterthegreat.png"));
        $("#currentAddress").setValue("Main street");

        $("#state").click();

        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).scrollTo().click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));


    }
}