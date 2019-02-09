package tests;


import org.testng.annotations.*;
import org.openqa.selenium.*;

public class EditHardSkills extends BaseClass {

  @Test
  public void testEditHardSkills() throws Exception {
    profMen.getProfileHelper().goToProfile(By.linkText("Профиль"));
    profMen.getProfileHelper().editProfile();
    JavascriptExecutor js = (JavascriptExecutor) profMen.getProfileHelper().driver;
    profMen.getSkillsHelper().Scroll(js, "window.scrollBy(0,1000)");
    profMen.getSkillsHelper().selectSkill(By.xpath("//span[text()=\"ABAP\"]/../div/label[1]"));
    profMen.getSkillsHelper().Scroll(js, "window.scrollBy(0,-1500)");
    profMen.getProfileHelper().submitionEditionProfile();

  }


}
