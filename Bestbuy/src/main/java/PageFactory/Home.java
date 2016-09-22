package PageFactory;

import common.Base;
import javafx.scene.layout.Background;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

/**
 * Created by kayabegum on 9/13/2016.
 */
public class Home extends Base{


    @FindBy(how = How.CSS,using = ".close")
    public static WebElement closePOpUp;
    @FindBy(how = How.XPATH,using = "//*[@id=\"header\"]/div/header/div[2]/nav/ul/li[1]")
    public static WebElement product;
    @FindBy(how = How.XPATH,using = "//*[@id=\"header\"]/div/header/div[2]/nav/ul/li[2]")
    public static WebElement   services;
    @FindBy(how = How.XPATH,using = "//*[@id=\"header\"]/div/header/div[2]/nav/ul/li[3]")
    public static WebElement Deals;
    @FindBy(how = How.XPATH,using = "//*[@id=\"header\"]/div/header/div[2]/div[3]/form/div/a[1]")
    public static WebElement signIn;
    @FindBy(how = How.XPATH,using = "//*[@id=\"header\"]/div/header/div[2]/div[4]/a")
    public static WebElement cart;

    public void clickProduct(){
        product.click();
    }
    public void services(){
        services.click();
    }
    public void deals(){
        Deals.click();
    }

    public static void SignIn() {
        signIn.click();
    }
    public void cart(){
        cart.click();
    }
    public void ClosePopUp(){
        closePOpUp.click();
    }
}
