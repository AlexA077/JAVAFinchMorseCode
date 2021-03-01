import java.io.BufferedReader;
import java.io.IOException;

public class Class3 extends DoesMyFinchWork{
	static final String[] Morselookup = {".-", "-...", "-.-.", "-..", ".", "..-.",
	           "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
	           "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "-----", ".----", "..---", "...--",
	           "....-", ".....", "-....", "--...", "---..", "----." , "--..--", ".-.-.-", "..--.." };
	//An array of strings is used because it makes lookup and appending to a string easier
			static	final String[] asciiLookup = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
	           "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4",
	           "5", "6", "7", "8", "9", ",", ".", "?" };
	 public Class3() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	static String GetMessage(BufferedReader in) throws IOException
     {
     //Start with an empty string
     String Morse = "";
     String reverser = "";
     int currChar;
     int MorseIndex;
     System.out.println("Enter the message to encrypt. Only letters, spaces, and" +
                        " numbers will be processed. All other characters will be" +
                        " ignored. Press 'Enter' when finished.");
     do
        {
        //read the characters one at a time.
        currChar = in.read();
        
        //If it's lower case or uppercase subtract to have a/A reference index 0.
        if (currChar >= 'a' && currChar <= 'z')
        	{
       	 	MorseIndex = currChar - 'a';
           }//FINCH.SLEEP
        else if (currChar >= 'A' && currChar <= 'Z')
           {
       	 	MorseIndex = currChar - 'A';
           //Numbers start at 26 in the lookup table.
           }
        
        else if (currChar >= '0' && currChar <= '9')
              {
       	 		MorseIndex = currChar - '0' + 26;
              }
           else if (currChar == ' ')
                 {
                 //If the input was a space append two spaces to our output. We end
                 //up with three total because each letter has a space after it already.
           			Morse = Morse + "  ";
           			continue;
                 }
           
              else
                 {
                 continue;
                 }
        if (currChar == ',')
			for(int i = Morse.length() - 1; i >= 0; i--)
			{
			    reverser = reverser + Morse.charAt(i);
			    Morse = reverser;
			}  
        
        //This adds the string of dots and dashes that represent the letter, followed
        //by a space.
        Morse = Morse + Morselookup [MorseIndex] + " ";
        //We're done if we see a carriage return or a linefeed character.
        }
     while (currChar != 13 && currChar != 10);
     //Return the generated string.
     return Morse;
     }
}
