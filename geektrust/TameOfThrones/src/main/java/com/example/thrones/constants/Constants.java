package com.example.thrones.constants;

import com.example.thrones.utils.GeneralUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by akshay on 09/12/17.
 */
public class Constants {

    public static final String EMPEROR_NAME="King Shan";
    public static final String WHO_IS_EMPEROR="Who is the ruler of Southeros? ";
    public static final String ALLIES_OF_RULER="Allies of Ruler? ";
    public static final Integer MIN_ALLIES_FOR_EMPEROR=3;
    public static final Integer CONTESTANTS_COUNT_MIN =1;
    public static final String MESSAGES_FILE_PATH="src/main/resources/messageList.txt";


    public static List<String> kingdoms=new ArrayList<String>();

    static {
        kingdoms.add(KINGDOM_ANIMAL_PAIR.AIR.toString());
        kingdoms.add(KINGDOM_ANIMAL_PAIR.WATER.toString());
        kingdoms.add(KINGDOM_ANIMAL_PAIR.ICE.toString());
        kingdoms.add(KINGDOM_ANIMAL_PAIR.FIRE.toString());
        kingdoms.add(KINGDOM_ANIMAL_PAIR.LAND.toString());
    }

    public enum KINGDOM_ANIMAL_PAIR {
        LAND("panda"),WATER("octopus"),ICE("mammoth"),AIR("owl"),FIRE("dragon");

        private String name;

        KINGDOM_ANIMAL_PAIR(String animal) {
            this.name = animal;
        }

        public HashMap<Character,Integer> getName() {
            return GeneralUtils.getCharCountMap(name);
        }
    }
}
