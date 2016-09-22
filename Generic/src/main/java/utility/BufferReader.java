package utility;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

import static java.awt.SystemColor.text;

/**
 * Created by kayabegum on 9/15/2016.
 */
public class BufferReader {

    public String BufferReadermethod(String path) {
        StringBuffer stringBR = new StringBuffer();
        try {

            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String text;
            while ((text= br.readLine()) != null) {
//                System.out.println(text);
                    stringBR.append(text);
            }
        } catch (Exception ex)

        {
            System.out.println("path does not exist,please input a correct path");
        }
           return stringBR.toString();
    }
}