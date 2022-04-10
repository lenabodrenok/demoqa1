package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import guru.qa.pages.PagesRegistrationForm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SimpleTestPageObjects {

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            userNumber = faker.numerify("##########"),
            currentAddress = faker.address().streetAddress();

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
}
    @Test
    void fillFormTest() {
        new PagesRegistrationForm().openPage();
        new PagesRegistrationForm().setFirstName(firstName);
        new PagesRegistrationForm().setLastName(lastName);
        new PagesRegistrationForm().setUserEmail(email);
        new PagesRegistrationForm().setGender(gender);
        new PagesRegistrationForm().setUserNumber(userNumber);
        new PagesRegistrationForm().setDateOfBirth();
        new PagesRegistrationForm().setMonthOfBirth();
        new PagesRegistrationForm().setYearOfBirth();
        new PagesRegistrationForm().setDayOfBirth();
        new PagesRegistrationForm().setSubjects();
        new PagesRegistrationForm().setHobbies("Sports");
        new PagesRegistrationForm().setUploadPicture("photo.jpg");
        new PagesRegistrationForm().setCurrentAdress(currentAddress);
        new PagesRegistrationForm().setState();
        new PagesRegistrationForm().setStateName("NCR");
        new PagesRegistrationForm().setCity();
        new PagesRegistrationForm().setCityName("Delhi");
        new PagesRegistrationForm().clickSubmit();


        //Asserts
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text(firstName),
                text(lastName),
                text(email),
                text(gender),
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