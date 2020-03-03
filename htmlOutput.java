package uno;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The htmlOutput class will format the output given by the game/player class 
 * for this projects UNO card game. This program will format the output into a
 * usable html file.
 * <p>
 * It will have a titled project description.
 * A subtitle for each section of the output as listed in assignment instructions.
 * A heading for each hand of cards and each individual card followed by a paragraph description.
 * 
 * @author	Akhil Kapadia
 * @version	Version 1.4
 * @since	2/24/2020
 */
public class htmlOutput {

	private ArrayList<String> Output;
	

	/**
	 * This method formats the output of the card number with an html heading.
	 * If the card has an action it will change the card # to that and output that.
	 * 
	 * @param card	An individual card out of a deck.
	 * @return	String To be later added to Output Arraylist for output to file.
	 */
	public String setCardHeading(int card)
	{
		return "<h4>The Card number is" + card + "</h4>\n";
	}
	
	/**
	 * This method is intended to be called after the card heading has been made.
	 * Will output html formated description of card properties like action, color
	 * and exercise.
	 * 
	 * @param card
	 * @return String Lengthy paragraph descibing the cards properties. To be 
	 * used later in ArrayList Output.
	 */
	public String setCardDescription(int card)
	{
		//Split up for easier readability
		String temp = "<p>The card color is " + obj.getColor(card) + "<br>\n";
		temp.concat("The card number/action is " + obj.getAction(card) + "<br>\n");
		temp.concat("The card's exercise is " + obj.getExercise(card) + "</p>\n");
		return temp;
	}
	
	/**
	 * This method given the count of Hands drawn will create a heading for the 
	 * new segment to follow it.
	 * 
	 * @param handCount
	 * @return	String Creates tertiary heading of the hand count.
	 */
	public String setHandHeading(int handCount)
	{
		return "<h3>The " + handCount + " hand follows</h3>";
	}
	
	/**
	 * Creates an HTML compatible heading for the output file so that it can be 
	 * read from a browser in html.
	 * 
	 * @return	String 	Formats the header of the output file so that it works
	 * in HTML.
	 */
	public String setHeader()
	{
		return "<!DOCTYPE html>\n<html>\n<body>\n" + 
				"<h1>UNO Card game with Exercises.WooOOooOOOooOOo</h1>\n"; 
	}
	
	/**
	 * This method formats an entire hand into html by calling other methods.
	 * Requires an Arraylist of 7 cards to be input.
	 * 
	 * @param hand	ArrayList of cards (Compromised of 7 Cards) which is the hand
	 * drawn.
	 * @param handCount	The count of how many hands have been drawn.
	 */
	public void setHand(ArrayList <Integer> hand, int handCount)
	{
		Output.add(setHandHeading(handCount));
		for (int i : hand)
		{
			Output.add(setCardHeading(i));
			Output.add(setCardDescription(i));
		}
	}
	
	/**
	 * This method adds the end tags for html output.
	 * @return String End tags for html output.
	 */
	public String setEnding()
	{
		return "</body>/n";
	}
	
	/**
	 * This method can only be called after the end of User interaction and should
	 * be the final step to completing the program.
	 * Program will output html coded output to an html file.
	 */
	public void writeToFile()
	{
		try {
		      FileWriter myWriter = new FileWriter("htmlOutput.html");
		      for (String s : Output)
		    	  myWriter.write(s);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	//Constructor
	public htmlOutput()
	{
		Output.add(setHeader());
		
	}
	
}
