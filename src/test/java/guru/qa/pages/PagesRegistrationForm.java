package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public class PagesRegistrationForm {
    CalendarComponent calendar = new CalendarComponent();

    //locators - enter if it occurs often (for example)
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");

    String subject = "Arts";      // ????

    //actions
    public PagesRegistrationForm openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");     //hide footer
        executeJavaScript("$('#fixedban').remove()");  //hide banner

        return this;
    }

    public PagesRegistrationForm setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PagesRegistrationForm setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PagesRegistrationForm setUserEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public PagesRegistrationForm setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public PagesRegistrationForm setUserNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public PagesRegistrationForm setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }

    public PagesRegistrationForm setSubjects() {
        $("#subjectsInput").setValue(subject).pressEnter();   // ????

        return this;
    }

    public PagesRegistrationForm setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public PagesRegistrationForm setUploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }

    public PagesRegistrationForm setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }

    public PagesRegistrationForm setState(String state) {
        $("#react-select-3-input").setValue(state).pressEnter();

        return this;
    }

    public PagesRegistrationForm setCity(String city) {
        $("#react-select-4-input").setValue(city).pressEnter();

        return this;
    }

    public void clickSubmit() {
        $("#submit").click();
    }

    //asserts
    public PagesRegistrationForm checkForm(String value) {
        $("#example-modal-sizes-title-lg").shouldHave(text(value));

        return this;
    }

    public PagesRegistrationForm checkFormText(String value) {
        $(".modal-body").shouldHave(text(value));

        return this;
    }
}


