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
 
                romanNumeralToNumber = romanNumeralToNumber.toUpperCase();
                
                int len=romanNumeralToNumber.length();
                int num=0;
                int previousnum = 0;
                for (int i=len-1;i>=0;i--)
                { 
                        char x = romanNumeralToNumber.charAt(i);
                        x = Character.toUpperCase(x);
                        switch(x)
                        {  
                            case 'I':
                                previousnum = num;
                                num = 1;
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
                        if (num<previousnum)
                        {
                            decimalNum= decimalNum-num;
                        }else{
                            // Problems here becuase the value gets added to the previous amount
                            decimalNum= decimalNum+num;
                        }
                }//endOfFor
                String output = "<h1>Conversion</h1><p style=\"font-size: 22px\">Your numeral is: <strong> " + decimalNum + "</strong>!</p>";
                return Response.status(200).entity(output).build();
        }//sayNumeral
        
}