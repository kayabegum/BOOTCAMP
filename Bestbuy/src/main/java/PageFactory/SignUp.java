package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by kayabegum on 9/13/2016.
 */
public class SignUp {


    @FindBy(css = ".close")
    public static WebElement closePOPUp;

    @FindBy(how =How.XPATH,using ="//*[@id=\"header\"]/div/header/div[2]/div[3]/form/div/a[2]/span")
    public static WebElement createAccount;

    @FindBy(how= How.XPATH,using = "//*[@id=\"fld-firstName\"]")
    public static WebElement firstName;

    @FindBy(how= How.XPATH,using = "//*[@id=\"fld-lastName\"]")

    public static WebElement lastName;

    @FindBy(how= How.XPATH,using = "//*[@id=\"fld-e\"]")
    public static WebElement email;

    @FindBy(how= How.XPATH,using = "//*[@id=\"fld-p1\"]")
    public static WebElement password;

    @FindBy(how= How.XPATH,using = "//*[@id=\\\"fld-p2\\\"]")
    public static WebElement confirmPassword;

    @FindBy(how= How.XPATH,using = "//*[@id=\"fld-phone\"]")
    public static WebElement phoneNumer;

    @FindBy(how= How.XPATH,using = "/html/body/section/main/div[1]/div[1]/div/form/div[6]/label/input")
    public static WebElement accountRecoveryCheckBox;

    @FindBy(how= How.XPATH,using = "/html/body/section/main/div[1]/div[1]/div/form/button")
    public static WebElement submitForm;

   public void ClickCreateAnAccount(){
       createAccount.click();
   }
    public void EnterFirstName(String name){
        firstName.sendKeys(name);
    }
    public void EnterLastName(String name){
        lastName.sendKeys(name);
    }
    public void EnterEmail(String Email){
        email.sendKeys(Email);
    }
    public void EnterPass(String pass){
        password.sendKeys(pass);
    }
    public void ConfirmPass(String pass){
        password.sendKeys(pass);

    }
    public void EnterPhoneNumber(String number){
        phoneNumer.sendKeys(number);

    }
    public void ClickAccountRecoveryCheck(){
        accountRecoveryCheckBox.click();

    }
    public void ClickSubmit(){
        submitForm.click();

    }

    public void ClosePopUp(){
        closePOPUp.click();
    }




}
