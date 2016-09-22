package CreateAnAccount;

import FacebookPageFactory.SignUpForFB;
import common.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utility.ConnectMySqlDB;

import java.sql.ResultSet;

/**
 * Created by kayabegum on 9/15/2016.
 */
public class CreateAFBAccount extends Base{

    //users are able to create a fb account
    @Test
    public void CreateAnAccount()throws Exception {
        ConnectMySqlDB connect = new ConnectMySqlDB();
        SignUpForFB Signup = PageFactory.initElements(driver, SignUpForFB.class);
        ResultSet result = connect.resultSet("AccountInfo");
        try {
            while (result.next()) {
                Signup.FirstName(result.getString("Firstname"));
                Signup.LastName(result.getString("Lastname"));
                Signup.Email(result.getString("email"));
                Signup.ConfrimEmail(result.getString("email"));
                Signup.Password(result.getString("pass")); }
                 }
        catch(Exception sqlNotfound){}
            selectByIndex("month",1);
            selectByIndex("day",2);
            selectByIndex("year",28);
            Signup.pickFemale();
            Signup.Submit();
    }
}
