package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SimpleTest {
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
}
    @Test
    void fillFormTest() {

        String firstName = "Alena",
               lastName = "Arbuzova",
               email = "alena@arbuzova.com",
               userNumber = "1234567890",
               currentAddress = "Some street";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        //hide banner & footer
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1984");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("photo.jpg");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        //Asserts
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text(firstName),
                text(lastName),
                text(email),
                text("Female"),
                text(userNumber),
                text("30"),
                text("July"),
                text("1984"),
                text("Arts"),
                text("Sports"),
                text("photo.jpg"),
                text(currentAddress),
                text("NCR"),
                text("Delhi"));
    }
}