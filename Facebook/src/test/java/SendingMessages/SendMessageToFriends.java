package SendingMessages;

import FacebookPageFactory.SendMessages;
import com.gargoylesoftware.htmlunit.Page;
import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utility.BufferReader;

/**
 * Created by kayabegum on 9/15/2016.
 */
public class SendMessageToFriends extends Base {


    //users are able to send messages to friends
    //using buffer reader to send messages
    @Test
    public void SendMessage()throws Exception{
        BufferReader Bf=new BufferReader();
        SendMessages send= PageFactory.initElements(driver,SendMessages.class);
        send.email();
        send.password();
        sleepFor(5);
        send.clickmessage();
        send.writeMessage(Bf.BufferReadermethod("C:\\Users\\kayabegum\\Desktop\\new\\BOOTCAMP\\Facebook\\Data\\SendingText.txt"));

    }
    @Test
    public void SendImage()throws Exception {
        SendMessages send = PageFactory.initElements(driver, SendMessages.class);
        send.email();
        send.password();
        sleepFor(5);
        send.clickmessage();
        sleepFor(2);

        String imagePath = "C:\\Users\\kayabegum\\Desktop\\flower.jpg";
        sendImage("//*[@id='u_jsonp_2_6']",imagePath);
        send.writeMessage("flower for you ");
    }
    }
