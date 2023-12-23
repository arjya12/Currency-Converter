package com.example.converter;

public class CADtoAll {
    public double convertCurrency(double num, String sourcecurrency, String targetcurrency){
        if (sourcecurrency.equals("CAD")){
            if (targetcurrency.equals("BDT")){
                return num * 81.72;
       }
       else if (targetcurrency.equals("USD")){
        return num * 0.74;
       }
       else if (targetcurrency.equals("EUR")){
        return num * 0.68;
       }      
     }
    return -1;
   } 

    
}
