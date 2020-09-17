package com.company;

/**
 * test description
 */
public interface Display {
    /**
     * reads a line from the command line input by the user
     * @return a Stirng with the user input
     */
    String readUserInput();

    /**
     * Displays on screen up to 15 values entered
     * by the user returns the enterd values as
     * a String
     */
    String[] printLine(String userInput);



    /**
     * gets the current display size
     * @return an array with the form [horizontalSize, verticalSize]
     */
    int[] getDisplaySize();

    /**
     * sets the display size
     * @param  inHorizontalSize horizontal number of positions
     * @param inVerticalSize vertical number of positions
     */
    void setDisplaySize(int inHorizontalSize, int inVerticalSize);

    /**
     * gets symbols the different symbols that the display can show
     * in each position
     */
    char[] getSymbols();

    /**
     * set the symbols that can be displayed at each
     * position on the display
     * @param InputSymbols an array containing each symbol
     */
    void setSymbols(char[] InputSymbols);

    /**
     * Sets the symbol combinations as the inputed String array
     * @param inSymbolLineCombinations
     */
    void setSymbolLineCombinations(String[] inSymbolLineCombinations);

    /**
     * Sets the symbolCombination for a standard 3x3 lcd display
     */
    void setSymbolLineCombinations(char[] symbols);

    String[] getSymbolLineCombinations();



}
