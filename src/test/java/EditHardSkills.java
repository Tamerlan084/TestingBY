import org.testng.annotations.*;
import org.openqa.selenium.*;

public class EditHardSkills extends BaseClass {

  @Test
  public void testEditHardSkills() throws Exception {
    goToProfile();
    editProfile();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,1000)");
    selectSkill(By.xpath("//span[text()=\"ABAP\"]/../div/label[1]"));
    js.executeScript("window.scrollBy(0,-1500)");
    submitionEditionProfile();

  }

  private void selectSkill(By locator) {
    driver.findElement(locator).click();
  }


}
