package io.github.qaguru.allure.Steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;



public class WebSteps {

    public final String REPOSITORY = "eroshenkoam/allure-examaple";
    private static final int NUMBER = 68;

    

  @Step ("Open main page")
    public void openMainPage() {
      open("https://github.com");
    }
@Step ("looking for {repositoy}")

    public void searchForRepository(String repository) {

    $(".header-search-input").click();
    $(".header-search-input").sendKeys(repository);
    $(".header-search-input").submit();




}

@Step ("open repository {repository}")

public void goToRepository(String repository) {
    $(linkText("eroshenkoam/allure-example")).click();
}


    @Step("open tab Issues")
    public void openIssuesTab() { {
        $(partialLinkText("Issues")).click();
        $(partialLinkText("Issues")).click();
    }


    }
@Step ("Checking  Issue with {number}")
    public void shouldSeeIssueWithNumber(int number) {
    $(withText("#"+number)).should(Condition.visible);

    }



}
