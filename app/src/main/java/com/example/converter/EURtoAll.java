package com.example.converter;

public class EURtoAll {
    public double convertCurrency(double num,String sourcecurrency, String targetcurrency){
        if (sourcecurrency.equals("EUR")){
            if (targetcurrency.equals("BDT")){
                return num * 119.15;
       }
       else if (targetcurrency.equals("USD")){
        return num * 1.09;
       }
       else if (targetcurrency.equals("CAD")){
        return num * 1.48;
       }      
     }
    return -1;
   } 
}

 
