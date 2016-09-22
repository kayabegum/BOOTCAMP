package Comment;

import Commenting.CommentBox;
import com.gargoylesoftware.htmlunit.Page;
import common.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utility.BufferReader;

/**
 * Created by kayabegum on 9/18/2016.
 */
public class CommentingOnPosts extends Base {


    //comment on post
    @Test
    public void commentingOnPosts()throws Exception {
        BufferReader Bf = new BufferReader();
        CommentBox CB = PageFactory.initElements(driver, CommentBox.class);
        CB.enterEmail("teamdautomation@gmail.com");
        CB.enterPass("teamd123");
        sleepFor(5);
        scrollPageDown400();
        CB.ClickCommentBox();
        CB.EnterText(Bf.BufferReadermethod("C:\\Users\\kayabegum\\Desktop\\new\\BOOTCAMP\\Facebook\\Data\\SendingText.txt"));
    }
///                  //Upload an image in the comment
//        @Test
//        public void upLoadImageOnCommentingOnPosts()throws Exception{
//            BufferReader Bf=new BufferReader();
//            CommentBox CB=PageFactory.initElements(driver,CommentBox.class);
//            CB.enterEmail("teamdautomation@gmail.com");
//            CB.enterPass("teamd123");
//            sleepFor(5);
//            scrollPageDown400();
//            CB.ClickCommentBox();
//            String imagePath = "C:\\Users\\kayabegum\\Desktop\\flower.jpg";
//            sendImage("#js_g",imagePath);
//            CB.EnterText("flower");
//
//    }
}
