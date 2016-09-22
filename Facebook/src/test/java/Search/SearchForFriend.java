package Search;

import FacebookPageFactory.SearchingForFriends;
import common.Base;
import dataToSearch.SearchList;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by kayabegum on 9/5/2016.
 */
public class SearchForFriend extends Base {


    @Test
    public void searchFromExcelFile()throws InterruptedException,IOException,FileNotFoundException {
        SearchingForFriends SI=PageFactory.initElements(driver,SearchingForFriends.class);
        waitUntilClickAble(By.cssSelector("#email"));
        SI.email();
        SI.pass();
        sleepFor(10);
        waitUntilClickAble(By.cssSelector("._1frb"));
        sleepFor(10);

        SearchList dr= new SearchList();
        String [] value=dr.getData();
        for(String read:value){
        SI.search(read);
            sleepFor(2);
            SI.clear();
        }
//        SI.email();
    }
}
