package cs2365_project2;

import java.io.File;
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

	ArrayList<String> Output = new ArrayList<String>();
	

	/**
	 * This method formats the output of the card number with an html heading.
	 * If the card has an action it will change the card # to that and output that.
	 * 
	 * @param card	An individual card out of a deck.
	 * @return	String To be later added to Output Arraylist for output to file.
	 */
	public String setCardHeading(int card)
	{
		String temp = "<h4>The Card number is" + card + "</h4>\n";
		Output.add(temp);
		return temp;
	}
	
	/**
	 * This method is intended to be called after the card heading has been made.
	 * Will output html formated description of card properties like action, color
	 * and exercise.
	 * 
	 * @param card	The card from which ever deck is called.
	 * @param Game	Object from whichever deck is called.
	 * @return String Lengthy paragraph descibing the cards properties. To be 
	 * used later in ArrayList Output.
	 */
	public String setCardDescription(Card obj)
	{
		//Split up for easier readability
		String temp = "<p>The card color is " + obj.getColor() + "<br>\n" 
				+ "The card number/action is " + obj.getAction() + "<br>\n" 
				+ "The card's exercise is " + obj.getExercise() + "</p>\n";
		Output.add(temp);
		return temp;
	}
	
	/**
	 * This method given the count of Hands drawn will create a heading for the 
	 * new segment to follow it.
	 * 
	 * @param handCount	Which iteration of hand drawn is this?
	 * @return	String Creates tertiary heading of the hand count.
	 */
	public String setHandHeading(int handCount)
	{
		String temp = "<h3>The " + handCount + " hand follows</h3>";
		Output.add(temp);
		return temp;
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
		String temp = "<!DOCTYPE html>\n<html>\n<body>\n" + 
				"<h1>UNO Card game with Exercises.WooOOooOOOooOOo</h1>\n"; 
		Output.add(temp);
		return temp;
	}
	
	/**
	 * Just makes a heading for talking about the heading.
	 * @return String
	 */
	public String setExerciseHeading()
	{
		String temp = "<h2>The total amount of Exercise done this game!</h2>";
		Output.add(temp);
		return temp;
	}
		
	/**Method will format an html output of the total amount of exercises and 
	 *  needs to be called near the end of the card game. 
	 * @param total		Total amount of exercise done.
	 * @param Exersice	String. Which exercise it is.
	 * @return	String
	 */
	public String setExerciseTotal(int total, int skipped, String exercise)
	{
		String temp = "<p>The total " + exercise + " done is: " + total + "<br>"
				+ " and has been skipped "+ skipped + " times.</p";
		Output.add(temp);
		return temp;
	}
	
	/**
	 * Method will format into html the largest quantity of exercise done in a 
	 * single hand.
	 * @param max	Should be the largest number of reps for an exercise.
	 * @param exercise	WHich exersise it was.
	 * @return String
	 */
	public String setMaxHandReps(int max, String exercise)
	{
		String temp = "<h3> The most exercise done is " + exercise + " by "
				+ max + "</h3>";
		Output.add(temp);
		return temp;
	}
	
	/**
	 * 
	 * @param count	Int valus of cards left in deck.
	 * @return String
	 */
	public String setCardsLeft(int count)
	{
		String temp = "<h3>Cards left in the deck right now:" + count + "</h3>";
		Output.add(temp);
		return temp;
	}
	
	public String setGameEnd()
	{
		String temp = "<h2>The Game Has Concluded. Following are the leftover cards"
				+ " in the deck and then the overall statistics for the game!</h2>";
		Output.add(temp);
		return temp;
	}
	
	/**
	 * This method adds the end tags for html output.
	 * @return String End tags for html output.
	 */
	public String setEnding()
	{
		String temp = "</body>/n";
		Output.add(temp);
		return temp;
	}
	
	/**
	 * This method can only be called after the end of User interaction and should
	 * be the final step to completing the program.
	 * Program will output html coded output to an html file.
	 * 
	 * @exception IOException If file could not be writ.
	 */
	public void writeToFile()
	{
		setEnding();
		createFile();
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
	
	/**
	 * Creates an empty html file for output.
	 */
	private void createFile()
	{
		try {
	      File myObj = new File("htmlOutput.html");
	      if (myObj.createNewFile()) {
	        System.out.println("File created: " + myObj.getName());
	      } else {
	        System.out.println("File already exists.");
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
	
	public htmlOutput()
	{
		setHeader();
	}
	
}
