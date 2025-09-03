import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());


        Configuration.holdBrowserOpen = true;
        open("https://github.com");
        $(".search-input-container").click();
        $(".search-input-container").click();
        $("#query-builder-test").setValue("selenide").pressEnter();

        $(By.linkText("selenide/selenide")).click();
        $("#issues-tab").click();
    }

}
