package com.example.converter;

public class USDtoAll {
    public double convertCurrency(double num, String sourcecurrency,String targetcurrency){
        if (sourcecurrency.equals("USD")){
            if (targetcurrency.equals("BDT")){
                return num * 109.43;
       }
       else if (targetcurrency.equals("EUR")){
        return num * 0.92;
       }
       else if (targetcurrency.equals("CAD")){
        return num * 1.36;
       }      
     }
    return -1;
   } 
}

