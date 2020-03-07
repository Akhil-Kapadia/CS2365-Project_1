package cs2365_project2;

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
    
    //addded by Jacob
    public String getCardOutput()
    {
        if(Special)
            return Color + " " + isSpecial;
        else
            return Color + " " + Value;
    }
}