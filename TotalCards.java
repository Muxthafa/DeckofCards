package com.bridgelabz;

import java.util.ArrayList;

public class TotalCards {

	ArrayList<Cards> cardsForEachPlayer;
	
	public TotalCards() {
		cardsForEachPlayer = new ArrayList<Cards>(9);
	}
	
	/**
     * to add a value to the hand
     * @param a card value
     */
    public void setCard(Cards cardPerPlayer)
    {
        this.cardsForEachPlayer.add(cardPerPlayer);
    }
    
    public ArrayList<Cards> displayCards() {
    	return this.cardsForEachPlayer;
    }
}
