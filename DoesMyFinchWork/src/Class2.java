import java.io.IOException;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
public class Class2 extends DoesMyFinchWork {



		 public Class2() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

		static void Display(String Morse, Finch myf)
	     {
	     for (int i = 0; i < Morse.length(); i++)
	        {
	        //For a single space the finch should do nothing for four seconds
	        if (Morse.charAt(i) == ' ')
	           {
	       	 	myf.sleep(4000);
	           }
	        //Displays the appropriate output colour for either a dot or a dash.
	        //
	        //
	        else if (Morse.charAt(i) == '.')
	           {
	       	 	myf.setLED(0, 255, 0,2000);
	       	 	myf.setLED(255, 0, 0,2000);     
	           }//if the final character is a '-'
	            //display the appropriate colour
	        else if (Morse.charAt(i) == Morse.length())
	        {
	       	
	             if (Morse.charAt(i) == '-')
	              {
	           	  myf.setLED(0,0,255,2000);
	              }
	              else if (Morse.charAt(i) == '.')//if final character is a '.', display the appropriate colour
		            {
	           	   myf.setLED(0, 255, 0,2000);
	        
	              }
	        }
	        //Displays a blue nose for each dash
	        else if (Morse.charAt(i) == '-')
	              {
	       	   		myf.setLED(0,0,255,2000);
	       	   		myf.setLED(255, 0, 0,2000);	  
	              }
	        }
	     }
	}


