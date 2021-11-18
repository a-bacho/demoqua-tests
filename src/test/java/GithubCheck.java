import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubCheck {
    @BeforeAll
    public static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void githubCheck() {
        open("https://github.com/selenide/selenide");

        $("#wiki-tab").click();

        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $(byText("SoftAssertions")).shouldBe(visible).click();
        $("#wiki-body").shouldHave(text("Junit5"));

        //sleep(5000);
    }
}