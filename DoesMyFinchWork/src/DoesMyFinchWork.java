import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.TextArea;//check
import java.awt.TextField;//check
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
public class DoesMyFinchWork {

			   final static String[][] code = {
				        {"A", ".-     "}, {"B", "-...   "}, {"C", "-.-.   "}, {"D", "-..    "},
				        {"E", ".      "}, {"F", "..-.   "}, {"G", "--.    "}, {"H", "....   "},
				        {"I", "..     "}, {"J", ".---   "}, {"K", "-.-    "}, {"L", ".-..   "},
				        {"M", "--     "}, {"N", "-.     "}, {"O", "---    "}, {"P", ".--.   "},
				        {"Q", "--.-   "}, {"R", ".-.    "}, {"S", "...    "}, {"T", "-      "},
				        {"U", "..-    "}, {"V", "...-   "}, {"W", ".-   - "}, {"X", "-..-   "},
				        {"Y", "-.--   "}, {"Z", "--..   "}, {"0", "-----  "}, {"1", ".----  "},
				        {"2", "..---  "}, {"3", "...--  "}, {"4", "....-  "}, {"5", ".....  "},
				        {"6", "-....  "}, {"7", "--...  "}, {"8", "---..  "}, {"9", "----.  "},
				        {"'", ".----. "}, {":", "---... "}, {",", "--..-- "}, {"-", "-....- "},
				        {"(", "-.--.- "}, {".", ".-.-.- "}, {"?", "..--.. "}, {";", "-.-.-. "},
				        {"/", "-..-.  "}, {"-", "..--.- "}, {")", "---..  "}, {"=", "-...-  "},
				        {"@", ".--.-. "}, {"\"", ".-..-."}, {"+", ".-.-.  "}, {" ", "/"}}; // cheat a little
				 
				    final static Map<Character, String> map = new HashMap<>();
				 
				    static {
				        for (String[] pair : code)
				            map.put(pair[0].charAt(0), pair[1].trim());
				    }
				 
					final int ENCRYPT = 'e';
					
					final int READFILE = 'r';
					  
					final int EXIT = 'x';
		   
			
				   public  DoesMyFinchWork () throws IOException
				   {
					   Finch myf = new Finch();
						
					   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
					   
					   //This stores morsecode the user wants to change to a message
					   String Morse;
					   //Whether or not an input is valid.
					   boolean isValid;
					   int edxOpt;
					   		System.out.println("Now then, what can I help you with today?");
				    while (true)
				    	{
				    		//First we want to get what the user wants to do
				    		do
				    			{
				    			isValid = true;
				    			System.out.println("Enter 'e' to translate input data into Morse code or 'r' to read input from a text file or 'x' to exit:");
				    			edxOpt = in.read();

				    			if (edxOpt == 'x')
				    				{
				    					//Terminate program
				    					System.out.println("Program ended");
				    					myf.quit();;
				    					System.exit(0);
				    				}
				    			//These are the only valid options, so clearly we need to take in new input.
				    			else if (edxOpt != 'e')
				    				{
				    					System.out.println("Finished");
				    					isValid = false;
				    				}
				    			else if (edxOpt != 'r')
			    				{
			    					System.out.println("Finished");
			    					isValid = false;
			    				}
				    			//Throw away any available bytes because you have to hit return.
				       while (in.ready())
				          {
				          in.read();
				          }
				       }
				    		while (!isValid);

				    			if (edxOpt == 'e')
				    				{
				    					//Red light means encrypt
				    					myf.setLED(255, 0, 0);
				    					//Get an input line and change it into morse. Stores as a string
				    					//of dots and dashes.
				    					Morse = Class3.GetMessage(in);//I NEED TO PICK 1
				    					
				    					
				    					System.out.println("The encrypted message is");
				    					System.out.println(Morse);
				    					//Display appropriate colour for each dot and dash
				    					Class2.Display(Morse,myf);
				    				}
				    			else if (edxOpt == 'r')
				    			{
				    				myf.setLED(255, 0, 0);
				    				Morse= Class5.ReadFile(in);
				    				System.out.println("The encrypted message is");
			    					System.out.println(Morse);
			    					//Display appropriate colour for each dot and dash
			    					Class2.Display(Morse,myf);
				    			}
				    			
				    
				    			else 
				    				if (in.ready())
				    				{
				    					in.read();
				    					break;
				    				}
				 
				//frame.dispose();
				//
				}
				   }
				    public static void main(String[] args) throws IOException {
				    	
				       new DoesMyFinchWork();
				    }
				 
				   
				

	}

