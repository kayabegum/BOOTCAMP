package AmazonPageFactory;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by kayabegum on 9/13/2016.
 */
public class SignUpForm {

    @FindBy(xpath = "//*[@id=\"nav-signin-tooltip\"]/div/a")
    public static WebElement signIn;

    @FindBy(xpath = "//*[@id=\"createAccountSubmit\"]")
    public static WebElement createAccount;

    @FindBy(xpath = "//*[@id=\"ap_customer_name\"]")
    public static WebElement Name;

    @FindBy(xpath = "//*[@id=\"ap_email\"]")
    public static WebElement email;

    @FindBy(xpath = "//*[@id=\"ap_password\"]")
    public static WebElement password;

    @FindBy(xpath = "//*[@id=\"ap_password_check\"]")
    public static WebElement ConfirmPassword;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    public static WebElement Submit;


    public void signIn() {
        signIn.click();

    }
    public void createAnAccount() {createAccount.click();}
    public void Name(String EnterName) {
        Name.sendKeys(EnterName);
    }

    public void Email(String Email) {
        email.sendKeys(Email);
    }

    public void password(String pass) {
        password.sendKeys(pass);
    }

    public void ConfirmPassword(String pass) {
        ConfirmPassword.sendKeys(pass);
    }

    public void Submit() {
        Submit.click();
    }
}
