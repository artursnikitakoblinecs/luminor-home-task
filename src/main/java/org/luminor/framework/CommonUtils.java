package org.luminor.framework;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Long.parseLong;

public class CommonUtils {

    static final Properties properties = new Properties();

    @BeforeMethod
    @Step("Set up browser driver")
    public void setUp() {
        readConfig();
        Configuration.browser = properties.getProperty("browser.browser");
        Configuration.headless = parseBoolean(properties.getProperty("browser.headless"));
        Configuration.timeout = parseLong(properties.getProperty("browser.timeout"));
        Configuration.browserSize = properties.getProperty("browser.size");

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @AfterMethod
    @Step("Save screenshot and close browser driver")
    public void teardown() {
        screenshot("Screenshot", Selenide.screenshot(OutputType.BYTES));
        closeWebDriver();
    }

    @Attachment(value = "{name}", type = "image/png")
    public byte[] screenshot(String name, byte[] screenshot) {
        return screenshot;
    }

    private static void readConfig() {
        try (InputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}