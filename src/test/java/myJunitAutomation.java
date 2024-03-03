import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class myJunitAutomation {

     WebDriver driver;
//    @BeforeAll
//    public void setup(){
//         driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//    }
    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void writeSomething (){
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.id("edit-name"));
        driver.findElement(By.name("name"));
        driver.findElement(By.id("edit-email")).sendKeys("istiak23@gmail.com");
        driver.findElement(By.id("edit-number")).sendKeys("01989675203");
        driver.findElement(By.id("edit-date")).sendKeys("12/12/1999");
        driver.findElement(By.id("edit-name")).sendKeys("Istiak ahasan");
        driver.findElements(By.className("form-text")).get(1).sendKeys("istiak@test.com");

    }
    @Test
    public void mouseHover() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        List <WebElement> menuNews=driver.findElements(By.xpath("//a[contains(text(),\"News\")]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(menuNews .get(0)).perform();
        Thread.sleep(3000);
    }
    public void keyboardEvents() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        WebElement searchElement = driver.findElement(By.name("q"));
        Actions action = new Actions(driver);
        action.moveToElement(searchElement);
        action.keyDown(Keys.SHIFT);
        action.sendKeys("Selenium Webdriver")
                .keyUp(Keys.SHIFT)
                .doubleClick()
                .contextClick()
                .perform();
        Thread.sleep(5000);}
    @Test
    public void buttonCliick(){
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        Actions actions=new Actions(driver);;
        List<WebElement> buttons=driver.findElements(By.className("btn-primary"));
        actions.click(buttons.get(0)).perform();
    }
    @Test
    public void uploadImage(){
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        WebElement uploadElement = driver.findElement(By.id("edit-uploadocument-upload"));
        uploadElement.sendKeys(System.getProperty("user.dir")+"./src/test/resources/scr.jpg");
        String text= driver.findElement(By.id("edit-uploadocument-upload")).getText();
        Assertions Assert = null;
        Assert.assertTrue(text.contains("./src/test/resources/scr.jpg"));
    }


    @AfterAll
    public static void closeDriver(){
//        driver.quit();
    }
}
