package com.example.calculatop;

public class Calculator extends Action {

    private int a;
    private String sign;
    private int b;
    private int result;


    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }


    public void setResult(int result) {
        this.result = result;
    }

    public Calculator(Processor processor) throws Exception {
        if(processor.getUserA() >= 1 && processor.getUserB() >= 1 && processor.getUserA() <= 10 && processor.getUserB() <= 10 ) {
            this.a = processor.getUserA();
            this.sign = processor.getUserSign();
            this.b = processor.getUserB();
        }
        else {
            throw new Exception();
        }
        if(!processor.getFlagA() && !processor.getFlagB()) {
            if (sign.equals("*") || sign.equals("/") || sign.equals("+") || sign.equals("-")) {
                switch (sign) {
                    case "*":
                        multiplication(this);
                        System.out.println(result);
                        break;
                    case "/":
                        division(this);
                        System.out.println(result);
                        break;
                    case "+":
                        addition(this);
                        System.out.println(result);
                        break;
                    case "-":
                        difference(this);
                        System.out.println(result);
                        break;
                }
            } else {
                throw new Exception();
            }
        }
        else {
            String romanString;
            switch (sign) {
                case "*":
                    multiplication(this);
                    romanString = arabicToRoman(result);
                    System.out.println(romanString);
                    break;
                case "/":
                    division(this);
                    romanString = arabicToRoman(result);
                    System.out.println(romanString);
                    break;
                case "+":
                    addition(this);
                    romanString = arabicToRoman(result);
                    System.out.println(romanString);
                    break;
                case "-":
                    difference(this);
                    romanString = arabicToRoman(result);
                    System.out.println(romanString);
                    break;
            }

        }


    }


}
