package _01_Spies_On_A_Train;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
    String findIntel(LinkedList<TrainCar> train, String[] clues) {
    	ArrayList <String> culpList = new ArrayList<String>();
    	ArrayList<String> trueTest = new ArrayList<String>();
    	String culp = "";
    	for (int i = 0; i < train.size(); i++) {
			for (int j = 0; j < clues.length; j++) {
			if (train.getHead().getValue().questionPassenger().contains(clues[j])) {
				trueTest.add(clues[j]);
				String[] sentSplit = train.getHead().getValue().questionPassenger().split("[ ]");
				System.out.println(sentSplit.length);
				if (culpList.contains(sentSplit[13])) {
						culpList.removeAll(culpList);
						culpList.add(sentSplit[13]);
						break;
				}
				culpList.add(sentSplit[13]);
				
			}
			}
			
    			System.out.println(train.getHead().getValue().questionPassenger());
				train.getHead().setPrev(train.getHead());
				train.setHead(train.getHead().getNext());
		}
    	
				culp=culpList.get(0);	
			System.out.println(culp);
		
	
			
		
        return culp;

    }

}
