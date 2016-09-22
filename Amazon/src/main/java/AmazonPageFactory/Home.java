package AmazonPageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by kayabegum on 9/13/2016.
 */
public class Home {

    @FindBy(css ="#twotabsearchtextbox")
    public static WebElement searchBox;
    @FindBy(css = "#nav-search > form > div.nav-right > div > input")
    public static WebElement clickSearch;
    @FindBy(xpath = "//*[@id=\"searchDropdownBox\"]")
    public static WebElement dropdown;

    public void search(String item){
        searchBox.sendKeys(item, Keys.ENTER);
    }
    public void clear(){
        searchBox.clear();
    }

}
