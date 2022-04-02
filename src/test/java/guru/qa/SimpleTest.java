package guru.qa;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SimpleTest {
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
}

    @Test
    void fillFormTest() {

        open("/automation-practice-form");

        $("[id=firstName]").setValue("Alena");
        $("[id=lastName]").setValue("Arbuzova");
        $("[id=userEmail]").setValue("alena@arbuzova.com");
        $(byText("Female")).click();
        $("[id=userNumber]").setValue("1234567890");
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("[id=subjectsInput]").sendKeys("a");
        $(byText("Arts")).click();
        $("[id=currentAddress]").setValue("Some street");

    }
}