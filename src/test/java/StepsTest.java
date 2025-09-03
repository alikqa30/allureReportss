import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

//private static final String REPOSITORY = "selenide/selenide";

public class StepsTest {
    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем браузер и не закрываем после завершения теста", () -> {
            Configuration.holdBrowserOpen = true;
            open("https://github.com");
        });

        step("Ищем репозиторий на главной странице", () -> {
            $(".search-input-container").click();
            $(".search-input-container").click();
            $("#query-builder-test").setValue("selenide").pressEnter();
        });

        step("Кликаем по ссылке", () -> {
            $(By.linkText("selenide/selenide")).click();
        });

        step("Переходим во вкладку", () -> {
            $("#issues-tab").click();

        });
    }

    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebStep steps = new WebStep();

        steps.openMainPage();
        steps.searchForRepo();
        steps.clikcOnRepo();
        steps.openIssueTab();
    }

}
