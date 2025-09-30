package lesson2_9;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;  // условия ожидания
import org.openqa.selenium.support.ui.WebDriverWait;       // таймер ожидания
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;  // для работы со временем
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {
    private WebDriver driver;
    private WebDriverWait wait;

    // выполнение перед каждым тесотом
    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize(); // растягивает окно браузера на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // неявное ожидание (ждет до 10 сек, если элемент не был найден сразу)

        //переходим на сайт мтс.ву
        driver.get("https://www.mts.by");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // явное ожидание
    }

    // выполнение после каждого теста
    @AfterEach
    void tearDown() {

        if (driver != null) {   // проверем,что браузер существует
            driver.quit();   //закрываем браузер
        }
    }

    //проверказаголовка блока "Онлайн пополнение без комиссии"
    @Test
    void testBlockTitle() {
        WebElement blockTitle = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        // поиск элемента по XPath
                        By.xpath("//h2[contains(text(), 'Онлайн пополнение')]")
                )
        );

        // проверка отображения элемента на странице
        assertTrue(blockTitle.isDisplayed(), "Заголовок блока не отображается");
        String actualText = blockTitle.getText(); //проверка, что текст содержит ключевые слова
        assertTrue(actualText.contains("Онлайн пополнение"),
                "Текст заголовка не содержит 'Онлайн пополнение'");
        assertTrue(actualText.contains("без комиссии"),
                "Текст заголовка не содержит 'без комиссии'");
    }

    //проверка лого платежных систем
    @Test
    void testPaymentSystemsLogos() {
        // массив с названиями платежных систем
        String[] expectedSystems = {"visa", "mastercard", "belkart"};

        for (String system : expectedSystems) {
            List<WebElement> logos = driver.findElements(
                    By.xpath("//img[contains(@src, '" + system + "')]")
            );


            // проверка, что найден хотя бы один элемент
            assertFalse(logos.isEmpty(), "Логотип " + system +
                    " не найден на странице");

            // проверка, что первый найденный элемент отображается
            assertTrue(logos.get(0).isDisplayed(), "Логотип " + system +
                    " не отображается");
        }
    }

    //проверка сссылки "Подробнее о сервисе"
    @Test
    void testDetailsLink() {
        WebElement detailsLink = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Подробнее о сервисе")
                )
        );

        // проверка, что ссылка отображается на странице
        assertTrue(detailsLink.isDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается");
        assertEquals("Подробнее о сервисе", detailsLink.getText(),
                "Некорректный текст ссылки");

        // получаем URL адрес ссылки и далее проверяем, что он не пустой
        String linkUrl = detailsLink.getAttribute("href");
        assertNotNull(linkUrl, "Ссылка не имеет URL");
        assertFalse(linkUrl.isEmpty(), "URL ссылки пустой");

        assertTrue(linkUrl.contains("mts.by"), "Ссылка ведет на внешний ресурс: " + linkUrl);
    }

    //проверка формы пополнения счёта
    @Test
    void testPaymentFormFunctionality() {
        // поиск поля для ввода номера телефона
        WebElement phoneInput = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@id='connection-phone' and @placeholder='Номер телефона']")
                )
        );

        // проверка, что выбрана опция "Услуги связи" в select
        WebElement selectElement = driver.findElement(By.id("pay"));
        Select serviceSelect = new Select(selectElement);
        WebElement selectedOption = serviceSelect.getFirstSelectedOption();
        assertEquals("Услуги связи", selectedOption.getText(), "По умолчанию должна быть выбрана 'Услуги связи'");


        // ввод номера телефона
        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        // поискк кнопки с текстом "Продолжить"
        WebElement continueButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//form[@id='pay-connection']//button[@type='submit']")
                )
        );

        // проерка активности кнопки
        assertTrue(continueButton.isEnabled(), "Кнопка 'Продолжить' не активна");

        // проверка, что номер телефона корректно введен в поле
        String actualPhoneValue = phoneInput.getAttribute("value");
        String digitsOnly = actualPhoneValue.replaceAll("[^0-9]", "");
        assertTrue(digitsOnly.contains("297777777"),
                "Номер телефона введен некорректно. Цифры: "
                        + digitsOnly + ", полное значение: " + actualPhoneValue);

        // проверка, что опция "Услуги связи" все еще выбрана
        assertEquals("Услуги связи", serviceSelect.getFirstSelectedOption().getText(),
                "Опция 'Услуги связи' должна быть выбрана");

        // проверка, что форма "Услуги связи" открыта (класс opened)
        WebElement connectionForm = driver.findElement(By.id("pay-connection"));
        assertTrue(connectionForm.getAttribute("class").contains("opened"),
                "Форма 'Услуги связи' должна быть открыта");
    }
}
