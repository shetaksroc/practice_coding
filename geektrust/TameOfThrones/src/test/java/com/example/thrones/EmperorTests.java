package com.example.thrones;

import com.example.thrones.constants.Constants;
import com.example.thrones.entity.Emperor;
import org.junit.Assert;
import org.junit.Test;

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
        emperor.addAllies(Constants.KINGDOM_ANIMAL_PAIR.AIR.toString());
        emperor.addAllies(Constants.KINGDOM_ANIMAL_PAIR.WATER.toString());
        emperor.addAllies(Constants.KINGDOM_ANIMAL_PAIR.ICE.toString());
        emperor.validateEmperorName();
        Assert.assertEquals(Constants.EMPEROR_NAME,emperor.getName());
    }

    @Test
    public void testEmperorNameWhenTwoAlliesArepresent(){
        Emperor emperor=new Emperor();
        emperor.addAllies(Constants.KINGDOM_ANIMAL_PAIR.AIR.toString());
        emperor.addAllies(Constants.KINGDOM_ANIMAL_PAIR.WATER.toString());
        emperor.validateEmperorName();
        Assert.assertEquals("None",emperor.getName());
    }

}
