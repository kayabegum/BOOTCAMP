package HomePage;

import PageFactory.Home;
import common.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by kayabegum on 9/15/2016.
 */
public class BestBuyHomePage extends Base {


    //users are able to click product menu on the top of the home page
    @Test
    public void product()throws Exception{
        Home home= PageFactory.initElements(driver,Home.class);
        home.ClosePopUp();
        home.clickProduct();

    }
    //users are able to click service menu on the top of the home page
    @Test(priority = 4)
    public void service()throws Exception{
        Home home= PageFactory.initElements(driver,Home.class);
        home.ClosePopUp();
        home.services();

    }
    //users are able to click Deals menu on the top of the home page
    @Test(priority = 5)
    public void Deals()throws Exception{
        Home home= PageFactory.initElements(driver,Home.class);
        home.ClosePopUp();
        home.deals();

    }
    //users are able to click cart on the top of the home page
    @Test(priority = 6)
    public void cart()throws Exception{
        Home home= PageFactory.initElements(driver,Home.class);
        home.ClosePopUp();
        home.cart();

    }
    //users are able to click sign in on the top of the home page
    @Test(priority = 7)
    public void ClickSignIn()throws Exception{
        Home home= PageFactory.initElements(driver,Home.class);
        home.ClosePopUp();
        home.SignIn();

    }
}
