package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.LoginSteps;
import steps.ProjectSteps;
import steps.SuiteSteps;
import steps.TestCaseSteps;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;


public class BaseTest {
    public static String EMAIL = PropertyReader.getProperty("email");
    public static String PASSWORD = PropertyReader.getProperty("password");
    public static String LOGIN_URL = PropertyReader.getProperty("loginUrl");

    protected LoginSteps loginSteps;
    protected ProjectsListPage projectsListPage;
    protected NewProjectModalWindow newProjectModalWindow;
    protected ProjectSteps projectSteps;
    protected NewSuiteModalWindow newSuiteModalWindow;
    protected SuiteSteps suiteSteps;
    protected ProjectPage projectPage;
    protected NewTestCaseModalWindow newTestCaseModalWindow;
    protected TestCaseSteps testCaseSteps;
    protected TestCasePage testCasePage;

    public void initPage() {
        loginSteps = new LoginSteps();
        projectsListPage = new ProjectsListPage();
        newProjectModalWindow = new NewProjectModalWindow();
        projectSteps = new ProjectSteps();
        newSuiteModalWindow = new NewSuiteModalWindow();
        suiteSteps = new SuiteSteps();
        projectPage = new ProjectPage();
        newTestCaseModalWindow = new NewTestCaseModalWindow();
        testCaseSteps = new TestCaseSteps();
        testCasePage = new TestCasePage();
    }

    @BeforeMethod
    public void initTest() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);

        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.headless = false;
        Configuration.browserSize = "1024x768";
        initPage();
    }

    @AfterMethod
    public void endTest() {
        getWebDriver().quit();
    }
}

