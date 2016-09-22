package Commenting;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by kayabegum on 9/18/2016.
 */
public class CommentBox {

    @FindBy(css="#email")
    public static WebElement email;
    @FindBy(how= How.CSS,using="#pass")
    public static WebElement pass;
    @FindBy(css=".comment_link._5yxe")
    public static WebElement commentBox;
    @FindBy(how=How.CSS,using="._1p1v")
    public static WebElement text;

   public void enterEmail(String Email){email.sendKeys(Email);}
    public void enterPass(String password){pass.sendKeys(password,Keys.ENTER);}
    public void ClickCommentBox(){commentBox.click();}
    public void EnterText(String cm){text.sendKeys(cm,Keys.ENTER);}



}
