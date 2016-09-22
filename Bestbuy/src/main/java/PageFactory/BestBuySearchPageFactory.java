package PageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by kayabegum on 9/14/2016.
 */
public class BestBuySearchPageFactory {


        @FindBy(how = How.XPATH, using = ".//*[@id='gh-search-input']")
        public static WebElement searchInput;

        @FindBy(how = How.XPATH,using = "//li[@class='sku-id']")
        public static List<WebElement> SKU;
        @FindBy(css = ".close")
        public static WebElement closePOPUp;

        public void searchFor(String item){
            searchInput.sendKeys(item, Keys.ENTER);
        }

        public void ClosePopUp(){
            closePOPUp.click();
        }

        public void clearSearchBox(){
            searchInput.clear();
        }


    }
