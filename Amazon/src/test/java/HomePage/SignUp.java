package HomePage;

import AmazonPageFactory.SignUpForm;
import common.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utility.ConnectMySqlDB;

import java.sql.ResultSet;

/**
 * Created by kayabegum on 9/13/2016.
 */
public class SignUp extends Base {


         @Test
        public void SignUp() throws Exception{
        ConnectMySqlDB connect=new ConnectMySqlDB();
        SignUpForm signUp = PageFactory.initElements(driver, SignUpForm.class);
        ResultSet result=connect.resultSet("Accountinfo");
             signUp.signIn();
//             signUp.createAnAccount();
             try{
                 while(result.next()){
                     signUp.Name(result.getString("Firstname")+" "+result.getString("Lastname"));
                     signUp.Email(result.getString("email"));
                     signUp.password(result.getString("pass"));
                     signUp.ConfirmPassword("pass");
                 }
             }
             catch(Exception TNF){
             }

                    signUp.Submit();
    }
}
