package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
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

        //скрывает баннер и футер
        Selenide.executeJavaScript("document.querySelector(\"footer\").hidden = 'true';" +
                "document.querySelector(\"#fixedban\").hidden = 'true'");

        $("[id=firstName]").setValue("Alena");
        $("[id=lastName]").setValue("Arbuzova");
        $("[id=userEmail]").setValue("alena@arbuzova.com");
        $(byText("Female")).click();
        $("[id=userNumber]").setValue("1234567890");

        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption("February");
        $("[class=react-datepicker__year-select]").selectOption("1984");
        $(byText("15")).click();

        $("[id=subjectsInput]").sendKeys("a");
        $(byText("Arts")).click();

        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("[id=uploadPicture]").uploadFromClasspath("photo.jpg");

        $("[id=currentAddress]").setValue("Some street");
        $("[id=state]").click();
        $(byText("NCR")).click();
        $("[id=city]").click();
        $(byText("Delhi")).click();

        $("[id=submit]").click();
    }
}