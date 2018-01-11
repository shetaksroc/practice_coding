package com.example.thrones.utils;

import java.util.HashMap;

/**
 * Created by akshay on 09/12/17.
 */
public class GeneralUtils {
    public static HashMap<Character,Integer> getCharCountMap(String str){
        try {
            HashMap<Character,Integer> countMap=new HashMap<Character, Integer>();
            for(char c:str.toCharArray()){
                if(null==countMap.get(c)){
                    countMap.put(c,1);
                }else{
                    countMap.put(c,countMap.get(c)+1);
                }
            }
            return countMap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
