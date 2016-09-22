package ExcelDataReader;

import utility.DataReader;

import java.io.IOException;

/**
 * Created by KayaBegum on 9/18/2016.
 */
public class SearchList {
    DataReader data=new DataReader();
    public String [] getData(String Filepath)throws IOException{
        String path=System.getProperty("user.dir")+Filepath;
        String [] st=data.fileReader(path);
        return st;
    }
}
