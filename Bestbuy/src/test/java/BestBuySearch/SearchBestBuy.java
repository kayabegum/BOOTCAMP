package BestBuySearch;

import PageFactory.BestBuySearchPageFactory;
import common.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utility.ConnectMySqlDB;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by kayabegum on 9/14/2016.
 */
public class SearchBestBuy extends Base {


    //users are able to search for items on the search box
    //searching using data base
    @Test(priority = 1)
    public void searchUsingDataBase()throws Exception{
        BestBuySearchPageFactory pf= PageFactory.initElements(driver, BestBuySearchPageFactory.class);
        ConnectMySqlDB connect= new ConnectMySqlDB();
        clickByCss(".close");
        List<String> SearchItems=connect.readDataBase("searchitem","list");
        for(String Items:SearchItems){
            pf.searchFor(Items);
            sleepFor(2);
            pf.clearSearchBox();
        }
    }

}
