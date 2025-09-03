import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

//private static final String REPOSITORY = "selenide/selenide";

public class AttachStep {
    @Test
    public void testLambdaAttach() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем браузер и не закрываем после завершения теста", () -> {
            Configuration.holdBrowserOpen = true;
            open("https://github.com");
            attachment("Source", webdriver().driver().source());
        });
    }

    @Test
    public void testAnnotatedAttach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebStep steps = new WebStep();

        steps.openMainPage();
        steps.takeScreenshot();
    }

}
