package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    private WebDriver driver;
    WebElement acceptButton;
    WebElement usernameInput;
    WebElement passwordInput;
    WebElement loginButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkURLContains(WebDriver driver, String partOfUrl) {
        assertURLContains(driver, partOfUrl);
        return true;
    }
    public boolean pageOneIsDisplayed() {
        By blogPostTitleSelector = By.cssSelector(".post.hentry.uncustomized-post-template h3");
        WebElement element = driver.findElement(blogPostTitleSelector);
        Assertions.assertTrue(isElementVisible(element), "Element is not visible");
        return isElementPresent(blogPostTitleSelector);
    }
    public void clickAcceptButton() {
        acceptButton = driver.findElement(By.cssSelector("#cookieChoiceDismiss"));
        acceptButton.click();
    }
    public void clickOnGetPromptAndIntroduceName(String name) {
        WebElement promptButton = driver.findElement(By.id("prompt"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", promptButton);

        // Switch to the alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(name);
        alert.accept();
    }
    public void loginHTMLForm() {
        //identify username and input text
        usernameInput = driver.findElement(By.cssSelector("input[type='text']"));
        usernameInput.clear();
        usernameInput.sendKeys("maria_user");

        //identify pass and input text
        passwordInput = driver.findElement(By.cssSelector("input[type='password']"));
        passwordInput.clear();
        passwordInput.sendKeys("maria_pass");

        //identify ad click login button
        loginButton= driver.findElement(By.xpath("//*[@id='HTML31']/div[1]/form/button"));
        loginButton.click();
    }

    //helpers used for assertions
    public void assertURLContains(WebDriver driver, String partOfUrl) {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains(partOfUrl), "URL should contain '" + partOfUrl + "'");
    }
    private boolean isElementVisible(WebElement element) {
        return element.isDisplayed();
    }

    private boolean isElementPresent(By elementSelector) {
        return !driver.findElements(elementSelector).isEmpty();
    }
}