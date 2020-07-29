package ru.autoDispether;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class ObjectTest {
    public ChromeDriver driver;

    @Before public void setUp() {
        System.setProperty("webdriver.chrome.driver","/Users/macbook/Desktop/jAVA/chromedriver");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("test start");
    }

    @Test
    public void startLinkTest() {

        driver.get("https://yandex.ru/");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Яндекс"));
        driver.quit();

    }

    @Test
    public void searchTest() {
        driver.get("https://yandex.ru/");
        String textSeach = "рассчет расстояний между городами";
        driver.findElement(By.id("text")).sendKeys(textSeach); // передача текста
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        WebDriverWait wait =  new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("organic__url-text")));
        driver.quit();
    }
    @Test
    public void completeSearchTest() {
        driver.get("https://yandex.ru/");
        String textSearch = "расчет расстояний между городами";
        driver.findElement(By.id("text")).sendKeys(textSearch); // передача текста
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        WebDriverWait wait =  new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("organic__url-text")));
        driver.findElement(By.cssSelector("[href=\"https://www.avtodispetcher.ru/distance/\"]")).click();

        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // передача окна
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"l-table1\"]")));
        driver.quit();
    }

    @Test
    public void distanceInputTest() {
        driver.get("https://yandex.ru/");
        String textSearch = "расчет расстояний между городами";
        driver.findElement(By.id("text")).sendKeys(textSearch); // передача текста
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        WebDriverWait wait =  new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("organic__url-text")));
        driver.findElement(By.cssSelector("[href=\"https://www.avtodispetcher.ru/distance/\"]")).click();

        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // передача окна
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"l-table1\"]")));

        String leftCity = "Тула";
        String rightCity = "Санкт-Петербург";

        driver.findElement(By.cssSelector("[class=\"column right_padding\"]")).sendKeys(leftCity);
        driver.findElement(By.cssSelector("[class=\"column\"]")).sendKeys(rightCity);
        driver.findElement(By.cssSelector("input[name=\"fc\"]")).clear();
        driver.findElement(By.cssSelector("input[name=\"fc\"]")).sendKeys("9");
        driver.findElement(By.cssSelector("input[name=\"fp\"]")).clear();
        driver.findElement(By.cssSelector("input[name=\"fp\"]")).sendKeys("46");
        driver.findElement(By.cssSelector("[class=\"submit_button\"]")).click();
    }
    @Test
    public void totalDistanceTest() {
        driver.get("https://yandex.ru/");
        String textSearch = "расчет расстояний между городами";
        driver.findElement(By.id("text")).sendKeys(textSearch); // передача текста
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        WebDriverWait wait =  new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("organic__url-text")));
        driver.findElement(By.cssSelector("[href=\"https://www.avtodispetcher.ru/distance/\"]")).click();

        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // передача окна
        }

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"l-table1\"]")));

        String leftCity = "Тула";
        String rightCity = "Санкт-Петербург";

        driver.findElement(By.cssSelector("[class=\"column right_padding\"]")).sendKeys(leftCity);
        driver.findElement(By.cssSelector("[class=\"column\"]")).sendKeys(rightCity);
        driver.findElement(By.cssSelector("input[name=\"fc\"]")).clear();
        driver.findElement(By.cssSelector("input[name=\"fc\"]")).sendKeys("9");
        driver.findElement(By.cssSelector("input[name=\"fp\"]")).clear();
        driver.findElement(By.cssSelector("input[name=\"fp\"]")).sendKeys("46");
        driver.findElement(By.cssSelector("[class=\"submit_button\"]")).click();



        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"distance\"]")));


        String totalDistance = driver.findElement(By.id("totalDistance")).getText();
        Assert.assertTrue(totalDistance.equals("897"));

// fuelFormSubmitHandler(fuelForm) не получаеться вытащить стоимость топлива



        driver.findElement(By.className("anchor")).click();
        String city = "Великий Новгород";
        driver.findElement(By.cssSelector("input[name=\"v\"]")).sendKeys(city);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); /// !!!!!

        driver.findElement(By.cssSelector("[class=\"submit_button\"]")).click(); // второе нажатие на кнопку
        totalDistance = driver.findElement(By.id("totalDistance")).getText();
        Assert.assertTrue(totalDistance.equals("966"));

        //не могу проверить сумму топлива !!!!
    }


    @After
    public void close() {
        driver.quit();
        System.out.println("test stop");
    }
}
