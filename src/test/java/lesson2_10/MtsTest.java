package lesson2_10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsTest {
    private WebDriver driver;
    private PageObjectsMtsBy mtsPage;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.mts.by");

        // закрываем куки-баннер перед созданием PageObject
        closeCookieBanner();

        mtsPage = new PageObjectsMtsBy(driver);
    }

    // метод для закрытия куки-баннера
    private void closeCookieBanner() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(), 'Принять') or contains(text(), 'Принять все')]")
            ));
            acceptButton.click();
            // ожидание исчезновения кнопки
            wait.until(ExpectedConditions.invisibilityOf(acceptButton));
        } catch (Exception e) {
            // баннер не найден, продолжаем
        }
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

   //ТЕСТЫ
//ТЕСТЫ К ДЗ № 2_9
    @Test
    void testBlockTitle() {
        mtsPage.checkBlockTitle();
    }

    @Test
    void testPaymentSystemsLogos() {
        mtsPage.checkPaymentSystemsLogos();
    }

    @Test
    void testDetailsLink() {
        mtsPage.checkDetailsLink();
    }

    @Test
    void testPaymentFormFunctionality() {
        mtsPage.testPaymentFormFunctionality();
    }

    // НОВЫЕ ТЕСТЫ К ДЗ № 2_10
    @Test
    void testAllServicesPlaceholders() {
        mtsPage.checkAllServicesPlaceholders();
    }

    @Test
    void testConnectionPaymentWithModal() {
        // перезагрузка страницы перед тестом
        driver.navigate().refresh();
        closeCookieBanner();

        // пересоздала PageObject после перезагрузки
        mtsPage = new PageObjectsMtsBy(driver);

        mtsPage.testConnectionPaymentWithModal();
    }
}
