package SignInToBestBuy;

import PageFactory.BestBuySingIn;
import common.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utility.ConnectMySqlDB;

import java.sql.ResultSet;

/**
 * Created by kayabegum on 9/15/2016.
 */
public class SignIn extends Base {
    //users are able to sign In
    @Test
    public void SignIntoAccount() throws Exception {
        ConnectMySqlDB connect = new ConnectMySqlDB();
        BestBuySingIn signIn = PageFactory.initElements(driver, BestBuySingIn.class);
        ResultSet result = connect.resultSet("AccountInfo");
        signIn.ClosePopUp();
        signIn.signInbutton();
        try{
            while(result.next())
                signIn.email(result.getString("email"));


        }
        catch(Exception SQLERROR){
        }
        signIn.password("password");
        signIn.submit();



    }
}
