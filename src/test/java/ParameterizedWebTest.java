import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ParameterizedWebTest {

    static Stream<Arguments> commonSearchTestCsvSource() {
        return Stream.of(
                Arguments.of("static", " private static methods"),
                Arguments.of("testNG", "testing library")
        );
    }

    @MethodSource("commonSearchTestCsvSource")
    @ParameterizedTest
    void commonSearchTest(String testData, String expected) {
        Selenide.open("https://www.baeldung.com/");

        Selenide.$("a[href='#search']").click();
        Selenide.$("#search").setValue(testData);
        Selenide.$("button[type='submit']").click();

        Selenide.$("#main").shouldHave(Condition.text(expected));
    }


}