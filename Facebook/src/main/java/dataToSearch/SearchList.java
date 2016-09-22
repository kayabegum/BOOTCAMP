package dataToSearch;

import utility.DataReader;

import java.io.IOException;

/**
 * Created by kayabegum on 9/5/2016.
 */
public class SearchList {
    DataReader data=new DataReader();
    public String [] getData()throws IOException{
        String path=System.getProperty("user.dir")+"/Data/FBFriendsList.xls";

        String [] st=data.fileReader(path);
        return st;
    }
}
