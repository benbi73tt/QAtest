import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Waits {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\github\\driverQA\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Неявное ожидание по умолчания для появления любого элементы

        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));

        try {
            driver.get("https://pagination.js.org/");
            Thread.sleep(2000);

            List<WebElement> elementList = driver.findElements(By.xpath("//div[@class = 'data-container']/ul/li"));
            List<WebElement> pagesList = driver.findElements(By.xpath("//div[@class = 'paginationjs-pages']/ul/li"));
            String text = elementList.get(3).getText();
            System.out.println(text);

            pagesList.get(2).click(); //нажать и переключиться на 2ю страницу

            webDriverWait.until(ExpectedConditions.stalenessOf(elementList.get(1)));//Ждем пока элемент пропадет


            elementList = driver.findElements(By.xpath("//div[@class = 'data-container']/ul/li"));

            text = elementList.get(3).getText();
            System.out.println(text);

            String title = driver.getTitle();
            System.out.println(title);
            Assert.assertEquals(title,"Pagination.js | Home"); // проверка на правильность




        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            driver.quit();
        }

    }
}
