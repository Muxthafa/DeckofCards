package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * player class 
 * @author Mohammad Musthafa
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
		
//		for loop to display cards of each player
		for(int i=0;i<numberOfPlayers;i++) {
			TotalCards eachPlayer=players.get(sequence.get(i));
			System.out.println("Player "+(i+1)+" has");
			System.out.println(eachPlayer.getCards());
		}
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
	
	/**
	 * @method to order the cards in sequence of
	 * lower rank to higher rank
	 */
	public void sortCards() {
		for (TotalCards player : players) {
			// hand of the player
			ArrayList<Cards> playerIterate = player.getCards();
			// to sort the cards
			for (int i = 0; i < playerIterate.size(); i++) {
				for (int j = 0; j < playerIterate.size() - i - 1; j++) {
					// get the card
					Cards rankOfPlayer1 = playerIterate.get(j);
					Cards rankOfPlayer2 = playerIterate.get(j + 1);
					// to compare which card has highest rank
					if (compare(rankOfPlayer1, rankOfPlayer2) == rankOfPlayer2) {
						// replace the cards
						playerIterate.set(j, rankOfPlayer2);
						playerIterate.set(j + 1, rankOfPlayer1);
					}
				}
			}
		}
		for(int i=0;i<numberOfPlayers;i++) {
			TotalCards eachPlayer=players.get(sequence.get(i));
			System.out.println("Player "+(i+1)+" has");
			System.out.println(eachPlayer.getCards());
		}
	}
	
	/**
	 * @method to return lower rank card
	 * @param rankOfPlayer1
	 * @param rankOfPlayer2
	 * @return
	 */
	public Cards compare(Cards rankOfPlayer1, Cards rankOfPlayer2) {
		final List<String> rankings = new ArrayList<String>(
				List.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"));
		if (rankings.indexOf(rankOfPlayer1.getRank()) < rankings.indexOf(rankOfPlayer2.getRank()))
			return rankOfPlayer1;
		else
			return rankOfPlayer2;
	}
	
}
