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
 */

@Path("/num2roman")
public class numberToRomanNumeral {
    
    //System.out.println("Please enter a number between 1 and 3999: ");   
    
    @GET
    @Path("/{param}")
    public Response sayRomanNumeral(@PathParam("param") int number) {
       
        // initialise variables
        String roman="";
         
        // Validation check for number range
        if(number<=0 || number>3999){
            System.out.println("Invalid input.  You must enter a number between 1 and 3999");
            System.out.println("Please enter another number now: ");
            
            String output = "<h1>Oh no!!</h1><p style=\"font-size: 22px\">Invalid input.  You must enter a number between 1 and 3999. Please enter another number now!</p>";
            return Response.status(200).entity(output).build();
            
            //number = scan.nextInt();
        }else{
            while(number>=1000){
                roman += "M";
                number-=1000;
            }

            while(number>=900){
                roman += "CM";
                number-=900;
            }

            while(number>=500){
                roman += "D";
                number-=500;
            }

            while(number>=400){
                roman += "CD";
                number-=400;
            }

            while(number>=100){
                roman += "C";
                number-=100;
            }

            while(number>=90){
                roman += "XC";
                number-=90;
            }

            while(number>=50){
                roman += "L";
                number-=50;
            }

            while(number>=40){
                roman += "XL";
                number-=40;
            }

            while(number>=10){
                roman += "X";
                number-=10;
            }

            while(number>=9){
                roman += "IX";
                number-=9;
            }

            while(number>=5){
                roman += "V";
                number-=5;
            }

            while(number>=4){
                roman += "IV";
                number-=4;
            }

            while(number>=1){
                roman += "I";
                number-=1;
            }

            System.out.println("The Roman Numeral is "+ roman);


            String output = "<h1>Conversion</h1><p style=\"font-size: 22px\">Your roman numeral is: <strong> " + roman + "</strong>!</p>";
            return Response.status(200).entity(output).build();
        }//endofif
    }//sayRomanNumeral
}//numberToRomanNumeral

    


