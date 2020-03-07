package cs2365_project2;

import java.util.*;

class Deck
{
    private ArrayList<Card> D = new ArrayList<Card>();
    
    private int RepsDone = 0;
    private int RepsSkipped = 0;
    private int MaxReps = 0;
    
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
    
    
    ArrayList<Card> ShuffleDeck(ArrayList<Card> DeckToShuffle)
    {
        Collections.shuffle(DeckToShuffle);
        return DeckToShuffle;
    }
    
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
    
    public ArrayList<Card> GetDeck()
    {
        return D;
    }
    
    public void RefillDeck(ArrayList<Card> NewDeck)
    {
        D.clear();
        
        for(int a = 0; a < NewDeck.size(); a++)
        {
            D.add(NewDeck.get(a));
        }
    }
    
    
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
    
    
    public void StatCollection(int Reps, int SkippedReps, int MR)
    {
        RepsDone += Reps;
        RepsSkipped += SkippedReps;
        
        if(MR > MaxReps)
        {
            MaxReps = MR;
        }
    }
    
    public void DisplayStatData()
    {
        System.out.println("---Stats about the decks workout---\n");
        System.out.println("Total Reps performed - " + RepsDone + "\n");
        System.out.println("Total Reps Skipped - " + RepsSkipped + "\n");
        System.out.println("Total Most Reps performed in a hand - " + MaxReps + "\n");
    }

}