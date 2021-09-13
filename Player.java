package com.bridgelabz;

import java.util.ArrayList;
import java.util.Random;

/**
 * player class 
 * @author Mohammad Musthafa_ym
 *
 */
public class Player {
	Random randomOrder = new Random();
	int numberOfPlayers;
	ArrayList<Integer> sequence=new ArrayList<Integer>(numberOfPlayers);
	
	ArrayList<TotalCards> players;
	
	/**
	 * constructor to initialize number of players playing the game
	 * @param n
	 */
	Player(int n){
		System.out.println(n+" players are added to the game!");
		numberOfPlayers=n;
		players= new ArrayList<TotalCards>(numberOfPlayers);
		for(int i=0;i<n;i++)
            players.add(i,new TotalCards());
	}
	
	/**
	 * @method to sequence the players order
	 */
	public void orderPlayer() {
		Integer rand;
		int count=0;
		while(numberOfPlayers > count) {
			rand = randomOrder.nextInt(4);
			if(sequence.contains(rand)) {
				continue;
			}else {
				sequence.add(rand);
				count++;
			}	
		}
	}
	
	/**
	 * @method distribute cards according to player sequence
	 * @param cards
	 */
	public void distributeCards(ArrayList<Cards> cards) {
		int countCards=0;
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < numberOfPlayers; j++) {
				TotalCards eachPlayer = players.get(sequence.get(j));
				eachPlayer.setCard(cards.get(countCards));		// set each player object with a card
				countCards++;
			}
		}
		
		//for loop to display cards of each player
//		for(int i=0;i<numberOfPlayers;i++) {
//			TotalCards eachPlayer=players.get(sequence.get(i));
//			System.out.println("Player "+(i+1)+" has");
//			System.out.println(eachPlayer.displayCards());
//		}
	}
	
	/**
	 * @method to output count of different type of cards received by a player
	 */
	public void suitsForEachPlayer() {
		for(int i=0;i<numberOfPlayers;i++) {
			TotalCards eachPlayer=players.get(sequence.get(i));
			System.out.println("Player "+(i+1)+" has"+" recieved");
			System.out.println(eachPlayer.suitsCardsForEach());
		}
	}
	
	
}
