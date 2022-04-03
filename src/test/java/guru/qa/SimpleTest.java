package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
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

        String firstname = "Alena";
        String lastname = "Arbuzova";
        String email = "alena@arbuzova.com";
        String usernumber = "1234567890";
        String currentaddress = "Some street";

        open("/automation-practice-form");

        //скрывает баннер и футер
        Selenide.executeJavaScript("document.querySelector(\"footer\").hidden = 'true';" +
                "document.querySelector(\"#fixedban\").hidden = 'true'");

        $("[id=firstName]").setValue(firstname);
        $("[id=lastName]").setValue(lastname);

        $("[id=userEmail]").setValue(email);
        $(byText("Female")).click();
        $("[id=userNumber]").setValue(usernumber);

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

        $("[id=currentAddress]").setValue(currentaddress);
        $("[id=state]").click();
        $(byText("NCR")).click();
        $("[id=city]").click();
        $(byText("Delhi")).click();

        $("[id=submit]").click();

        //проверка
        $("[class=modal-body]").shouldHave(text(firstname),
                text(lastname),
                text(email),
                text("Female"),
                text(usernumber),
                text("15"),
                text("February"),
                text("1984"),
                text("Arts"),
                text("Sports"),
                text("Reading"),
                text("Music"),
                text("photo.jpg"),
                text(currentaddress),
                text("NCR"),
                text("Delhi"));
    }
}