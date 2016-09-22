package LikeAPost;

import Commenting.CommentBox;
import LikingPostsOnFacebook.LikingPost;
import common.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utility.BufferReader;

/**
 * Created by kayabegum on 9/18/2016.
 */
public class LikingAPost extends Base {
    @Test
    public void commentingOnPosts()throws Exception {
//
       LikingPost LP = PageFactory.initElements(driver, LikingPost.class);
        LP.email();
        LP.pass();
        sleepFor(5);
        scrollPageDown400();
        LP.Like();
    }
    @Test

    public void SendFriendRequest() throws InterruptedException {
        typeByCss("#email", "teamdautomation@gmail.com");
        sleepFor(1);
        typeByCssNEnter("#pass", "teamd123");
        sleepFor(1);
        typeByCssNEnter("._1frb", "sohan mahmud");
        sleepFor(1);
        clickByCss("._42ft._4jy0.FriendRequestAdd.addButton._4jy3._517h._51sy");
    }
    @Test
    public void postOnFriendsWall() throws InterruptedException {
        typeByCss("#email", "teamdautomation@gmail.com");
        sleepFor(1);
        typeByCssNEnter("#pass", "teamd123");
        sleepFor(1);
        sleepFor(1);
        typeByCssNEnter("._1frb", "sohan mahum");
        sleepFor(5);
        clickByCss("._5d-5");
        sleepFor(5);
        typeByCss("._4h98", "using automation to post on your wall-kaya");
        sleepFor(1);
        clickByCss("._1mf7._4jy0._4jy3._4jy1._51sy.selected._42ft");
        sleepFor(1);
    }
    @Test
    public void CheckFriendRequest()throws InterruptedException{
        typeByCss("#email","teamdautomation@gmail.com");
        sleepFor(5);
        typeByCssNEnter("#pass","teamd123");
        sleepFor(5);
        clickByCss("._2n_9");
        sleepFor(5);
    }
}

