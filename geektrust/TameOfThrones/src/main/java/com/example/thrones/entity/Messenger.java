package com.example.thrones.entity;

import com.example.thrones.constants.Constants;
import com.example.thrones.utils.GeneralUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Created by akshay on 09/12/17.
 */
public class Messenger {

    private String kingdom;
    private String msg;

    public Messenger(String kingdom, String msg) throws IllegalArgumentException {
        validateNullOrEmpty(kingdom);
        validateNullOrEmpty(msg);
        validateKingdom(kingdom);
        this.kingdom = kingdom.toUpperCase();
        this.msg = msg.toLowerCase();
    }

    /**
     * Validate whether the given kingdom is valid or not
     * @param kingdomArg
     */
    private void validateKingdom(String kingdomArg){
        if(StringUtils.isBlank(Constants.Animal.valueOf(kingdomArg.toUpperCase()).toString())){
            throw new IllegalArgumentException("Invalid kingdom name provided");
        }
    }

    /**
     * Check whether the string is empty or null or blank
     * @param arg
     */
    private void validateNullOrEmpty(String arg){
        if(StringUtils.isBlank(arg)){
            throw new IllegalArgumentException("Kingdom/Msg cannot be empty");
        }
    }

    /**
     * Method to check whether the given kingdom accepts the msg or not, If the msg is accepted return true else return false
     * @return
     */
    public boolean isMessageAccepted(){
        HashMap<Character,Integer> animalCountMap=Constants.Animal.valueOf(kingdom).getName();
        HashMap<Character,Integer> msgCountMap= GeneralUtils.getCharCountMap(msg);

        if(!animalCountMap.isEmpty()){
            for(Map.Entry<Character,Integer> entry:animalCountMap.entrySet()){
                if(!msgCountMap.containsKey(entry.getKey())){
                    return false;
                }else{

                    if(entry.getValue().intValue()>msgCountMap.get(entry.getKey()).intValue()){
                        return false;
                    }
                }
            }
        }else{
            return false;
        }
        return true;
    }




}
