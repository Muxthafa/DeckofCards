package com.bridgelabz;

public class Cards {
	
	private String rank;
	private String suit;
	
	/**
	* Cards Constructor initialized during object creation
	* set suit and rank values
	*/
	public Cards(String suit, String rank) 
	{
	    this.suit = suit;
	    this.rank = rank;
	}
	
	/**
	 * @method returns current card objects rank
	 */
	public String getRank() {
		return this.rank;
	}

	/**
	 * @method returns current card objects suit
	 */
	public String getSuit() {
		return this.suit;
	}
	
	public String toString() {
		return suit+" "+rank;
	}
}
