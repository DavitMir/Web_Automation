package am.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


@Listeners(TestListener.class)
public class Tests extends TestListener {

    @BeforeSuite
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void firstTest() {
        driver.get("https://www.list.am/");
        String title = driver.getTitle();
        Assert.assertEquals("List.am - Հայաստանի անվճար հայտարարությունների կայք!", title);
    }

    @Test
    public void search() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "\"F:/Java/chromedriver.exe\"");

        driver.get("https://www.list.am/");
        WebElement element = driver.findElement(By.id("idSearchBox"));
        element.sendKeys("Ճագար");
        element.submit();
        driver.navigate().to("https://www.list.am/category?q=Ճագար");
        Thread.sleep(500);
        driver.findElement(By.className("me")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@data-name=' Գորիս']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@href=\"/item/15530366\"]")).click();
        driver.navigate().to("https://www.list.am/item/15530366");
        driver.findElement(By.className("email")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@href=\"/login?next=item/15530366\"]")).click();
        driver.navigate().to("https://www.list.am/login?next=item/15530366");
        driver.findElement(By.id("_idyour_email")).sendKeys("dmirakyane@gmail.com");
        driver.findElement(By.id("_idpassword")).sendKeys("David1234");
        driver.findElement(By.id("loginaction__form_action0")).click();
        driver.findElement(By.className("email")).click();
        Thread.sleep(500);
        //driver.findElement(By.id("_idyour_name")).sendKeys("Harut");
        driver.findElement(By.id("_idyour_message")).sendKeys("Inchqanes asum axpers");
        driver.findElement(By.id("submit_dlg_button")).click();
        Thread.sleep(500);
        driver.findElement(By.id("confirm_dlg_button")).click();
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }
}