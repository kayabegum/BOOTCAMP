package HomePage;

import AmazonPageFactory.Home;
import common.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by kayabegum on 9/13/2016.
 */
public class HomePage extends Base {
    Home home = PageFactory.initElements(driver,Home.class);



}
