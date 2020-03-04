package com.example.calculatop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Processor {
    private String userString;
    private int userA;
    private int userB;
    private String userSign;
    private boolean flagA = false;
    private boolean flagB = false;

    public int getUserA() {
        return userA;
    }

    public int getUserB() {
        return userB;
    }

    public String getUserSign() {
        return userSign;
    }

    public boolean getFlagA() {
        return flagA;
    }

    public boolean getFlagB() {
        return flagB;
    }


    public Processor() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        this.userString = reader.readLine();
        reader.close();
        fillingInVariables(creatArray());

    }

    public String[] creatArray() {
        String[] list;
        list = userString.split(" ");

        return list;

    }

    public void fillingInVariables(String[] list) throws Exception {
        for (RomanNumerals romanNumerals: RomanNumerals.values()) {
            if(romanNumerals.toString().equals(list[0])){
                flagA = true;
            }
        }
        for (RomanNumerals romanNumerals2: RomanNumerals.values()) {
            if(romanNumerals2.toString().equals(list[2])){
                flagB = true;

            }
        }
        if(flagA && flagB) {
            userSign = list[1];
            for (RomanNumerals romanNumerals: RomanNumerals.values()) {
                if(romanNumerals.toString().equals(list[0])){
                    userA = romanNumerals.numerals;
                    for (RomanNumerals romanNumerals2: RomanNumerals.values()) {
                        if(romanNumerals2.toString().equals(list[2])){
                            userB = romanNumerals2.numerals;

                        }
                    }

                }
            }
        }
        else if(flagA && !flagB || !flagA && flagB) {
            throw new Exception();
        }
        else {
            userA = Integer.parseInt(list[0]);
            userB = Integer.parseInt(list[2]);
            userSign = list[1];
        }


    }


}
