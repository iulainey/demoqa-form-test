import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    @BeforeAll
    static void beforeALL(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Alexov");
        $("#userEmail").setValue("alex@al.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#submit").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1978");
        $(".react-datepicker__day--027").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("C:/Users/helen/Desktop/some/12.jpg"));
        $("#currentAddress").setValue("Some street 1");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Gurgaon").pressEnter();
        $("#submit").click();
        $x("//td[contains(text(),'Student Name')]/../td[2]").shouldHave(text("Alex Alexov"));
        $x("//td[contains(text(),'Student Email')]/../td[2]").shouldHave(text("alex@al.com"));
        $x("//td[contains(text(),'Gender')]/../td[2]").shouldHave(text("Other"));
        $x("//td[contains(text(),'Mobile')]/../td[2]").shouldHave(text("1234567890"));
        $x("//td[contains(text(),'Date of Birth')]/../td[2]").shouldHave(text("02 October,2009"));
        $x("//td[contains(text(),'Subjects')]/../td[2]").shouldHave(text("English, Math, Arts"));
        $x("//td[contains(text(),'Hobbies')]/../td[2]").shouldHave(text("Music"));
        $x("//td[contains(text(),'Picture')]/../td[2]").shouldHave(text("picture.png"));
        $x("//td[contains(text(),'Address')]/../td[2]").shouldHave(text("Some street 1"));
        $x("//td[contains(text(),'State and City')]/../td[2]").shouldHave(text("NCR Gurgaon"));
    }
}
