package com.example.calculatop;

public abstract class Action implements Operations {
    String roman;

    public void multiplication(Calculator calculator) {
        calculator.setResult(calculator.getA() * calculator.getB());

    }

    public void division(Calculator calculator) {
        calculator.setResult(calculator.getA() / calculator.getB());
    }

    public void addition(Calculator calculator) {
        calculator.setResult(calculator.getA() + calculator.getB());
    }

    public void difference(Calculator calculator) {
        calculator.setResult(calculator.getA() - calculator.getB());
    }

    public String arabicToRoman(int result) {

        if (result % 10 == 0) {
            switch (result) {
                case 10:
                    roman = "X";
                    break;
                case 20:
                    roman = "XX";
                    break;
                case 30:
                    roman = "XXX";
                    break;
                case 40:
                    roman = "XL";
                    break;
                case 50:
                    roman = "L";
                    break;
                case 60:
                    roman = "LX";
                    break;
                case 70:
                    roman = "LXX";
                    break;
                case 80:
                    roman = "LXXX";
                    break;
                case 90:
                    roman = "XC";
                    break;
                case 100:
                    roman = "C";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + result);
            }
        } else {
            String intToString = String.valueOf(result);
            char[] arrays = intToString.toCharArray();
            if (arrays.length < 2) {
                for (RomanNumerals romanNumerals : RomanNumerals.values()) {
                    if (romanNumerals.numerals == Integer.parseInt(String.valueOf(arrays[0]))) {
                        roman = romanNumerals.toString();
                        break;
                    }
                }
            } else {
                String componentOne = null;
                String componentTwo = null;
                switch (Integer.parseInt(String.valueOf(arrays[0]))) {
                    case 1:
                        componentOne = "X";
                        break;
                    case 2:
                        componentOne = "XX";
                        break;
                    case 3:
                        componentOne = "XXX";
                        break;
                    case 4:
                        componentOne = "XL";
                        break;
                    case 5:
                        componentOne = "L";
                        break;
                    case 6:
                        componentOne = "LX";
                        break;
                    case 7:
                        componentOne = "LXX";
                        break;
                    case 8:
                        componentOne = "LXXX";
                        break;
                    case 9:
                        componentOne = "XC";
                        break;
                }
                for (RomanNumerals romanNumerals : RomanNumerals.values()) {
                    if (romanNumerals.numerals == Integer.parseInt(String.valueOf(arrays[1]))) {
                        componentTwo = romanNumerals.toString();
                        break;
                    }
                }
                roman = componentOne + componentTwo;
            }
        }
        return roman;
    }

}
