package com.example.thrones;

import com.example.thrones.constants.Constants;
import com.example.thrones.entity.Emperor;
import com.example.thrones.entity.Messenger;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akshay on 09/12/17.
 */
public class EmperorTests {

    @Test
    public void testEmptyEmperorName(){
        Emperor emperor=new Emperor();
        Assert.assertEquals("None",emperor.getName());
    }

    @Test
    public void testEmperorNameWhenThreeAlliesArepresent(){
        Emperor emperor=new Emperor();
        emperor.addAllies(Constants.Animal.AIR.toString());
        emperor.addAllies(Constants.Animal.WATER.toString());
        emperor.addAllies(Constants.Animal.ICE.toString());
        emperor.validateEmperorName();
        Assert.assertEquals(Constants.EMPEROR_NAME,emperor.getName());
    }

    @Test
    public void testEmperorNameWhenTwoAlliesArepresent(){
        Emperor emperor=new Emperor();
        emperor.addAllies(Constants.Animal.AIR.toString());
        emperor.addAllies(Constants.Animal.WATER.toString());
        emperor.validateEmperorName();
        Assert.assertEquals("None",emperor.getName());
    }

}
