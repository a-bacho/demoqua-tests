package io.github.qaguru.allure.Steps;

import com.sun.jmx.mbeanserver.Repository;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
  @Step ("Открываем главную страницу")
    public void openMainpage() {
      open("https://github.com");
    }
@Step ("Ищем репозиторий {repositoy}")

    public void searchForRepository(String repository) {

    $(".header-search-input").click();
    $(".header-search-input").sendKeys(repository);
    $(".header-search-input").submit();




}

@Step ("Переходим в репозиторий {repositoy}")
public void goToRepository(String repository) {
    $(linkText("eroshenkoam/allure-example")).click();
}

@Step ("Открываем таб issues")
    //public void open IssueTab(){



    }
@Step ()
    public void shouldSeeIssueWithNumber() {


    }



}
