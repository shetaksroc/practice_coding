package com.example.thrones;

import com.example.thrones.entity.Emperor;
import com.example.thrones.entity.Messenger;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

import static com.example.thrones.constants.Constants.ALLIES_OF_RULER;
import static com.example.thrones.constants.Constants.EMPEROR_NAME;
import static com.example.thrones.constants.Constants.WHO_IS_EMPEROR;

/**
 * Created by akshay on 09/12/17.
 *
 */
public class Set5Problem1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Emperor emperor=new Emperor();

        System.out.println(WHO_IS_EMPEROR);
        System.out.println(emperor.getName());
        System.out.println(ALLIES_OF_RULER);
        System.out.println(emperor.getAllies().size()==0?"None":emperor.getAllies());


        while(true){
            System.out.println("Enter msg to the kingdoms:");
            String nextLine=in.nextLine();
            if(nextLine.equalsIgnoreCase("quit") || nextLine.equalsIgnoreCase("")){
                break;
            }
            String[] msg=nextLine.split(",");
            try {
                Messenger messenger=new Messenger(msg[0].trim(),msg[1].trim());
                if(messenger.isMessageAccepted()){
                    emperor.addAllies(msg[0].trim().toUpperCase());
                    emperor.validateEmperorName();
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            System.out.println("Msg successfully sent to the requested kingdoms");
        }

        System.out.println(WHO_IS_EMPEROR);
        System.out.println(emperor.getName());
        System.out.println(ALLIES_OF_RULER);
        System.out.println(emperor.getAllies());

    }

}
