/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package defense_system;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
interface InnerDefense_System {
    public void scroll20();
    public void scroll40();
    public void scroll60();
    public void scroll80();
    public void scrollBelow20();
    public void scrollBelow40();
    public void scrollBelow60();
    public void scrollBelow80();
    public void receiveMessageFrommain(String message);
    public void receiveMessageFrommainHelicopter(String message);
    public void receiveMessageFrommainSubmarine(String message);
    public void receiveMessageFrommainTank(String message);
    public void areaClearSend();
    public void areaNotClear();
    public void assignLinkToMain(MainController mainController);
    public void sendInformationHelicopter();
    public void sendInformationSubmarine();
    public void sendInformationTank();
    
} 
interface SetDefenseSystem{
    public void setLevel(int level);
    public void setMainClassLink(MainController mainController);
    public void sendMessageFromMain(String message,String type);
    public void areaClear(int mark);
    public void collectInformation(String type);
}

public class Defense_System implements SetDefenseSystem {
    private int level;
    private int mark;
    private ArrayList<InnerDefense_System> observerList = new ArrayList<>();

    public void addObjects(InnerDefense_System innerDefense_System){
        observerList.add(innerDefense_System);
    }

    public void collectInformation(String type){
        if (type.equals("Helicopter")) {
            for (InnerDefense_System innerDefense_System : observerList) {
                innerDefense_System.sendInformationHelicopter();
            }
        }else if (type.equals("Submarine")) {
            for (InnerDefense_System innerDefense_System : observerList) {
                innerDefense_System.sendInformationSubmarine();
            }
        }else if (type.equals("Tank")) {
            for (InnerDefense_System innerDefense_System : observerList) {
                innerDefense_System.sendInformationTank();
            }
        }
    }

    public void setMainClassLink(MainController mainController){
        for (InnerDefense_System innerDefense_System : observerList) {
            innerDefense_System.assignLinkToMain(mainController);
        }
    }

    public void sendMessageFromMain(String message,String type){
        if (type.equals("")) {
            for (InnerDefense_System innerDefense_System : observerList) {
                innerDefense_System.receiveMessageFrommain(message);
            }
        }else if (type.equals("Helicopter")) {
            for (InnerDefense_System innerDefense_System : observerList) {
                innerDefense_System.receiveMessageFrommainHelicopter(message);
            }
        }else if (type.equals("Tank")) {
            for (InnerDefense_System innerDefense_System : observerList) {
                innerDefense_System.receiveMessageFrommainTank(message);
            }
        }else if (type.equals("Submarine")) {
            for (InnerDefense_System innerDefense_System : observerList) {
                innerDefense_System.receiveMessageFrommainSubmarine(message);
            }
        }
        
    }

    public void areaClear(int mark){
        if (this.mark!=mark) {
            this.mark=mark;
        }
        if (mark==1) {
            for (InnerDefense_System innerDefense_System : observerList) {
                innerDefense_System.areaClearSend();
            }
        }else if (mark!=1) {
            for (InnerDefense_System innerDefense_System : observerList) {
                innerDefense_System.areaNotClear();
            }
        }
    }        

    public void setLevel(int level){
        if (this.level<=level) {
            this.level=level;
            if (this.level>=20 && this.level<40) {
                notifyObjects20();
            }else if (this.level>=40 && this.level<60) {
                notifyObjects20();
                notifyObjects40();
            }else if (this.level>=60 && this.level<80) {
                notifyObjects20();
                notifyObjects40();
                notifyObjects60();
            }else if (this.level>=80) {
                notifyObjects20();
                notifyObjects40();
                notifyObjects60();
                notifyObjects80();
            }
        }else{
            this.level=level;
            if (this.level<20) {
                notifyObjectsBelow20();
            }else if (this.level<40 && this.level>=20) {
                notifyObjectsBelow40();
            }else if (this.level<60 && this.level>=40) {
                notifyObjectsBelow60();
            }else if (this.level<80 && this.level>=60) {
                notifyObjectsBelow80();
            }
        }
        
        
    }

    public void notifyObjectsBelow20(){
        for (InnerDefense_System innerDefense_System : observerList) {
            innerDefense_System.scrollBelow20();
        }
    }
    public void notifyObjectsBelow40(){
        for (InnerDefense_System innerDefense_System : observerList) {
            innerDefense_System.scrollBelow40();
        }
    }
    public void notifyObjectsBelow60(){
        for (InnerDefense_System innerDefense_System : observerList) {
            innerDefense_System.scrollBelow60();
        }
    }
    public void notifyObjectsBelow80(){
        for (InnerDefense_System innerDefense_System : observerList) {
            innerDefense_System.scrollBelow80();
        }
    }

    public void notifyObjects20(){
        for (InnerDefense_System innerDefense_System : observerList) {
            innerDefense_System.scroll20();
        }
    }
    public void notifyObjects40(){
        for (InnerDefense_System innerDefense_System : observerList) {
            innerDefense_System.scroll40();
        }
    }
    public void notifyObjects60(){
        for (InnerDefense_System innerDefense_System : observerList) {
            innerDefense_System.scroll60();
        }
    }
    public void notifyObjects80(){
        for (InnerDefense_System innerDefense_System : observerList) {
            innerDefense_System.scroll80();
        }
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        

    }
    
}
