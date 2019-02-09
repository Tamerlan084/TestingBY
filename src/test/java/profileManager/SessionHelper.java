package profileManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

    private String baseUrl;

    public SessionHelper(WebDriver driver) {
        super(driver);


    }


    public void login(String email, String password) {
        baseUrl = "https://www.training.by/";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        click(By.className("uui-button"));
        click(By.id("Name"));
        type(email, By.id("Name"));
        click(By.id("Password"));
        type(password, By.id("Password"));
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Войти'])[2]/following::button[2]"));
        }


}
