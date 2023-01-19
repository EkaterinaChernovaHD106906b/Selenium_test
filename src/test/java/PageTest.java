import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PageTest {
    private WebDriver driver;
   @BeforeAll
    public static void setUpAll(){
       WebDriverManager.chromedriver().setup();
   }
   @BeforeEach
    public void setUp(){
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--disable-dev-shm-usage");
       options.addArguments("--no-sandbox");
      // options.addArguments("--headless");
       driver = new ChromeDriver(options);
       driver.get("http://u920152e.beget.tech/# ");
   }
    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
    }
    @Test
    public void loginWithEmailAndPassword(){
        driver.findElement(By.cssSelector("[type='email'][name=auth_email]")).sendKeys("1679myemail@mail.ru");
        driver.findElement(By.cssSelector("[type='password'][name='auth_pass']")).sendKeys("67JhjjY");
        WebElement button = driver.findElement(By.cssSelector("[type='submit'][name='form_auth_submit']"));
        button.click();
    }

}
