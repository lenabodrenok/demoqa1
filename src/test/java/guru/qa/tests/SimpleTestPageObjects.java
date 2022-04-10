package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import guru.qa.pages.PagesRegistrationForm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class SimpleTestPageObjects {
    PagesRegistrationForm pagesRegistrationForm = new PagesRegistrationForm();

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
        pagesRegistrationForm.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth("30", "July", "1984")
                .setSubjects()
                .setHobbies("Sports")
                .setUploadPicture("photo.jpg")
                .setCurrentAdress(currentAddress)
                .setState()
                .setStateName("NCR")
                .setCity()
                .setCityName("Delhi")
                .clickSubmit();

        //asserts
        pagesRegistrationForm.checkForm("Thanks for submitting the form")
                .checkFormText(firstName)
                .checkFormText(lastName)
                .checkFormText(email)
                .checkFormText(gender)
                .checkFormText(userNumber)
                .checkFormText("30")
                .checkFormText("July")
                .checkFormText("Arts")
                .checkFormText("Sports")
                .checkFormText("photo.jpg")
                .checkFormText(currentAddress)
                .checkFormText("NCR")
                .checkFormText("Delhi");
    }
}