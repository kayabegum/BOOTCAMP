package LogInPage;

import FacebookPageFactory.SearchingForFriends;
import common.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by kayabegum on 9/15/2016.
 */
public class LogIn extends Base {


    @Test
    public void logIn()throws Exception{
        SearchingForFriends log= PageFactory.initElements(driver,SearchingForFriends.class);
        log.email();
        log.pass();

    }


}
