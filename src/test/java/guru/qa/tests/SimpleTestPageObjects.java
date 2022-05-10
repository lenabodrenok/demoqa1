package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import guru.qa.helpers.Attach;
import guru.qa.pages.PagesRegistrationForm;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import static io.qameta.allure.Allure.step;

public class SimpleTestPageObjects {
    PagesRegistrationForm pagesRegistrationForm = new PagesRegistrationForm();

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            userNumber = faker.numerify("##########"),
            currentAddress = faker.address().streetAddress();

    String day = "30",
            month = "July",
            year = "1984",
            subject = "Arts",
            hobbies = "Sports",
            state = "NCR",
            picture = "photo.jpg",
            city = "Delhi";

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
}
    @Test
    @DisplayName("demoqa.com - Practice Form")
    void fillFormTest() {
        step("Fill registration form", () -> {
            pagesRegistrationForm.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobbies)
                .setUploadPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();
            });

        //asserts
        step("Verify form data", () -> {
            pagesRegistrationForm.checkForm("Thanks for submitting the form")
                .checkFormText(firstName)
                .checkFormText(lastName)
                .checkFormText(email)
                .checkFormText(gender)
                .checkFormText(userNumber)
                .checkFormText(day)
                .checkFormText(month)
                .checkFormText(year)
                .checkFormText(subject)
                .checkFormText(hobbies)
                .checkFormText(picture)
                .checkFormText(currentAddress)
                .checkFormText(state)
                .checkFormText(city);
            });
    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}