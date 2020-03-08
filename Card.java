package cs2365_project2;

class Card
{   
   private int Value;
   private String Color;
   private String isSpecial;
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
    
    
    public String getColor()
    {
        return Color;
    }
    
    
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
    public String getCardOutput()
    {
        if(Special)
            return Color + " " + isSpecial;
        else
            return Color + " " + Value;
    }
}
