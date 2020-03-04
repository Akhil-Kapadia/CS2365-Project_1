
package oop_p2;

import java.util.Scanner;
import java.util.*;
import java.net.*;
import java.io.*;
import java.util.Formatter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.io.File;

/**
 *
 * @author Demetrios Mihaltses
 */
public class OOP_P2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Game G = new Game();
        G.StartGame();
        
    }
    
}


class Game
{
    
    /*
        Game class has two methods, StartGame and FormatCardForWorkout
        Requires two other classes to function correctly, Deck and Card
        
        StartGame asks the user how many decks they want,
        asks the user whether or not to shuffle them all together or not
        asks the user whether or not they wish to remove Sepcial cards
        
        Proceeds to draw 7 cards, sends them to the FormatCardForWorkout method
        
        In the FormatCardForWorkout method, it counts the amount of reps of each workout
        then takes into account the special cards and proceeds to do the functions 
        listed in the project 2 document on blackboard
    
        Then the output is displayed per excersise in the console
    
        Then we jump back to the StartGame method and it proceeds to repeat this process
        until all the Decks have been used
    
    */
    
    public void StartGame()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("How many decks do you wish to start with? 1, 2 , or 3???");
        int Pick = input.nextInt();
        
        if(Pick > 3)
        {
            Pick = 3;
        }
        else if(Pick <= 0)
        {
            Pick = 1;
        }
        
        //filling the Decks
        Deck[] Decks = new Deck[Pick];
        
       for(int a = 0; a < Decks.length; a++)
       {
           Decks[a] = new Deck();
           Decks[a].CreateDeck();
       }
        
        System.out.println("Do you wish to shuffle the decks together? 1 for Yes, 2 for No \n");
        Pick = input.nextInt();
        
        //shuffling all the decks together
        if(Pick == 1 && Decks.length > 1)
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
        System.out.println("Do you wish to remove special cards??? 1 for Yes, 2 for No \n");
        Pick = input.nextInt();
        if(Pick == 1)
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
                    FormatCardForWorkout(Hand);
                    
                    //Will draw a new hand
                    Temp.clear();
                    Hand.clear();
                    
                }
            }
        }
        
        System.out.println("Game over!!! Hopefully you had a good workout!");
        
        
   
    }
    
    
    void FormatCardForWorkout(ArrayList<Card> H)
    {
        int RepsSitUps = 0;
        int RepsPushUps = 0;
        int RepsSquat = 0;
        int RepsLounges = 0;
        int Burpees = 0;
        
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
                        RepsSitUps = 0;
                    }
                    else if(Col.equals(("Blue")))
                    {
                        RepsPushUps =0;
                    }
                    else if(Col.equals(("Yellow")))
                    {
                        RepsSquat =0;
                    }
                    else
                    {
                        //Green
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
        
        
        if(RepsSitUps > 0)
        {
            System.out.println("Do " + RepsSitUps + " reps of Sit Ups!\n");
        }
        
        if(RepsPushUps > 0)
        {
            System.out.println("Do " + RepsPushUps + " reps of Push Ups!\n");
        }
        
        if(RepsSquat > 0)
        {
            System.out.println("Do " + RepsSquat + " reps of Squats!\n");
        }
        
        if(RepsLounges > 0)
        {
            System.out.println("Do " + RepsLounges + " reps of Lounges!\n");
        }
        
        if(Burpees > 0)
        {
            System.out.println("Do " + Burpees + " reps of Burpees!\n");
        }
        
        
    }
            
}



class Deck
{
    ArrayList<Card> D = new ArrayList<Card>();
    
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
    

}


class Card
{   
    int Value;
    String Color;
    String isSpecial;
    boolean Special;
    
    public Card(int V, String C, String SPEC)
    {
        Value = V;
        Color = C;
        isSpecial = SPEC;
        
        if(!SPEC.equals(""))
        {
            Special = true;
        }
        else
        {
            Special = false;
        }
           
    }
    
    public int getValue()
    {
        return Value;
    }
    
    public boolean getSpecial()
    {
        return Special;
    }
    
    public String getString(boolean GetColor)
    {
        if(GetColor)
        {
            return Color;
        }
        else
        {
            if(Special)
            {
                return isSpecial;
            }
            else
            {
                return "";
            }
        }
    }
    
    
    public String getCardData()
    {
        //for testing
        return "Value - " + Value + " | Color - " + Color + " | SpecialType??? - " + isSpecial + "\n";
    }
}