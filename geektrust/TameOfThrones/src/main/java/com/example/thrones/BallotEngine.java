package com.example.thrones;

import com.example.thrones.entity.Emperor;
import com.example.thrones.entity.Messenger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.example.thrones.constants.Constants.MESSAGES_FILE_PATH;
import static com.example.thrones.constants.Constants.CONTESTANTS_COUNT_MIN;
import static com.example.thrones.constants.Constants.kingdoms;

/**
 * Created by akshay on 14/01/18.
 */
public class BallotEngine {

    private List<String> msgList=new ArrayList<String>();
    private Map<String,Emperor> emperorBallotResult=new HashMap<String, Emperor>();

    public BallotEngine() throws IOException {
        this.msgList= FileUtils.readLines(new File(MESSAGES_FILE_PATH));
    }

    public void broadCastMsgs(String[] contestants){
        for(String kingdom:contestants){
            Emperor empObj;
            if(emperorBallotResult.containsKey(kingdom)){
                empObj=emperorBallotResult.get(kingdom);
            }else{
                empObj=new Emperor(kingdom);
            }
            broadCastMsg(contestants,kingdom,empObj);
            emperorBallotResult.put(kingdom,empObj);
        }
    }

    private void broadCastMsg(String[] contestants, String senderKingdom, Emperor empObj){
        ArrayList<String> contestantsList=new ArrayList<String>(Arrays.asList(contestants));
        for(String receiverKingdom:kingdoms){
            if(!StringUtils.equalsIgnoreCase(receiverKingdom,senderKingdom)){
                Random random=new Random();
                int i=random.nextInt(msgList.size());
                Messenger messenger=new Messenger(receiverKingdom,msgList.get(i).trim());
                System.out.println("Sender Kingdom: "+ senderKingdom);
                System.out.println("Receiver Kingdom: "+ receiverKingdom);
                System.out.println("Message Sent: "+ msgList.get(i).trim());
                if(messenger.isMessageAccepted()){
                    if(!contestantsList.contains(receiverKingdom)){
                        empObj.addAllies(receiverKingdom.toUpperCase());
                    }
                }
            }
        }
    }

    public boolean checkIfAnyTiesInBallot() {
        int max=0,count=0;
        if(emperorBallotResult.size()== CONTESTANTS_COUNT_MIN){
            return false;
        }
        for (Map.Entry<String,Emperor> entry:emperorBallotResult.entrySet()){
            if(entry.getValue().getAllies().size()>max){
                max=entry.getValue().getAllies().size();
                count=1;
            }else if(entry.getValue().getAllies().size()==max){
                count+=1;
            }
        }
        if(count> CONTESTANTS_COUNT_MIN){
            return true;
        }else {
            return false;
        }
    }


    public void printResults() {
        for (Map.Entry<String,Emperor> entry:emperorBallotResult.entrySet()){
            System.out.println("Allies for "+ entry.getKey()+ ": "+entry.getValue().getAllies().size());
        }
    }

    public Emperor getWinner() {
        Emperor winner=null;
        int max=0;
        for (Map.Entry<String,Emperor> entry:emperorBallotResult.entrySet()){
            if(entry.getValue().getAllies().size()>max){
                winner=entry.getValue();
                max=entry.getValue().getAllies().size();
            }
        }
        return winner;
    }
}
