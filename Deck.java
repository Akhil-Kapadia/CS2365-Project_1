package cs2365_project2;

import java.util.*;

/**
     * Deck class holds up to 108 cards that it creates and stores in an ArrayList.
     * Function can shuffle the deck, refill the deck for the use of combining multiple Decks
     * Delete all special cards, check if the deck is empty, and it draws hands for the player.
     * Also has several stat collection functions that will store data for each deck
     * 
     * @author Colin Morrison
     */
class Deck
{
    private ArrayList<Card> D = new ArrayList<Card>();
    
    private int RepsDone = 0;
    private int RepsSkipped = 0;
    private int MaxReps = 0;
    
      /**
     * Function creates a new deck of uno cards with given color, rank, and/or special types
     * Adds the newly created Card object and stores it in an ArrayList
     */
    public void CreateDeck()
    {
        for(int a = 0; a < 4; a++)
        {
            String C = "";
            if( a == 0)
            {
                C = "Red";
            }
            else if(a == 1)
            {
                C = "Green";
            }
            else if( a == 2)
            {
                C = "Blue";
            }
            else
            {
                C = "Yellow";
            }
            
            for(int b = 0; b < 25; b++)
            {
                if( b < 10)
                {
                    //will do cards 0 - 9 value
                    Card CRD = new Card(b, C, "");
                    D.add(CRD);
                }
                else if(b < 19)
                {
                    //will do cards 1 - 9 value
                    Card CRD = new Card(b-9, C, "");
                    D.add(CRD);
                }
                else if(b < 21)
                {
                    //Special Cards
                    Card CRD = new Card(0, C, "Skip");
                    D.add(CRD);
                }
                else if( b < 23)
                {
                    Card CRD = new Card(0, C, "Draw Two");
                    D.add(CRD);
                }
                else
                {
                    Card CRD = new Card(0, C, "Reverse");
                    D.add(CRD);
                }
                
            }   
            
        }
        
        for(int a = 0; a < 8; a++)
        {
            if( a < 4)
            {
                Card CRD = new Card(0, "", "Wild");
                D.add(CRD);   
            }
            else
            {
               Card CRD = new Card(0, "", "Wild Draw 4");
               D.add(CRD);      
            }
        }
        
        D = ShuffleDeck(D);

        
    }
    
    /**
     * Simply gets the amount of Cards left on the deck, which is just the size of the Deck ArrayList
     * returns the size
     * @return
     */
    public int CardsLeftOnDeck()
    {
        return D.size();
    }
    
    /**
     * Function will randomly shuffle the ArrayList of Cards using Collections.Shuffle
     * returns a shuffled ArrayList of Cards
     * @param DeckToShuffle
     * @return
     */
    ArrayList<Card> ShuffleDeck(ArrayList<Card> DeckToShuffle)
    {
        Collections.shuffle(DeckToShuffle);
        return DeckToShuffle;
    }
    
    /**
     * Function takes 7 or less cards from the deck List, and returns them as a Hand, while
     * also removing the cards drawn from the List in the Deck
     * returns ArrayList of Cards
     * @param Amount
     * @return
     */
    public ArrayList<Card> DrawCards(int Amount)
    {
        ArrayList<Card> DealOut = new ArrayList<Card>();
        if(Amount > D.size())
        {
            Amount = D.size();
        }
        
        int index = 0;
        for(int a = D.size()-1; a >= 0 && index < Amount; a--)
        {
            if(D.get(a) != null)
            {
                DealOut.add(D.get(a));
                index++;
                        
            }
            
        }
        
        index = 0;
        for(int a = D.size() -1; a >= 0 && index < Amount; a--)
        {
            if(D.get(a) != null)
            {
                D.remove(D.get(a));
                index++;
            }
            
        }
        
        
        
        
        return DealOut;
    }
    
    /**
     * Getter method that returns the deck in the class
     * returns ArrayList of Cards
     * @return
     */
    public ArrayList<Card> GetDeck()
    {
        return D;
    }
    
    /**
     * Function that Refills the Deck of Cards List, with a new Deck of Cards that was passed in
     * @param NewDeck
     */
    public void RefillDeck(ArrayList<Card> NewDeck)
    {
        D.clear();
        
        for(int a = 0; a < NewDeck.size(); a++)
        {
            D.add(NewDeck.get(a));
        }
    }
    
    /**
     * If the user wants, this function goes through the Deck of Cards list and removes any special Cards
     */
    public void RemoveSpecialCards()
    {
        for(int a = 0; a < D.size(); a++)
        {
            boolean isS = D.get(a).getSpecial();
            if(isS)
            {
                D.remove(D.get(a));
            }
        }
    }
    
      /**
     * Function checks if the size of the Deck of Cards list is greater than 0
     * returns a boolean if the List if size 0 or not
     * @return
     */
    public boolean isEmpty()
    {
        if(D.size() <= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
     /**
     * Function used for Stat Collection, each param passed gets added to global variables
     * @param Reps
     * @param SkippedReps
     * @param MR
     */
    public void StatCollection(int Reps, int SkippedReps, int MR)
    {
        RepsDone += Reps;
        RepsSkipped += SkippedReps;
        
        if(MR > MaxReps)
        {
            MaxReps = MR;
        }
    }
    
     /**
     * Function takes all the stat data within the deck and puts them into an array of int's
     * returns an array of ints
     * @return
     */
    public int[] UDateStatData()
    {
        int[] Table = new int[3];
        
        Table[0] = RepsDone;
        Table[1] = RepsSkipped;
        Table[2] = MaxReps;
        
        return Table;
    }

}