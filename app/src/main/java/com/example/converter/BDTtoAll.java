package com.example.converter;

public class BDTtoAll {
    public double convertCurrency(double num, String sourcecurrency, String targetcurrency){
        if (sourcecurrency.equals("BDT")){
            if (targetcurrency.equals("USD")){
                return num * 0.0091;
            }
            else if (targetcurrency.equals("EUR")){
                return num * 0.0084;
            }
            else if (targetcurrency.equals("CAD")){
                return num * 0.012;
            }
        }
        return -1;
    }
}
