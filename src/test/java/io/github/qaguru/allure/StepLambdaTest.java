package io.github.qaguru.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepLambdaTest {
  public final String REPOSITORY = "eroshenkoam/allure-examaple";

    @Test

    public void testGithub() {
        System.setProperty("selenide.browser", "firefox");

        step("Открываем главную страницу", () -> {
                    open("https://github.com");
                });
        step("Ищем репозиторий" + REPOSITORY, () -> {


                    $(".header-search-input").click();
                    $(".header-search-input").sendKeys("eroshenkoam/allure-example");
                    $(".header-search-input").submit();
                });
        step("Переходим в репозиторий" + REPOSITORY, () -> {


                    $(linkText("eroshenkoam/allure-example")).click();
                });
       step("Открываем таб issues");
        $(partialLinkText("Issues")).click();
        $(withText("#68")).should(Condition.visible);


    }

}



