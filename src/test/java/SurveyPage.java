import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SurveyPage {
    private WebDriver driver;

    public SurveyPage(WebDriver driver) {
        this.driver = driver;
    }

    public void aseertText() {
        WebElement header = driver.findElement(By.xpath("//p[contains(text(),'Сколько')]"));
        String text = header.getText();
        Assertions.assertEquals("Сколько Вам лет?", text);
    }
}


