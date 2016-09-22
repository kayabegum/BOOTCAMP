package HomePage;

import AmazonPageFactory.Home;
import common.Base;
import org.junit.runner.Result;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utility.ConnectMySqlDB;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kayabegum on 9/13/2016.
 */
public class Search extends Base {

//    //users are able to search items
//    @Test(priority = 2)
//    public void Search() {
//        Home home = PageFactory.initElements(driver, Home.class);
//        home.search("laptop");
//    }
    //users are able to search using excel

    //users are able to search using data base
    @Test(priority = 3)
    public void SearchFromDB() throws SQLException, IOException, ClassNotFoundException, InterruptedException {
        ConnectMySqlDB connect = new ConnectMySqlDB();
        Home home = PageFactory.initElements(driver, Home.class);
        ResultSet result = connect.resultSet("searchitem");
        while (result.next()) {
            sleepFor(2);
            home.search(result.getString("list"));
            sleepFor(2);
            home.clear();
        }
    }
}
