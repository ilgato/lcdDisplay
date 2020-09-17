package com.company;

public class Main {

    public static void main(String[] args) {
        Lcd3Symbols lcd =new Lcd3Symbols();
        lcd.printLine("159");
        lcd.printLine("123e45678901234567");
        lcd.printLine("123456789012345678");
        while(true){
            lcd.printLine(lcd.readUserInput());
        }


    }


}
