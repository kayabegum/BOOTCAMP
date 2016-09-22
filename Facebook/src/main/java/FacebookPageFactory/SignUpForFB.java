package FacebookPageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by kayabegum on 9/15/2016.
 */
public class SignUpForFB {
    @FindBy(how = How.CSS, using = "#u_0_1")
    public static WebElement firstName;
    @FindBy(how = How.CSS, using = "#u_0_3")
    public static WebElement lastName;
    @FindBy(how = How.CSS, using = "#u_0_5")
    public static WebElement email;
    @FindBy(how = How.CSS, using = "#u_0_8")
    public static WebElement emailConfirm;
    @FindBy(how = How.CSS, using = "#u_0_a")
    public static WebElement pass;
    @FindBy(how=How.CSS,using = "#u_0_d")
    public static WebElement female;
    @FindBy(how = How.CSS, using = "#u_0_i")
    public static WebElement submit;


    public void FirstName(String name){firstName.sendKeys(name);}
    public void LastName(String name){lastName.sendKeys(name);}
    public void Email(String em){email.sendKeys(em);}
    public void ConfrimEmail(String CE){emailConfirm.sendKeys(CE);}
    public void Password(String password){pass.sendKeys(password);}
    public void pickFemale(){female.click();}
    public void Submit(){submit.click();}




}

