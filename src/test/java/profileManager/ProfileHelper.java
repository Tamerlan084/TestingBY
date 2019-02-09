package profileManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ProfileHelper extends HelperBase{


    public ProfileHelper(WebDriver driver) {
        super(driver);

    }

    public void submitionEditionProfile() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Scroll(js, "window.scrollBy(0,-1000)");
        click(By.xpath("//div[@class='userProfile-buttons']/button"));
    }

    public void editProfile() {

        click(By.xpath("//a[contains(text(),'Редактировать')]"));
    }

    public void goToProfile() {
        click(By.className("profile-name"));
        click(By.linkText("Профиль"));
    }
}
