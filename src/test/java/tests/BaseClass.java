package tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import profileManager.ProfileManager;


public class BaseClass {

    public final ProfileManager profMen = new ProfileManager(BrowserType.CHROME);

    @BeforeClass(alwaysRun = true)
    public void setUp()  {
        profMen.init();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        profMen.stop();
    }

    //protected void Scroll(JavascriptExecutor js, String s) {
   //     js.executeScript(s);
   // }
}
