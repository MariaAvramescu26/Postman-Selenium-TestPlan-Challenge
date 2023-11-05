package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;

public class EndToEnd {
    WebDriver driver;
    HomePage homePage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/Users/maria.avramescu/Downloads/geckodriver");
        driver = new FirefoxDriver();
        // Navigate to omayo website
        driver.get("https://omayo.blogspot.com");
        homePage = new HomePage(driver);
        homePage.clickAcceptButton();
        driver.manage().window().maximize();
    }

    @Test
    public void checkUrlWhenUserNavigatesToPage() {
        Assertions.assertTrue(homePage.checkURLContains(driver, "omayo"), "URL should contain 'omayo'");
    }

    @Test
    public void pageOneTextIsDisplayed() {
        Assertions.assertTrue(homePage.pageOneIsDisplayed(), "Page one text should be displayed");
    }

    @Test
    public void clickOnGetPromptAndIntroduceName() {
        homePage.clickOnGetPromptAndIntroduceName("Maria");
    }

    @Test
    public void loginOnForm() {
        homePage.loginHTMLForm();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
