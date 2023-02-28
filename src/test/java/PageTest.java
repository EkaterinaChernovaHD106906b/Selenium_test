import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;


public class PageTest {
    private WebDriver driver;

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        // options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    /* @AfterEach
     public void tearDown() {
         driver.quit();
         driver = null;
     }*/
    @Test
    public void loginWithEmailAndPassword() {
        new LoginPageBeget(driver)
                .authorization("1679myemail@mail.ru", "67JhjjY");
        new SurveyPage(driver)
                .aseertText();

    }

    @Test
    public void uploadFile() throws Exception {
        driver.get("https://the-internet.herokuapp.com/upload");
        UploadFile.uploader("src/test/java/File.txt");
        By fileInput = By.xpath("//*[@id='file-upload'] [@name='file']");
        //String filePath = "src/test/java/File.txt";
        File file = new File("src/test/java/File.txt");
        driver.findElement(fileInput).sendKeys(file.getAbsolutePath());


    }

    @Test
    public void addRemoveElements() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement buttonAdd = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        buttonAdd.click();
        WebElement buttonDelete = driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
        if (buttonDelete.isDisplayed()) {
            buttonDelete.click();
        } else {
            System.out.println("Element not found");
        }

    }

    @Test
    public void basicAuth() {
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        driver.switchTo().alert().sendKeys("admin" + Keys.TAB + "admin");

        // driver.findElement(By.xpath("//body[contains(text(),'Not authorized')]")).isDisplayed();
    }

    @Test
    public void checkboxes() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.findElement(By.xpath("//form/input[1]")).click();
        driver.findElement((By.xpath("//form/input[2]"))).click();
    }

    @Test
    public void contextMenu() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement contextMenu = driver.findElement(By.cssSelector("#hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(contextMenu).perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    @Test
    public void checkMethods() throws Exception {
        UploadFile.deleteFile();
        UploadFile.uploader("src/test/java/File.txt");
        System.out.println(UploadFile.checkIfFileExist("src/test/java/File.txt"));
    }



}




