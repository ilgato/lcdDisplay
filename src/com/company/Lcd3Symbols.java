package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Lcd3Symbols implements Display {

    private Hashtable<Integer, Integer[]> horizontalLineEquivalences = new Hashtable<>();
    public Lcd3Symbols(){
        /*
        -Every KEY corresponds to a possible user input 0-9
        -Every position in the VALUE array corresponds to a level in the display
        where 0=top and n is bottom
        -The number in each position will correspond to the adequate
        combination of symbols stored in the symbolLineCombinations array
        */
        horizontalLineEquivalences.put(0,new Integer[]{2,4,6});
        horizontalLineEquivalences.put(1,new Integer[]{0,1,1});
        horizontalLineEquivalences.put(2,new Integer[]{2,3,5});
        horizontalLineEquivalences.put(3,new Integer[]{2,3,3});
        horizontalLineEquivalences.put(4,new Integer[]{0,6,1});
        horizontalLineEquivalences.put(5,new Integer[]{2,5,3});
        horizontalLineEquivalences.put(6,new Integer[]{2,5,6});
        horizontalLineEquivalences.put(7,new Integer[]{2,1,1});
        horizontalLineEquivalences.put(8,new Integer[]{2,6,6});
        horizontalLineEquivalences.put(9,new Integer[]{2,6,1});
    }
    private int verticalSize=3;
    private int horizontalSize=3;
    private char[] symbols =new char[] {'.','|','_'};
    private String[] symbolLineCombinations=  {"...","..|","._.","._|","|.|","|_.","|_|"};

    @Override
    public String readUserInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name= null;
        System.out.println("entre un nombre s'il vouz plait");
        try {
            name = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }

    @Override
    public String[] printLine(String userInput) {
        //todo implement multiple line output for inputs > 15, just a simple split can do it
        userInput = (userInput.length()>15)? userInput.substring(0,15):userInput;
        int digits =userInput.length();

        String[] lcdLine = new String[digits+1];
        for (char a:userInput.toCharArray() ){

            int usrInput=Character.getNumericValue(a);
            try {
                Integer[] curEquivqlence= horizontalLineEquivalences.get(usrInput);
                int p=0;
                for(int i : curEquivqlence){//up to the number of lines
                    lcdLine[p]= (lcdLine[p]==null) ? symbolLineCombinations[i]+" " : lcdLine[p]+symbolLineCombinations[i]+" ";
                   p++;
                }

            }catch (NullPointerException e){
                System.out.println("ignorer les caractères non numériques...");
            }


        }
        String[] cleanedArray = Arrays.stream(lcdLine).filter(Objects::nonNull).toArray(String[]::new);
        lcdLine=cleanedArray;
        System.out.println(lcdLine[0]);
        System.out.println(lcdLine[1]);
        System.out.println(lcdLine[2]);
        return cleanedArray;
    }

    @Override
    public int[] getDisplaySize() {
        return new int[] {horizontalSize, verticalSize};
    }

    @Override
    public void setDisplaySize(int inHorizontalSize, int inVerticalSize) {
        horizontalSize=inHorizontalSize;
        verticalSize=inVerticalSize;
    }

    @Override
    public char[] getSymbols() {
        return symbols;
    }

    @Override
    public void setSymbols(char[] InputSymbols) {
        symbols=InputSymbols;
        if(InputSymbols.length==3){
            setSymbolLineCombinations(InputSymbols);
        }

    }

    @Override
    public void setSymbolLineCombinations(String[] inSymbolLineCombinations) {
        symbolLineCombinations=inSymbolLineCombinations;
    }

    @Override
    public void setSymbolLineCombinations(char[] symbols) {
        symbolLineCombinations[0]= Character.toString(symbols[0]) +symbols[0] + symbols[0];
        symbolLineCombinations[1]= Character.toString(symbols[0]) +symbols[0]+ symbols[1];
        symbolLineCombinations[2]= Character.toString(symbols[0]) +symbols[2]+ symbols[0];
        symbolLineCombinations[3]= Character.toString(symbols[0]) +symbols[2] + symbols[1];
        symbolLineCombinations[4]= Character.toString(symbols[1]) +symbols[0]+ symbols[1];
        symbolLineCombinations[5]= Character.toString(symbols[1]) +symbols[2]+ symbols[0];
        symbolLineCombinations[6]= Character.toString(symbols[1]) +symbols[2]+ symbols[1];
    }

    @Override
    public String[] getSymbolLineCombinations() {
        return symbolLineCombinations;
    }
}
