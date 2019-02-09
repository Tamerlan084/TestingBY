package profileManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SkillsHelper extends HelperBase{

    public SkillsHelper(WebDriver driver) {
        super(driver);

    }


    public void selectSkill(By locator) {

        click(locator);
    }

}
