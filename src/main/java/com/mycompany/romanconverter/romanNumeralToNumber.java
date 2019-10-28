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

@Path("/roman2num")
public class romanNumeralToNumber {
        static String romanNumeralToNumber;
        static int decimalNum;
        
        @GET
        @Path("/{param}")
        public Response sayNumeral(@PathParam("param") String romanNumeralToNumber) {
                
            // Set the RomanNumeral to an uppercase value
                romanNumeralToNumber = romanNumeralToNumber.toUpperCase();
                
                // Create a variable to be the length of the RomanNumeral
                int len=romanNumeralToNumber.length();
                int num=0; // Initialised num at zero to begin with
                int previousnum = 0; // Initialised previousnum at zero to begin with
                for (int i=len-1;i>=0;i--) // Loop through the characters in the string
                { 
                        // CharAt(i) returns the character at the specified index in the string "romanNumeralToNumber". 
                        // The index value that we pass in this method should be between 0 and (length of string-1)
                        // We set the value to be a character named 'x'.
                        char x = romanNumeralToNumber.charAt(i);
                        //x = Character.toUpperCase(x);
                        // If the equality is found, switch starts to execute the code starting from the corresponding case, 
                        // until the nearest break (or until the end of switch).
                        switch(x)
                        {  
                            case 'I':
                                previousnum = num;
                                num = 1; // This is the value for this case
                                break; 
                            case 'V':
                                previousnum = num;
                                num = 5;
                                break;
                            case 'X':
                                previousnum = num;
                                num = 10;
                                break;
                            case 'L':
                                previousnum = num;
                                num = 50;
                                break;
                            case 'C':
                                previousnum = num;
                                num = 100;
                                break;
                            case 'D':
                                previousnum = num;
                                num = 500;
                                break;
                            case 'M':
                                previousnum = num;
                                num = 1000;
                                break;
                        }  
                        // Possibly working correctly here with the break but not in the else
                      if (num<previousnum){
                            decimalNum = decimalNum-num;
                            break; // For testing purposes
                      }else{ 
                          // Problems here becuase the value gets added to the previous amount
                            decimalNum = decimalNum+num;
                            break; // For testing purposes
                      }
                }//endOfFor
                String output = "<h1>Conversion</h1><p style=\"font-size: 22px\">Your numeral is: <strong> " + decimalNum + "</strong>!</p>";
                // Using the Response builder we output the HTML above with the correct value with a HTTP status code 200
                return Response.status(200).entity(output).build();
        }//sayNumeral      
}//romanNumeralToNumber