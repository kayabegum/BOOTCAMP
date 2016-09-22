package FacebookPageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by kayabegum on 9/15/2016.
 */
public class SendMessages {
    //users are able to send messages(this does not work yet)



    @FindBy(how=How.CSS,using="#email")
    public static WebElement Email;
    @FindBy(how=How.CSS,using="#pass")
    public static WebElement Password;
    @FindBy(how=How.CSS,using="#navItem_217974574879787")
    public static WebElement message;
    @FindBy(how=How.CSS,using=".uiTextareaNoResize.uiTextareaAutogrow._1rv")
    public static WebElement messageTextField;
    @FindBy(how=How.XPATH,using="//*[@id='u_jsonp_2_6']")
    public static WebElement ImageButton;

    public void email(){
        Email.sendKeys("teamdautomation@gmail.com");
    }
    public void password(){
        Password.sendKeys("teamd123",Keys.ENTER);
    }
    public void clickmessage(){
        message.click();
    }
    public void writeMessage(String message){
        messageTextField.sendKeys(message, Keys.ENTER);
//    public void sendImage(File message){
//        messageTextField.sendKeys(message, Keys.ENTER);


    }

    }



