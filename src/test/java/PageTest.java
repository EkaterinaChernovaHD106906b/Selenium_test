import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        driver.get("http://u920152e.beget.tech/# ");
        driver.findElement(By.cssSelector("[type='email'][name=auth_email]")).sendKeys("1679myemail@mail.ru");
        driver.findElement(By.cssSelector("[type='password'][name='auth_pass']")).sendKeys("67JhjjY");
        WebElement button = driver.findElement(By.cssSelector("[type='submit'][name='form_auth_submit']"));
        button.click();
        WebElement p = driver.findElement(By.xpath("//p[contains(text(),'Сколько')]"));
        String text = p.getText();

        Assertions.assertEquals("Сколько Вам лет?", text);


    }

    @Test
    public void uploadFile() throws Exception {
        driver.get("https://the-internet.herokuapp.com/upload");
        UploadFile.uploader();
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
    public void checkMetods(){
        UploadFile.deleteFile();
        System.out.println(UploadFile.checkIfFileExist());
    }


}




