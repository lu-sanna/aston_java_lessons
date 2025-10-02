package lesson2_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PageObjectsMtsBy {
    private WebDriver driver;
    private WebDriverWait wait;

    public PageObjectsMtsBy(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // локаторы из прошлого задания № 2_9
    @FindBy(xpath = "//h2[contains(text(), 'Онлайн пополнение')]")
    private WebElement blockTitle;

    @FindBy(linkText = "Подробнее о сервисе")
    private WebElement detailsLink;

    @FindBy(id = "pay")
    private WebElement serviceSelect;

    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    private WebElement phoneInput;

    @FindBy(xpath = "//input[@placeholder='Сумма']")
    private WebElement sumInput;

    @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
    private WebElement continueButton;

    // МЕТОДЫ ИЗ ПРОШЛОГО ЗАДАНИЯ " 2_9

    public void checkBlockTitle() {
        WebElement title = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h2[contains(text(), 'Онлайн пополнение')]")
        ));
        assertTrue(title.isDisplayed());
        String text = title.getText();
        assertTrue(text.contains("Онлайн пополнение"));
        assertTrue(text.contains("без комиссии"));
    }

    public void checkPaymentSystemsLogos() {
        String[] systems = {"visa", "mastercard", "belkart"};
        for (String system : systems) {
            WebElement logo = driver.findElement(By.xpath("//img[contains(@src, '" + system + "')]"));
            assertTrue(logo.isDisplayed());
        }
    }

    public void checkDetailsLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Подробнее о сервисе")
        ));
        assertTrue(link.isDisplayed());
        assertEquals("Подробнее о сервисе", link.getText());
        assertTrue(link.getAttribute("href").contains("mts.by"));
    }

   public void testPaymentFormFunctionality() {
       // проверка, что по умолчанию выбрана "Услуги связи"
       Select dropdown = new Select(serviceSelect);
       assertEquals("Услуги связи", dropdown.getFirstSelectedOption().getText());

       // ожидание открытия формы "Услуги связи"
       wait.until(ExpectedConditions.attributeContains(By.id("pay-connection"), "class", "opened"));

       // поиск поля номера телефона, его заполнение
       WebElement phoneField = wait.until(ExpectedConditions.elementToBeClickable(
               By.xpath("//input[@placeholder='Номер телефона']")
       ));

       // очистка поля и ввод номерп
       phoneField.clear();
       phoneField.sendKeys("297777777");

       // проверка, что кнопка "Продолжить" активна
       assertTrue(continueButton.isEnabled(), "Кнопка 'Продолжить' должна быть активна после заполнения формы");

       // проверка, что номер телефона корректно введен
        String phoneValue = phoneField.getAttribute("value");
        String digits = phoneValue.replaceAll("[^0-9]", "");
        assertTrue(digits.contains("297777777"));
    }



    // МЕТОДЫ ПО НОВОМУ ЗАДАНИЮ № 2_10

    // 1. Проверка плейсхолдеров для всех услуг
    public void checkAllServicesPlaceholders() {
        Select dropdown = new Select(serviceSelect);

        // Услуги связи
        dropdown.selectByVisibleText("Услуги связи");
        WebElement phoneField = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        WebElement sumField = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        assertEquals("Номер телефона", phoneField.getAttribute("placeholder"));
        assertEquals("Сумма", sumField.getAttribute("placeholder"));

        // Домашний интернет
        dropdown.selectByVisibleText("Домашний интернет");
        WebElement accountField = driver.findElement(By.xpath("//input[@placeholder='Номер абонента']"));
        assertEquals("Номер абонента", accountField.getAttribute("placeholder"));

        // Рассрочка
        dropdown.selectByVisibleText("Рассрочка");
        WebElement codeField = driver.findElement(By.xpath("//input[@placeholder='Номер счета на 44']"));
        assertEquals("Номер счета на 44", codeField.getAttribute("placeholder"));

        // Задолженность
        dropdown.selectByVisibleText("Задолженность");
        WebElement contractField = driver.findElement(By.xpath("//input[@placeholder='Номер счета на 2073']"));
        assertEquals("Номер счета на 2073", contractField.getAttribute("placeholder"));
    }


    // 2. Проверка оплаты услуг связи
    public void testConnectionPaymentWithModal() {

        // выбор "Услуги связи"
        Select dropdown = new Select(serviceSelect);
        dropdown.selectByVisibleText("Услуги связи");
        wait.until(ExpectedConditions.attributeContains(By.id("pay-connection"), "class", "opened"));

        // заполняе поля
        phoneInput.sendKeys("297777777");
        sumInput.sendKeys("5");

        // проверка активности кнопки, нажимаем на кнопку
        assertTrue(continueButton.isEnabled(), "Кнопка 'Продолжить' должна быть активна");
        continueButton.click();

        // ожидание появления  с платежной формой, переход в этот iframe
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("iframe.bepaid-iframe")
        ));
        driver.switchTo().frame(iframe);

        try {
            // время для загрузки формы
            Thread.sleep(3000);

            // проверка отображение суммы 5.00 BYN
            List<WebElement> amountElements = driver.findElements(By.xpath("//*[contains(text(), '5.00') and contains(text(), 'BYN')]"));
            assertTrue(!amountElements.isEmpty(), "Сумма оплаты не отображается корректно");
            assertTrue(amountElements.get(0).isDisplayed(), "Сумма оплаты не отображается корректно");

            // проверка отображения номера телефона
            List<WebElement> phoneElements = driver.findElements(
                    By.xpath("//*[contains(text(), '297777777') or contains(text(), '375297777777')]")
            );
            assertTrue(!phoneElements.isEmpty(), "Номер телефона не отображается в платежной форме");
            assertTrue(phoneElements.get(0).isDisplayed(), "Номер телефона не отображается корректно");

            // проверка кнопки с суммой
            List<WebElement> payButtons = driver.findElements(By.xpath("//button[contains(., '5.00') and contains(., 'BYN')]"));
            assertTrue(!payButtons.isEmpty(), "Кнопка оплаты с суммой не отображается");
            assertTrue(payButtons.get(0).isDisplayed(), "Кнопка оплаты с суммой не отображается");

            // проверка надписи в полях для реквизитов карты

            // поле "Номер карты"
            WebElement cardNumberField = driver.findElement(By.id("cc-number"));
            assertTrue(cardNumberField.isDisplayed(), "Поле для номера карты не отображается");

            // поле "Срок действия"
            WebElement expiryField = driver.findElement(By.xpath("//input[@placeholder='MM / YY']"));
            assertTrue(expiryField.isDisplayed(), "Поле для срока действия не отображается");

            // поле "CVC"
            WebElement cvcField = driver.findElement(By.name("verification_value"));
            assertTrue(cvcField.isDisplayed(), "Поле CVC не отображается");

            // поле "Имя и фамилия на карте"
            WebElement nameField = driver.findElement(By.cssSelector("input[formcontrolname='holder']"));
            assertTrue(nameField.isDisplayed(), "Поле для имени и фамилии на карте не отображается");

            // проверка наличия иконок платежных систем
            String[] paymentSystems = {"visa", "mastercard"};
            for (String system : paymentSystems) {
                List<WebElement> icons = driver.findElements(
                        By.xpath("//img[contains(@src, '" + system + "')]")
                );
                assertTrue(!icons.isEmpty(), "Иконка платежной системы " + system + " не найдена");
                assertTrue(icons.get(0).isDisplayed(), "Иконка платежной системы " + system + " не отображается");
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

        } finally {
            // возвращаемся к основному контенту
            driver.switchTo().defaultContent();
        }
    }
}
