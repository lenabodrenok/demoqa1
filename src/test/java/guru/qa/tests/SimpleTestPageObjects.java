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

    String day = "30",
            month = "July",
            year = "1984",
            subject = "Arts",      // ????
            hobbies = "Sports",
            state = "NCR",
            picture = "photo.jpg",
            city = "Delhi";

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
                .setDateOfBirth(day, month, year)
                .setSubjects()
                .setHobbies(hobbies)
                .setUploadPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        //asserts
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
    }
}