package lesson2_11;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

@Epic("MTS Online Payment Tests")
@Feature("Проверка функциональности онлайн пополнения")
public class MtsTest {
    private WebDriver driver;
    private PageObjectsMtsBy mtsPage;

    @BeforeEach
    @Step("Настройка браузера и открытие сайта MTS")
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.mts.by");
        closeCookieBanner();
        mtsPage = new PageObjectsMtsBy(driver);

        // Добавляем скриншот в отчет
        Allure.addAttachment("Страница открыта",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Test
    @DisplayName("Проверка заголовка блока онлайн пополнения")
    @Description("Тест проверяет корректность отображения заголовка блока 'Онлайн пополнение без комиссии'")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Пользователь видит заголовок блока оплаты")
    void testBlockTitle() {
        mtsPage.checkBlockTitle();
    }

    @Test
    @DisplayName("Проверка логотипов платежных систем")
    @Description("Тест проверяет наличие и отображение логотипов Visa, Mastercard и Belkart")
    @Severity(SeverityLevel.NORMAL)
    @Story("Пользователь видит поддерживаемые платежные системы")
    void testPaymentSystemsLogos() {
        mtsPage.checkPaymentSystemsLogos();
    }

    @Test
    @DisplayName("Проверка ссылки 'Подробнее о сервисе'")
    @Description("Тест проверяет работоспособность и корректность ссылки на подробную информацию")
    @Severity(SeverityLevel.MINOR)
    @Story("Пользователь может перейти к подробному описанию сервиса")
    void testDetailsLink() {
        mtsPage.checkDetailsLink();
    }

    @Test
    @DisplayName("Проверка функциональности формы оплаты")
    @Description("Тест проверяет базовую функциональность формы оплаты услуг связи")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Пользователь может заполнить форму и отправить данные")
    void testPaymentFormFunctionality() {
        mtsPage.testPaymentFormFunctionality();
    }

    @Test
    @DisplayName("Проверка плейсхолдеров для всех услуг")
    @Description("Тест проверяет корректность плейсхолдеров для всех вариантов оплаты")
    @Severity(SeverityLevel.NORMAL)
    @Story("Пользователь видит подсказки в полях ввода для разных услуг")
    void testAllServicesPlaceholders() {
        mtsPage.checkAllServicesPlaceholders();
    }

    @Test
    @DisplayName("Проверка модального окна оплаты услуг связи")
    @Description("Тест проверяет корректность отображения модального окна с платежной формой")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Пользователь видит корректную информацию в платежной форме")
    void testConnectionPaymentWithModal() {
        driver.navigate().refresh();
        closeCookieBanner();
        mtsPage = new PageObjectsMtsBy(driver);
        mtsPage.testConnectionPaymentWithModal();
    }

    @Step("Закрытие куки-баннера")
    private void closeCookieBanner() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(), 'Принять') or contains(text(), 'Принять все')]")
            ));
            acceptButton.click();
            wait.until(ExpectedConditions.invisibilityOf(acceptButton));

            Allure.addAttachment("Куки-баннер закрыт",
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } catch (Exception e) {
            Allure.step("Куки-баннер не найден, продолжаем выполнение");
        }
    }

    @AfterEach
    @Step("Закрытие браузера")
    void tearDown() {
        if (driver != null) {
            // Скриншот перед закрытием
            Allure.addAttachment("Финальное состояние страницы",
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            driver.quit();
        }
    }
}