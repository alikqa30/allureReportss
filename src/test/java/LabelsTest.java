import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

//private static final String REPOSITORY = "selenide/selenide";

public class LabelsTest {
    @Test
    @Feature("Issuea in repo")
    @Story("Create issue in repo")
    @Owner("Selenide")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://www.testing.github.com")
    @DisplayName("Create issuea")
    public void testStaticLabels() {
    }

    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Create issue in repo")
        );
        Allure.feature("");
        Allure.story("");
        Allure.label("owner", "");
        Allure.label("severity", "");
        Allure.link("");
    }

}
