package com.company;

public class Main {

    public static void main(String[] args) {
        Lcd3Symbols lcd =new Lcd3Symbols();
        while(true){
            lcd.printLine(lcd.readUserInput());
        }


    }


}
