package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Deck of card game
 * @author Mohammad Musthafa
 *
 */
public class DeckOfCards {
	
	private final String[] suits={"Spades", "Diamonds", "Clubs", "Hearts"};
	private final String[] ranks= {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	
	ArrayList<Cards> cards;		// cards array list declaration
	
	/**
	 * constructor displays welcome message
	 * initializes array list with size 52
	 */
	DeckOfCards(){
		System.out.println("Welcome to deck of cards game");
		cards = new ArrayList<>(52);
	}
	
	/**
	 * @method to make unique deck
	 * adds card object to array list
	 */
	void uniqueDeck() {
		String suit;
		String rank;
		for(int i=0;i<52;i++) {
			suit=suits[i/13];
			rank=ranks[i%13];
			cards.add(new Cards(suit,rank));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberOfPlayers;
        Scanner sc=new Scanner(System.in);
        
		DeckOfCards d = new DeckOfCards();		// object creation
		d.uniqueDeck();							// function call
		
		System.out.println("Enter the number of players");
		numberOfPlayers=sc.nextInt();			// number of player added from console
		if (numberOfPlayers < 2 || numberOfPlayers > 4) {
			System.out.println("Enter the value between 2 and 4");
			numberOfPlayers = sc.nextInt();
		}else {
			Player player=new Player(numberOfPlayers);
		}
		
	}

}
