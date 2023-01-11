import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestRegistrationForm {
    File file = new File("src/test/resources/avatar.jpg");

    @Test
    void registrationForm(){
        String firstName = "Dmitrii";
        String lastName = "Sukhinin";
        String userEmail = "test@mail.ru";
        String gender = "Male";
        String userNumber = "1234567890";
        String month = "October";
        String year = "1997";
        String subjects = "Maths";
        String hobbies = "Sports";
        String currentAddress = "Aqtobe";
        String state = "NCR";
        String city = "Delhi";
        String dayOfBirth = "22 October,1997";
        String fileName = "avatar.jpg";
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").find(byText(month)).click();
        $(".react-datepicker__year-select").find(byText(year)).click();
        $(".react-datepicker__day--022").click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").find(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").find(byText(city)).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text(firstName +" "+ lastName), (text(userEmail)), (text(gender)),
                (text(userNumber)), (text(dayOfBirth)), (text(subjects)), (text(hobbies)), (text(fileName)),
                (text(currentAddress)), (text(state +" "+ city)));
    }
}

