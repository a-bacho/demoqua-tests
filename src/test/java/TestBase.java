import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationsPage;

public class TestBase {
    RegistrationsPage registrationPage = new RegistrationsPage();

    @BeforeAll
    static void beforeAll() {Configuration.startMaximized = true;}

}
