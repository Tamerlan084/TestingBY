

import org.testng.annotations.*;

import trainig.profileInformation.eduData;
import trainig.profileInformation.mainData;



public class EditMainInformation extends BaseClass{

  @Test
  public void testEditMainInformation() throws Exception {
    goToProfile();
    editProfile();
    mainInformation(new mainData("Shambulova", "Aya", "Itishniik", "1024568936"));
    editEducation();
    //checkIfcheckbox();
   // editOtherUniversity();
    educationInformation(new eduData("ik", "computers"));
    submitEducation();
    submitionEditionProfile();

  }

}
