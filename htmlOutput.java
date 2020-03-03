package uno;

import java.util.ArrayList;

public class htmlOutput {

	private ArrayList<String> Output;
	
	//Given a singular card, will create a heading of importance 3.
	public String setCardHeading(int card)
	{
		return "<h3>The Card number is" + card + "</h3>\n";
	}
	
	public String setCardDescription(int card)
	{
		//Split up for easier readability
		String temp = "<p>The card color is " + obj.getColor(card) + "<br>\n";
		temp.concat("The card number/action is " + obj.getAction(card) + "<br>\n");
		temp.concat("The card's exercise is " + obj.getExercise(card) + "</p>\n");
		return temp;
	}
	
	public String setHandHeading(int handCount)
	{
		return "<h2>The " + handCount + " hand follows</h2>";
	}
	
	public String setHeader()
	{
		return "<!DOCTYPE html>\n<html>\n<body>\n" + 
				"<h1>UNO Card game with Exercises.WooOOooOOOooOOo</h1>\n"; 
	}
	
	public void setHand(ArrayList <Integer> hand, int handCount)
	{
		Output.add(setHandHeading(handCount));
		for (int i : hand)
		{
			Output.add(setCardHeading(i));
			Output.add(setCardDescription(i));
		}
	}
	
	public String setEnding()
	{
		return "</body>/n";
	}
	
	//Constructor
	public htmlOutput()
	{
		Output.add(setHeader());
		
	}
	
}
