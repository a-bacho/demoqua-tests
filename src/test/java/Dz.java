import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        //$(byText("Male")).click();
        $("[class='custom-control custom-radio custom-control-inline'] label").click();
        $("[class='custom-control custom-checkbox custom-control-inline'] label").click();
        $("[id=firstName]").setValue("Johny");
        $("[id=lastName]").setValue("Depp");
        $("[id=userNumber]").setValue("+799999999");
        $("[id=subjectsContainer]").setValue("123");
        //$("").setValue("");
        $("#currentAddress").setValue("Main street");
        $("[class=css-1hwfws3]").setValue("NCR");


        $("#dateOfBirthInput").click();
        //$(byText("Male")).click();

        $("#uploadPicture").click();
        //$("").setValue("");

    }
}
