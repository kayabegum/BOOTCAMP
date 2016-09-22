package BestBuySearch;

import PageFactory.BestBuySearchPageFactory;
import common.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utility.ConnectMySqlDB;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * Created by kayabegum on 9/14/2016.
 */
public class StoringData extends Base {

//
////    //Strong all the SKU
//    @Test(priority = 2)
//    public void getSKU() throws InterruptedException, IOException {
//        ConnectMySqlDB connect = new ConnectMySqlDB();
//        BestBuySearchPageFactory search = PageFactory.initElements(driver, BestBuySearchPageFactory.class);
//        search.ClosePopUp();
//        search.searchFor("laptop");
////        getListOfWebElementsByCss(".//li[@class='sku-id']");
//        connect.InsertWebelementListToMySql(getListOfWebElementsByXpath("//li [@class='sku-id']"), "BestBuyLaptopSKU", "SKU");
//   }

//    data validation
    SoftAssert softAssert = new SoftAssert();
    @Test(priority = 3)
    public void SKUValidation() throws Exception {
        ConnectMySqlDB connect = new ConnectMySqlDB();
        BestBuySearchPageFactory search = PageFactory.initElements(driver, BestBuySearchPageFactory.class);
        search.ClosePopUp();
        search.searchFor("laptop");
        ResultSet restult=connect.resultSet("BestBuyLaptopSKU");
        List<WebElement> list = getListOfWebElementsByXpath("//li [@class='sku-id']");

        for (int i = 0; i < list.size(); i++) {

            String actual =list.get(i).getText();
            restult.next();
            String expected = restult.getString("SKU");
            try {
                Assert.assertEquals(actual, expected);
            }catch (AssertionError error){error.printStackTrace();
                System.out.println(expected+" , " +actual+ "   did not match so failed");
            }

        }

    }
}
