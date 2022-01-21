package io.github.qaguru.allure;

import com.codeborne.selenide.Condition;
import io.github.qaguru.allure.Steps.WebSteps;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepLambdaTest {
  public final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int NUMBER = 68;
    @Test

    public void testGithub() {



        step("Opening main page", () -> {
            open("https://github.com");
        });
        step("Searching for repository" + REPOSITORY, () -> {


            $(".header-search-input").click();
            $(".header-search-input").sendKeys("eroshenkoam/allure-example");
            $(".header-search-input").submit();
        });
        step("transfer to repository" + REPOSITORY, () -> {


            $(linkText("eroshenkoam/allure-example")).click();
        });
        step("opening tab issue", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Checking name Issue in repository with number" + NUMBER, () -> {
            $(withText("#" + NUMBER)).should(Condition.visible);
        });
    }

    @Test
    public void annotatedStepsTest() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(NUMBER);

    }

}




