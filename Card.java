package uno;

import java.util.ArrayList;
import java.util.Collections;

public class Card {
    
    private int card;
    private ArrayList<Integer> deck;
    
    //getter, returns copy of list
    public ArrayList<Integer> getDeck(){
        return new ArrayList<>(this.deck);
    }
    
    //get the card
    //public int getCard(){
        //return this.card;
    //}
    
    //get the color of the card
    public int getColor(){
        return this.card / 100;
    }
    
    //get the number of the card
    public int getNumber(){
        return this.card % 100;
    }

    //setter for deck
    public void setDeck(ArrayList deck){
        this.deck = deck;
    }
    
    //setter for card
    //public void setCard(int card){
        //this.card = card;
    //}
    
    //adder, end of deck
    public ArrayList<Integer> addDeck(int card){
        ArrayList<Integer> deck_copy = new ArrayList<>(this.deck);
        deck_copy.add(card);
        return deck_copy;
    }
    
    //remover, first card in deck
    public ArrayList<Integer> removeDeck(ArrayList<Integer> deck){
        ArrayList<Integer> deck_copy = new ArrayList<>(this.deck);
        deck_copy.remove(0);
        return deck_copy;
    }
    
    //creates new decks in sorted order
    public ArrayList<Integer> createDeck()
    {
        ArrayList<Integer> created_deck = new ArrayList<>();    //create a new arraylist
        int total_decks = 1;                                    //get the total decks
        int card_num_max = 12;                                  //max number the identifying number can go to
        
        boolean action_cards = true;        //get if action cards are included
        if(!action_cards)                   //reduce indentifying number to only have 0-9
            card_num_max-=3;
        
        for(int i = 1; i <= total_decks; i++)           //each iteration creates a deck
        {
            int card_num = 0;                           //card number
            
            while(card_num / 100 <= 3)                  //while first digit (color) in in range 0-3
            {
                if(card_num % 10 == 0)                  //if identifying num is zero insert one of that color into deck
                {
                    created_deck.add(card_num);
                    card_num+=1;
                }
                
                while(card_num % 100 <= card_num_max)   //if identifying num is range 1-12 for action or 1-9 for no action insert two of color into deck
                {
                    created_deck.add(card_num);
                    created_deck.add(card_num);
                    card_num+=1;
                }
                
                card_num+=(99-card_num_max);            //increase to next color w/ identifying num starting at zero
            }
            
            if(action_cards)                            //if action cards included
            {
                for(int j = 0; j <= 3; j++)             //insert four of each wild and wild+4
                {
                    created_deck.add(400);
                    created_deck.add(401);
                }
            }
        }
        
        /*
        int c = 0;
        for(int temp : created_deck)
        {
            System.out.println(temp);
            c++;
        }
        
        System.out.println(c);
*/
        return created_deck;
    }
    
    public ArrayList<Integer> shuffleDeck()
    {
        boolean shuffle_combined = true;                //get if the decks are to be shuffled together or seperate
        ArrayList<Integer> deck_shuffle = getDeck();    //get the deck
        int total_decks = deck_shuffle.size() / 108;    //calculate the total decks
        
        if(total_decks == 1 || shuffle_combined)
            Collections.shuffle(deck_shuffle);
        else
        {
            for(int i = 0; i < total_decks - 1; i++)
                Collections.shuffle(deck_shuffle.subList(0+(i*108),107+(i*108)));
            
            //this does the same thing as the one line above but I thought the one line above wasnt working right
            //it is working right I'm pretty sure
            /*
            ArrayList<Integer>[] split_list = new ArrayList[total_decks];
            for(int i = 0; i < total_decks; i++)
                split_list[i] = new ArrayList<>(deck_shuffle.subList(i*108,108+i*108));
            for(ArrayList<Integer> sub_list : split_list)
                Collections.shuffle(sub_list);
            deck_shuffle.clear();
            for(ArrayList<Integer> sub_list1 : split_list)
                for(int card : sub_list1)
                    deck_shuffle.add(card);
*/
        }
        
        return deck_shuffle;
    }
}
