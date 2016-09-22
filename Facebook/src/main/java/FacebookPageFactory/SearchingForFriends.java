package FacebookPageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by kayabegum on 9/5/2016.
 */
public class SearchingForFriends {
    @FindBy(css="#email")
    public static WebElement email;
    @FindBy(how=How.CSS,using="#pass")
    public static WebElement password;
    @FindBy(how=How.CSS,using="._1frb")
    public static WebElement searchBox;

    public  void email() {
        email.sendKeys("teamdautomation@gmail.com");
    }
    public void pass(){
        password.sendKeys("teamd123",Keys.ENTER);
    }
    public  void search(String names){
        searchBox.sendKeys(names, Keys.ENTER);
    }
    public  void clear(){
        searchBox.clear();
    }
}
