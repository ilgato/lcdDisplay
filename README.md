# LCD DIsplay

This is an emulation of a 9-segment display on a command console, the user inputs **numbers** by default and they are shown in a 9-segment display format.
Each segment can have 3 different symbols, by default  . _ |
```
**input:** 123
**output:**
... ._. ._. 
..| ._| ._| 
..| |_. ._|
```
In a screen, the image is broken down in horizontal lines, each horizontal line has a number of pixels; The image is shown in the screen by showing every pixel in the top line, from left to right, and repeating for the next line until the end.

In the same way, every number is divided in 3 horizontal lines: top, medium and, bottom; Each line has a combination of symbols, this combination can repeat in other lines or in other numbers. There's a total of 7 horizontal combinations to be able to display the numbers from 0 to 9

## Getting Started

import the `com.company` package, then the `lcd3Symbols` object must be declared, the most simple use is to invoque the **printline** method to show de 9-segment display

```java
Lcd3Symbols lcd =new Lcd3Symbols();
lcd.printLine("159");
```

```
... ._. ._. 
..| |_. |_| 
..| ._| ..|
```
or a user input can be invoque with the **readUserInput** method

```java
Lcd3Symbols lcd =new Lcd3Symbols();
lcd.printLine(lcd.readUserInput());
```

### Prerequisites

Java jdk-9.0.4 What things you need to install the software and how to install them

```
Give examples
```

## Running the tests

The unit testing is found in `test>com>company>Lcd3SymbolsTest.java`

90% of the methods were tested, the only untested method is for getting the user input 

Element | Class, % | Method, % | Line, %
------- | -------- | --------- | -------
Lcd3Symbols | 100%(1/1) | 90%(9/10) | 87% (56/64)

every test in the declares a new **lcd3Symbols** object and showcases how to uses the methods 

testOneLinePrint: prints a line 
testLongLinePrint: test the output for long inputs (overflow)
getDisplaySize: shows how to get the display size (3x3 by default) 
setDisplaySize: show how to change the display size
getSymbols: shows how to get the current symbols 
setAlternativeSymbols: change the symbols but keeps the symbol combination
setSymbolLineCombinationsWithCharInput: setting the line symbol combination with a char array  
SetSymbolLineCombinationsWithStringInput: setting the line symbol combination with a String array

## Authors

* **Pierangelo Castillo Mora** - *Initial work* - [piercm](https://piercm.net)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
