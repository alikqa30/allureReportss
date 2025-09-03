import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebStep {

    @Step("Открываем браузер и не закрываем после завершения теста")
    public void openMainPage() {
        Configuration.holdBrowserOpen = true;
        open("https://github.com");

    }

    @Step("Ищем репозиторий на главной странице")
    public void searchForRepo() {
        $(".search-input-container").click();
        $(".search-input-container").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
    }

    @Step("Кликаем по ссылке")
    public void clikcOnRepo() {
        $(By.linkText("selenide/selenide")).click();

    }

    @Step("Переходим во вкладку")
    public void openIssueTab() {
        $("#issues-tab").click();
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
