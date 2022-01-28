import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\github\\driverQA\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

//todo Явные и неявные ожидания
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //устаревший метод
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Явное ожидани
//        _
//        WebElement element = (new WebDriverWait(driver,Duration.ofSeconds(10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("123"))));
//          явное ожидание, мы точно ждем какого то события


//todo
//        driver.get("https://www.avito.ru/");
//        WebElement element = driver.findElement(By.xpath("//a[text()='Личные вещи'][1]"));
//        String par = element.getAttribute("href"); //Отдает элементы которые находятся в properties
//        System.out.println(par);

//todo Кликнуть отправить в input и отправить запрос
//        driver.get("https://www.avito.ru/");
//        WebElement element = driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']"));
//        element.sendKeys("civic", Keys.ENTER);


        try {
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
            Thread.sleep(2000);
            WebElement element = driver.findElement(By.id("draggable"));
            WebElement element1 = driver.findElement(By.id("droppable"));

            Actions actions = new Actions(driver);
//todo наглядная версия
//              actions
//                    .moveToElement(element).clickAndHold()
//                    .moveToElement(element1).release()
//                    .build().perform();

//todo по координатам
//            actions.dragAndDropBy(element,200,100).release().build().perform();

            actions
                    .dragAndDrop(element,element1).release().build().perform();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                Thread.sleep(10000);
                driver.quit();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        WebElement input = driver.findElement(By.xpath("//input[@aria-label='Найти']"));
//        input.click();
//        driver.quit();

    }
}
