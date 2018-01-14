package com.example.thrones;

import com.example.thrones.entity.Messenger;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by akshay on 13/12/17.
 */
public class MessengerTests {
    @Test
    public void testMsgAcceptance() throws Exception {
        Messenger messenger=new Messenger("AIR","Let’s swing the sword together");
        Assert.assertTrue(messenger.isMessageAccepted());
    }


    @Test
    public void testMsgAcceptance2() throws Exception {
        Messenger messenger=new Messenger("AIR","together");
        Assert.assertFalse(messenger.isMessageAccepted());
    }

    @Test
    public void testMsgAcceptance3() throws Exception {
        Messenger messenger=new Messenger("land","pand");
        Assert.assertFalse(messenger.isMessageAccepted());
    }

    @Test
    public void testMsgAcceptanceFire() throws Exception {
        Messenger messenger=new Messenger("fire","\"Death is so terribly final, while life is full of possibilities.\"");
        Assert.assertTrue(messenger.isMessageAccepted());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyMessengerObject(){
        Messenger messenger=new Messenger("","");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testNullMessengerObject(){
        Messenger messenger=new Messenger(null,null);
    }

    @Test
    public void testValidKingdom(){
        Messenger messenger=new Messenger("air","random");
        Assert.assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInValidKingdom(){
        Messenger messenger=new Messenger("ai","random");
    }
}
