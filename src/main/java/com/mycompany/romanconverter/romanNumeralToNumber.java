/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.romanconverter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author david flood 
 * @author craig bell
 * 
 */
// Example: http://127.0.0.1:49000/api/roman2num/MXMX Gives 2000 - need to amend.
@Path("/roman2num")
public class romanNumeralToNumber {
        static String romanNumeralToNumber;
        static int decimalNum;
        
        
        private int letterToNumber(char letter) {
             // Find the integer value of letter considered as a Roman numeral.  Return
             // -1 if letter is not a legal Roman numeral.  The letter must be upper case.
          switch (letter) {
             case 'I':  return 1;
             case 'V':  return 5;
             case 'X':  return 10;
             case 'L':  return 50;
             case 'C':  return 100;
             case 'D':  return 500;
             case 'M':  return 1000;
             default:   return -1;
          }
       }
        
        
        
        @GET
        @Path("/{param}")
        public Response sayNumeral(@PathParam("param") String romanNumeralToNumber) {
            // Set the RomanNumeral to an uppercase value
            romanNumeralToNumber = romanNumeralToNumber.toUpperCase();
            
            if (romanNumeralToNumber.length() == 0){
             throw new NumberFormatException("An empty string does not define a Roman numeral.");
            }
           
                
            // Create a variable to be the length of the RomanNumeral
            int len=romanNumeralToNumber.length();
            int num=0; // Initialised num at zero to begin with

            int i=0;
            int arabic = 0;
                        
            while (i < len) {

                char letter = romanNumeralToNumber.charAt(i);        // Letter at current position in string.
                int number = letterToNumber(letter);  // Numerical equivalent of letter.

                if (number < 0)
                   throw new NumberFormatException("Illegal character \"" + letter + "\" in roman numeral.");

                i++;  // Move on to next position in the string

                if (i == romanNumeralToNumber.length()) {
                      // There is no letter in the string following the one we have just processed.
                      // So just add the number corresponding to the single letter to arabic.
                   arabic += number;
                }
                else {
                      // Look at the next letter in the string.  If it has a larger Roman numeral
                      // equivalent than number, then the two letters are counted together as
                      // a Roman numeral with value (nextNumber - number).
                   int nextNumber = letterToNumber(romanNumeralToNumber.charAt(i));
                   if (nextNumber > number) {
                         // Combine the two letters to get one value, and move on to next position in string.
                      arabic += (nextNumber - number);
                      i++;
                   }
                   else {
                         // Don't combine the letters.  Just add the value of the one letter onto the number.
                      arabic += number;
                   }
                }

            }  // end while
            
            if (arabic > 3999){
                throw new NumberFormatException("Roman numeral must have value 3999 or less.");    
            }
            num = arabic;  
                        
                        
                   
                String output = "<h1>Conversion</h1><p style=\"font-size: 22px\">Your numeral is: <strong> " + arabic + "</strong>!</p>";
                // Using the Response builder we output the HTML above with the correct value with a HTTP status code 200
                return Response.status(200).entity(output).build();
        }//sayNumeral      
}//romanNumeralToNumber