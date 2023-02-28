import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageBeget {
    private WebDriver driver;

    public LoginPageBeget(WebDriver driver) {
        this.driver = driver;
    }

    private By authEmail = By.cssSelector("[type='email'][name=auth_email]");
    private By password = By.cssSelector("[type='password'][name='auth_pass']");
    private By button = By.cssSelector("[type='submit'][name='form_auth_submit']");

    public void setEmail(String email) {
        driver.findElement(authEmail).sendKeys(email);
    }

    public void setPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }


    public void authorization(String email, String pass) {
        driver.get("http://u920152e.beget.tech/# ");
        setEmail(email);
        setPassword(pass);
        clickEnterButton();

    }

    public SurveyPage clickEnterButton() {
        driver.findElement(button).click();
        return new SurveyPage(driver);

    }
}
