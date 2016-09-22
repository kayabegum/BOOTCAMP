package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by kayabegum on 9/15/2016.
 */
public class BestBuySingIn {
    @FindBy(css = ".close")
    public static WebElement closePOPUp;
    @FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div/header/div[2]/div[3]/form/div/a[1]")
    public static WebElement signIn;
    @FindBy(how = How.XPATH, using = "//*[@id=\"fld-e\"]")
    public static WebElement EnterEmail;
    @FindBy(how = How.XPATH, using = "//*[@id=\"fld-p1\"]")
    public static WebElement EnterPassword;
    @FindBy(how = How.XPATH, using = " /html/body/section/main/div[1]/div[1]/div/form/button")
    public static WebElement SubmitButton;



    public void signInbutton() {
        signIn.click();
    }

    public void ClosePopUp() {
        closePOPUp.click();
    }

    public void email(String email) {
        EnterEmail.sendKeys(email);
    }

    public void password(String pass) {
        EnterPassword.sendKeys(pass);
    }

    public void submit() {
        SubmitButton.click();}
}
