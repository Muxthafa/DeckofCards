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
	
	/**
	 * constructor to initialize number of players playing the game
	 * @param n
	 */
	Player(int n){
		System.out.println(n+" players are added to the game!");
		numberOfPlayers=n;
		ArrayList<TotalCards> players= new ArrayList<TotalCards>(numberOfPlayers);
	}
	
	/**
	 * @method to sequence the players order
	 */
	public void orderPlayer() {
		ArrayList<Integer> sequence=new ArrayList<Integer>(numberOfPlayers);
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
}
