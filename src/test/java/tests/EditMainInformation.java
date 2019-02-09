package tests;


import org.openqa.selenium.By;
import org.testng.annotations.*;
import model.eduData;
import model.mainData;


public class EditMainInformation extends BaseClass {

  @Test
  public void testEditMainInformation() throws Exception {
    profMen.getProfileHelper().goToProfile(By.linkText("Профиль"));
    profMen.getProfileHelper().editProfile();
    profMen.getMainInformationHelper().mainInformation(new mainData("Shambulova", "Aya", "Itishniik", "1024568936"));
    profMen.getEduHlp().editEducation();
    //checkIfcheckbox();
   // editOtherUniversity();
    profMen.getEduHlp().educationInformation(new eduData("ik", "computers"));
    profMen.getEduHlp().submitEducation();
    profMen.getProfileHelper().submitionEditionProfile();

  }

}
