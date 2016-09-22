package SignUpForBestBuy;

import PageFactory.SignUp;
import common.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utility.ConnectMySqlDB;

import java.sql.ResultSet;

/**
 * Created by kayabegum on 9/14/2016.
 */
public class BestBuySignUp extends Base {

    //users are able to create an account
    @Test(priority = 4)
    public void CreateAnAccount()throws Exception {

        ConnectMySqlDB connect=new ConnectMySqlDB();
        SignUp signUp = PageFactory.initElements(driver,SignUp.class);
        ResultSet result=connect.resultSet("Accountinfo");
        sleepFor(5);
        signUp.ClosePopUp();
        signUp.ClickCreateAnAccount();
        try {
            while (result.next()) {
                signUp.EnterFirstName(result.getString("Firstname"));
                signUp.EnterLastName(result.getString("Lastname"));
                signUp.EnterEmail(result.getString("email"));
                signUp.EnterPass(result.getString("pass"));
                signUp.ConfirmPass(result.getString("ConfirmPass"));
                signUp.EnterPhoneNumber(result.getString("PhoneNumber"));
                sleepFor(2);
            }
        }
        catch(Exception nf){
            System.out.println("element not found");
        }

        signUp.ClickAccountRecoveryCheck();

        signUp.ClickSubmit();
    }
}
