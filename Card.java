package cs2365_project2;

/**
     * Card class is called by the Deck class to initialize the deck,
     * it also returns the color and types of the card for use in Game class,
     * and strings to be used in the output
     * 
     * @author Jacob Strickland
     */
class Card
{   
   private int Value;
   private String Color;
   private String isSpecial;
   boolean Special;
    
   /**
     * Function will create a new card object based on the input parameters
     * @param V
     * @param C
     * @param SPEC
     */
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
    
    /**
     * Getter method that returns the value of a card object
     * returns an int of the card value
     * @return
     */
    public int getValue()
    {
        return Value;
    }
    
    /**
     * Getter method that returns if the card is special or not
     * returns a boolean, true if special
     * @return
     */
    public boolean getSpecial()
    {
        return Special;
    }
    
    /**
     * Getter method that returns the color of a card object or wild
     * @param GetColor
     * returns a string of the color if it exists
     * @return
     */
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

    /**
     * Getter method that returns the color of a card object
     * returns an string of the card color
     * @return
     */
    public String getColor()
    {
        return Color;
    }
    
    /**
     * Getter method that returns the action of a card object
     * returns an string that is the value or special card
     * @return
     */
    public String getAction()
    {
        if(Special)
        {
            return isSpecial;
        }
        else
        {
            return Value+"";
        }
    }
    
    /**
     * Getter method that returns the exercise associated with the color
     * returns an string of the exercise type
     * @return
     */
    public String getExercise()
    {
        if(Color.equals("Red"))
        {
           return "Sit Ups"; 
        }
        else if(Color.equals(("Blue")))
        {
            return "Push ups";
        }
        else if(Color.equals("Yellow"))
        {
            return "Squat";
        }
        else if(Color.equals(("Green")))
        {
            return "Lounges";
        }
        else
        {
            return "";
        }
        
    }
    
    /**
     * Getter method that returns the value and color of a card object
     * returns a string containing the color and value of a card
     * @return
     */
    public String getCardOutput()
    {
        if(Special)
            return Color + " " + isSpecial;
        else
            return Color + " " + Value;
    }
}
