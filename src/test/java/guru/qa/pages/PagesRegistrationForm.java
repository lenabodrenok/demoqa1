package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PagesRegistrationForm {
    //locators


    //actions
    public void openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");    //hide footer
        executeJavaScript("$('#fixedban').remove()");    //hide banner
    }
    public void setFirstName(String value) {
        $("#firstName").setValue(value);
    }
    public void setLastName(String value) {
        $("#lastName").setValue(value);
    }
    public void setUserEmail(String value) {
        $("#userEmail").setValue(value);
    }
    public void setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
    }
    public void setUserNumber(String value) {
        $("#userNumber").setValue(value);
    }
    public void setDateOfBirth() {
        $("#dateOfBirthInput").click();
    }
    public void setMonthOfBirth() {
        $(".react-datepicker__month-select").selectOption("July");
    }
    public void setYearOfBirth() {
        $(".react-datepicker__year-select").selectOption("1984");
    }
    public void setDayOfBirth() {
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
    }
    public void setSubjects() {
        $("#subjectsInput").setValue("Arts").pressEnter();
    }
    public void setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
    }
    public void setUploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
    }
    public void setCurrentAdress(String value) {
        $("#currentAddress").setValue(value);
    }
    public void setState() {
        $("#state").click();
    }
    public void setStateName(String value) {
        $("#stateCity-wrapper").$(byText(value)).click();
    }
    public void setCity() {
        $("#city").click();
    }
    public void setCityName(String value) {
        $("#stateCity-wrapper").$(byText(value)).click();
    }
    public void clickSubmit() {
        $("#submit").click();
    }

    //asserts
    public void checkForm(String value) {
        $("#example-modal-sizes-title-lg").shouldHave(text(value));
    }
    public void checkFormText(String value) {
        $(".modal-body").shouldHave(text(value));
    }
}


