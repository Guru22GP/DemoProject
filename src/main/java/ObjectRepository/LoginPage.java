package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

   @FindAll({@FindBy(id="user-name"),@FindBy(name = "user-name")}) // Autoheal
   private WebElement un;

    @FindBy (id="password")
    private WebElement pwd;

    @FindBy(id= "login-button")
    private WebElement loginButton;

    public  LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }


    public WebElement getUn() {
        return un;
    }

    public WebElement getPwd() {
        return pwd;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }
}
