package tests;

import com.codeborne.selenide.SelenideElement;
import object.Project;
import object.Suite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$x;

public class SuiteTest extends BaseTest {
   // private static final String LOCATOR = "//h3[text()='%s']";
    SoftAssert softAssert = new SoftAssert();
    Random random = new Random();

    @Test
    public void suiteCreate() {


        loginSteps.login(EMAIL, PASSWORD, LOGIN_URL);

        Project project = Project.builder()
                .projectName("Web Application" + random.nextInt(5))
                .projectCode("WB" + random.nextInt(5))
                .description("Very Good Project!" + random.nextInt(5))
                .build();
        Suite suite = Suite.builder()
                .suiteName("New Suite" + random.nextInt(5))
                .build();

        String suiteName = suite.getSuiteName();
       // SelenideElement locatorText = $x(String.format(LOCATOR,
      //          suiteName));
        projectSteps.createProject(project);
        suiteSteps.createSuite(suite);

       // softAssert.assertEquals(locatorText.getText(), suiteName);
        softAssert.assertEquals(projectPage.getSuiteNameText(suiteName), suiteName);
        suiteSteps.deleteSuite();
        softAssert.assertTrue(projectPage.checkEmptySuiteList());
        softAssert.assertAll();
    }
}
