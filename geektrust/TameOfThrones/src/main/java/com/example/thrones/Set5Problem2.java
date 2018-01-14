package com.example.thrones;

import com.example.thrones.entity.Emperor;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static com.example.thrones.constants.Constants.ALLIES_OF_RULER;
import static com.example.thrones.constants.Constants.WHO_IS_EMPEROR;

/**
 * Created by akshay on 14/01/18.
 */
public class Set5Problem2 {
    public static void main(String[] args){
        System.out.println("Breaker of Chains");
        Scanner in = new Scanner(System.in);
        Emperor winner=new Emperor();
        BallotEngine engine= null;
        try {
            engine = new BallotEngine();
        } catch (IOException e) {
            System.out.println("Cannot locate the msg file");
        }
        System.out.println(WHO_IS_EMPEROR);
        System.out.println(winner.getName());
        System.out.println(ALLIES_OF_RULER);
        System.out.println(winner.getAllies().size()==0?"None":winner.getAllies());

        System.out.println("Enter the kingdoms competing to be the ruler: ");
        String[] contestKindoms=in.nextLine().toUpperCase().split(" ");
        int ballotCount=0;
        while (true){
            ballotCount+=1;
            System.out.println("Results after round "+ ballotCount+ " ballot count");
            engine.broadCastMsgs(contestKindoms);
            engine.printResults();
            if(engine.checkIfAnyTiesInBallot()){
                continue;
            }else {
                winner = engine.getWinner();
                System.out.println(WHO_IS_EMPEROR);
                System.out.println(winner.getName());
                System.out.println(ALLIES_OF_RULER);
                System.out.println(winner.getAllies().size()==0?"None":winner.getAllies());
                break;
            }
        }

    }
}
