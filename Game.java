package cs2365_project2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Game
{
    
    /*
        Game class has 3 methods, StartGame, FormatCardForWorkout, and GetMaxReps(For mathmatical purpose in Stat collection)
        Requires two other classes to function correctly, Deck and Card
        
        StartGame asks the user how many decks they want,
        asks the user whether or not to shuffle them all together
        asks the user whether or not they wish to remove Sepcial cards
        
        Proceeds to draw 7 cards, sends them to the FormatCardForWorkout method
        
        In the FormatCardForWorkout method, it counts the amount of reps of each workout
        then takes into account the special cards and proceeds to do the functions 
        listed in the project 2 document on blackboard
    
        Then the output is displayed per excersise in the console
    
        Then we jump back to the StartGame method and it proceeds to repeat this process
        until all the Decks have been used
    
    */
    

    public void StartGame(int Pick1, int Pick2, int Pick3)
    {
        Scanner input = new Scanner(System.in);
        
        if(Pick1 > 3)
        {
            Pick1 = 3;
        }
        else if(Pick1 <= 0)
        {
            Pick1 = 1;
        }
        
        //filling the Decks
        Deck[] Decks = new Deck[Pick1];
        
       for(int a = 0; a < Decks.length; a++)
       {
           Decks[a] = new Deck();
           Decks[a].CreateDeck();
       }
        
        //shuffling all the decks together
        if(Pick2 == 1 && Decks.length > 1)
        {
            ArrayList<Card> All = new ArrayList<Card>();
            for(int a = 0; a < Decks.length; a++)
            {
                ArrayList<Card> DeckInd = Decks[a].GetDeck();
                for(int b = 0; b < DeckInd.size(); b++)
                {
                    All.add(DeckInd.get(b));
                }
            }
            
            Collections.shuffle(All);
            
            //redistrbuting the cards into the decks
            int index = 0;
            for(int a = 0; a < Decks.length; a++)
            {
                ArrayList<Card> NewD = new ArrayList<Card>();
                for(int b = 0; b < 108; b++)
                {
                    if(All.get(index) != null)
                    {
                        NewD.add(All.get(index));
                        index++;
                    }
                }
                
                Decks[a].RefillDeck(NewD);
            }
        }
        
        //The Player can then choose to remove special cards!!!
        if(Pick3 == 1)
        {
            for(int a = 0; a < Decks.length; a++)
            {
                Decks[a].RemoveSpecialCards();
            }
        }
        
        //Let the game begin!
        
        ArrayList<Card> Hand = new ArrayList<Card>();
        for(int a = 0; a  < Decks.length; a++)
        {
            Hand.clear();
            
            while(!Decks[a].isEmpty())
            {
                if(Hand.size() == 0)
                {
                    ArrayList<Card> Temp = Decks[a].DrawCards(7);
                    
                    for(int b = 0; b < Temp.size(); b++)
                    {
                        Hand.add(Temp.get(b));
                    }
                    
                    //Hand has been filled
                    FormatCardForWorkout(Hand, Decks[a]);
                    
                    //Will draw a new hand
                    Temp.clear();
                    Hand.clear();
                    
                }
            }
            
            Decks[a].DisplayStatData();
        }
        
        System.out.println("Game over!!! Hopefully you had a good workout!");
        
        
   
    }
    
    
    void FormatCardForWorkout(ArrayList<Card> H, Deck D)
    {
        int RepsSitUps = 0;
        int RepsPushUps = 0;
        int RepsSquat = 0;
        int RepsLounges = 0;
        int Burpees = 0;
        
        int SkippedR = 0;
        
        for(int a = 0; a < H.size(); a++)
        {
            boolean isS = H.get(a).Special;
            int V = H.get(a).getValue();
            String Col = H.get(a).getString(true);
            String Spe = H.get(a).getString(false);
            
            if(!isS)
            {
                if(Col.equals(("Red")))
                {
                    RepsSitUps += V;
                }
                else if(Col.equals(("Blue")))
                {
                    RepsPushUps += V;
                }
                else if(Col.equals(("Yellow")))
                {
                    RepsSquat += V;
                }
                else
                {
                    //Green
                    RepsLounges += V;
                }
            }
        }
        
        
        for(int a = 0; a < H.size(); a++)
        {
            boolean isS = H.get(a).Special;
            int V = H.get(a).getValue();
            String Col = H.get(a).getString(true);
            String Spe = H.get(a).getString(false);
            
            if(isS)
            {
                if(Spe.equals("Skip"))
                {
                    if(Col.equals(("Red")))
                    {
                        SkippedR += RepsSitUps;
                        RepsSitUps = 0;
                    }
                    else if(Col.equals(("Blue")))
                    {
                        SkippedR += RepsPushUps;
                        RepsPushUps =0;
                    }
                    else if(Col.equals(("Yellow")))
                    {
                        SkippedR += RepsSquat;
                        RepsSquat =0;
                    }
                    else
                    {
                        //Green
                        SkippedR += RepsLounges;
                        RepsLounges = 0;
                    }  
                }
                else if(Spe.equals("Draw 2"))
                {
                    if(Col.equals(("Red")))
                    {
                        RepsSitUps *= 2;
                    }
                    else if(Col.equals(("Blue")))
                    {
                        RepsPushUps *= 2;
                    }
                    else if(Col.equals(("Yellow")))
                    {
                        RepsSquat *= 2;
                    }
                    else
                    {
                        //Green
                        RepsLounges *= 2;
                    }                     
                }
                else if(Spe.equals(("Wild")) || Spe.equals(("Wild Draw 4")))
                {
                    Burpees += 10;
                    RepsSitUps *= 4;
                    RepsPushUps *= 4;
                    RepsSquat *= 4;
                    RepsLounges *= 4;
                }
            }
        }
        
        //added by Jacob
        System.out.println("-----New Hand-----");
        
        H = sortHand(H);
        
        for(Card item : H)
            System.out.print(item.getCardOutput() + ", ");
        
        System.out.println();
        
        if(RepsSitUps > 0)
        {
            System.out.println("Do " + RepsSitUps + " reps of Sit Ups!");
        }
        
        if(RepsPushUps > 0)
        {
            System.out.println("Do " + RepsPushUps + " reps of Push Ups!");
        }
        
        if(RepsSquat > 0)
        {
            System.out.println("Do " + RepsSquat + " reps of Squats!");
        }
        
        if(RepsLounges > 0)
        {
            System.out.println("Do " + RepsLounges + " reps of Lounges!");
        }
        
        if(Burpees > 0)
        {
            System.out.println("Do " + Burpees + " reps of Burpees!");
        }
        
        System.out.println();
        
        //Stat collection function gets called
        int TotalR = RepsPushUps + RepsSitUps + RepsSquat + RepsLounges + Burpees;
        int MaxR = GetMaxReps(RepsPushUps, RepsSitUps, RepsSquat, RepsLounges, Burpees);
        D.StatCollection(TotalR, SkippedR, MaxR);
        
    }
    
    
    int GetMaxReps(int Push, int Sit, int L, int Sq, int B)
    {
        
        if(Push > Sit && Push > L && Push > Sq && Push > B)
        {
            return Push;
        }
        else if(Sit > Push && Sit > L && Sit > Sq && Sit > B)
        {
            return Sit;
        }
        else if(L > Push && L > Sit && L > Sq && L > B)
        {
            return L;
        }
        else if( Sq > Push && Sq > Sit && Sq > L && Sq > B)
        {
            return Sq;
        }
        return B;
    }
    
    //added by Jacob
    ArrayList<Card> sortHand(ArrayList<Card> H)
    {
        //sort by color
        for(int a = 0; a < H.size()-1; a++)
        {
            if(0 < H.get(a).getString(true).compareTo(H.get(a+1).getString(true)))
            {
                Collections.swap(H, a, a+1);
                a = 0;
            }
        }
        
        //sort by rank
        for(int b = 0; b < H.size()-1; b++)
        {
            if(H.get(b).getValue() > H.get(b+1).getValue() && H.get(b).getString(true).equals(H.get(b+1).getString(true)))
            {
                Collections.swap(H, b, b+1);
                b = 0;
            }
        }
        
        return H;
    }
            
}