package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lcd3SymbolsTest {

    @Test
    void testOneLinePrint() {
        Lcd3Symbols displayTest = new Lcd3Symbols();
        String[] result = displayTest.printLine("123a4");
        String[] expected = {"... ._. ._. ... ","..| ._| ._| |_| ","..| |_. ._| ..| "};
        assertArrayEquals(expected,result);
    }

    @Test
    void testLongLinePrint() {
        Lcd3Symbols displayTest = new Lcd3Symbols();
        String[] result = displayTest.printLine("1234567890124567892");
        String[] expected = {"... ._. ._. ... ._. ._. ._. ._. ._. ._. ... ._. ... ._. ._. ","..| ._| ._| |_| |_. |_. ..| |_| |_| |.| ..| ._| |_| |_. |_. ","..| |_. ._| ..| ._| |_| ..| |_| ..| |_| ..| |_. ..| ._| |_| "};
        assertArrayEquals(expected,result);
    }

    @Test
    void getDisplaySize() {
        Lcd3Symbols displayTest = new Lcd3Symbols();
        int[] result = displayTest.getDisplaySize();
        int[] expected = {3,3};
        assertArrayEquals(expected,result);

    }



    @Test
    void setDisplaySize() {
        Lcd3Symbols displayTest = new Lcd3Symbols();
        displayTest.setDisplaySize(4,4);
        int[] result = displayTest.getDisplaySize();
        int[] expected = {4,4};
        assertArrayEquals(expected,result);

    }

    @Test
    void getSymbols() {
        Lcd3Symbols displayTest = new Lcd3Symbols();
        char[] result = displayTest.getSymbols();
        char[] expected = {'.','|','_'};
        assertArrayEquals(expected,result);
    }

    @Test
    void setAlternativeSymbols() {
        Lcd3Symbols displayTest = new Lcd3Symbols();

        displayTest.setSymbols(new char[] {' ','|','_'});
        char[] result = displayTest.getSymbols();
        char[] expected = {' ','|','_'};
        assertArrayEquals(expected,result);

        String[] result2 = displayTest.printLine("123");
        String[] expected2 = {"     _   _  ","  |  _|  _| ","  | |_   _| "};
        assertArrayEquals(expected2,result2);
    }

    @Test
    void setSymbolLineCombinationsWithCharInput() {
        Lcd3Symbols displayTest = new Lcd3Symbols();
        displayTest.setSymbols(new char[] {' ','|','_'});
        displayTest.setSymbolLineCombinations(displayTest.getSymbols());
        String[] result2 = displayTest.printLine("123");
        String[] expected2 = {"     _   _  ","  |  _|  _| ","  | |_   _| "};
        assertArrayEquals(expected2,result2);
        displayTest.getSymbolLineCombinations();

    }

    @Test
    void setSymbolLineCombinationsWithStringInput() {
        Lcd3Symbols displayTest = new Lcd3Symbols();
        displayTest.setSymbols(new char[] {' ','|','_'});
        displayTest.setSymbolLineCombinations(new String[]{"   ","  |"," _ "," _|","| |","|_ ","|_|"});
        String[] result2 = displayTest.printLine("123");
        String[] expected2 = {"     _   _  ","  |  _|  _| ","  | |_   _| "};
        assertArrayEquals(expected2,result2);
        displayTest.getSymbolLineCombinations();
    }
}