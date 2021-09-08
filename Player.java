package com.bridgelabz;
/**
 * player class 
 * @author Mohammad Musthafa_ym
 *
 */
public class Player {
	
	int numberOfPlayers;
	
	/**
	 * constructor to initialize number of players playing the game
	 * @param n
	 */
	Player(int n){
		System.out.println(n+" players are added to the game!");
		numberOfPlayers=n;
	}
}
