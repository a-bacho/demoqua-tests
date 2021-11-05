import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Dz {
@BeforeAll
static void beforeAll() {
    Configuration.startMaximized = true;
}
    @Test
    void dz() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Johny");
        $("#lastName").setValue("Depp");
        $("#userEmail").setValue("johny@depp.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("2222222222222");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("2010");

        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#subjectsInput").setValue("science").pressEnter();
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
