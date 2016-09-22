package LikingPostsOnFacebook;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by kayabegum on 9/18/2016.
 */
public class LikingPost {
    @FindBy(how= How.CSS,using="#email")
    public static WebElement Email;
    @FindBy(how=How.CSS,using="#pass")
    public static WebElement password;
    @FindBy(how= How.CSS,using=".UFILikeLink._4x9-._4x9_._48-k")
    public static WebElement likeButton;

    public  void email() {
        Email.sendKeys("teamdautomation@gmail.com");
    }
    public void pass(){
        password.sendKeys("teamd123",Keys.ENTER);
    }
    public void Like(){likeButton.click();}
}
