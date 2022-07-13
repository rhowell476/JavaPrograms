/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package p2;

/**
 *
 * @author Reddogg
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.IllegalFormatException;
public class Week1P2 {
        public static ArrayList<String> outcomes = new ArrayList<String>(2187);
        //0 and 1 are unused. Also, Q and Z are not in assignment table
        public static String[] two = {"A", "B", "C"}; // Maps number 2 to the possible outcomes. " " is unused
        public static String[] three = {"D", "E", "F"}; // Maps number 3 to the possible outcomes. " " is unused
        public static String[] four = {"G", "H", "I"}; // Maps number 4 to the possible outcomes. " " is unused
        public static String[] five = {"J", "K", "L"}; // Maps number 5 to the possible outcomes. " " is unused
        public static String[] six = {"M", "N", "O"}; // Maps number 6 to the possible outcomes. " " is unused
        public static String[] seven = {"P", "R", "S"}; // Maps number 7 to the possible outcomes. " " is unused
        public static String[] eight = {"T", "U", "V"}; // Maps number 8 to the possible outcomes. " " is unused
        public static String[] nine = {"W", "X", "Y"}; // Maps number 9 to the possible outcomes. " " is unused

        
    // This function uses switch on the input numbers to create the possible words
    // This was inspired by binary number cases in logic operations
    public static void switching(char[] entry) {
        // FOR LOOP --> Each digit. Gives all options in "outcomes" array list for first digit, second digit, so on...
        for (int len = 0; len < entry.length; len++){
            int remainder = 2187; // remainder changes each loop. It divides by 3 with each digit added
            switch (len){ // switch to change the remainder value
                case 0:
                    remainder = 729;
                    break;
                case 1:
                    remainder = 243;
                    break;
                case 2:
                    remainder = 81;
                    break;
                case 3:
                    remainder = 27;
                    break;
                case 4:
                    remainder = 9;
                    break;
                case 5:
                    remainder = 3;
                    break;
                case 6:
                    remainder = 1;
                    break;
            }
            
            // FIRST DIGIT
            String printChar = " ";
            int counter = 0;
            if (len == 0){
                switch (entry[0]){ // This switch function adds initial strings to ArrayList outcomes
                    case '2': 
                        //possible ABC
                        firstDigitOutcomes(remainder, two);
                        break;
                    case '3': 
                        //possible DEF
                        firstDigitOutcomes(remainder, three);
                        break;
                    case '4': 
                        //possible GHI
                        firstDigitOutcomes(remainder, four);
                        break;
                    case '5': 
                        //possible JKL
                        firstDigitOutcomes(remainder, five);
                        break;
                    case '6': 
                        //possible MNO
                        firstDigitOutcomes(remainder, six);
                        break;
                    case '7': 
                        //possible PRS
                        firstDigitOutcomes(remainder, seven);
                        break;
                    case '8': 
                        //possible TUV
                        firstDigitOutcomes(remainder, eight);
                        break;
                    case '9': 
                        //possible WXY
                        firstDigitOutcomes(remainder, nine);
                        break;
                }
            }
            // SECOND DIGIT thru 7TH DIGIT: appends ArrayList strings of new possibles
            counter = 0;
            printChar = " ";
            if (len > 0) {
                switch (entry[len]){ // This switch function is run once per phone button (2-8) and appends the next letter's possibilites
                    case '2': 
                        //possible ABC
                        fillDigitOutcomes(remainder, two);
                        break;
                    case '3': 
                        //possible DEF
                        fillDigitOutcomes(remainder, three);
                        break;
                    case '4': 
                        //possible GHI
                        fillDigitOutcomes(remainder, four);
                        break;
                    case '5': 
                        //possible JKL
                        fillDigitOutcomes(remainder, five);
                        break;
                    case '6': 
                        //possible MNO
                        fillDigitOutcomes(remainder, six);
                        break;
                    case '7': 
                        //possible PRS
                        fillDigitOutcomes(remainder, seven);
                        break;
                    case '8': 
                        //possible TUV
                        fillDigitOutcomes(remainder, eight);
                        break;
                    case '9': 
                        //possible WXY
                        fillDigitOutcomes(remainder, nine);
                        break;
                }
            }
        }
    }
    
    // This function is called for a selected number to populate the full arrayList with possible letters
    // It's called firstDigitOutcomes because it fills the first digit of all 2187 strings in arrayList outcomes
    //
    // Inpired by binary logic: Similarly fills column x: the "First digit"
    //  x  |  y  |  z  
    //-------------------
    //  0  |     | 
    //  0  |     |
    //  0  |     |
    //  0  |     |
    //  1  |     |
    //  1  |     |
    //  1  |     |
    //  1  |     |
    public static void firstDigitOutcomes(int remain, String[] validLetters){
        int increment = 0;
        String printStr = " "; // Placeholder used to add to the oucomes
        //possible ABC
        System.out.println("Starting script.");
        for (int i = 1; i <= 2187; i++){
            printStr = validLetters[increment];
            outcomes.add(printStr); // Adds possiblities for button 2
            if (i % remain == 0){
                printStr = validLetters[increment];
                increment++;
            }
        }
    }
    
    // This function is called for a selected number to populate the full arrayList with possible letters
    // It's called fillDigitOutcomes because it fills the remaining ditis of the phone number for all 2187 strings
    // ArrayList has been pre-populated with a starting digit, so outcomes.set is called to add a letter
    // Inpired by binary logic: Similary fills columns x --> y --> z ---> ... ---> n
    //  x  |  y  |  z  
    //-------------------
    //  0  |  0  |  1  
    //  0  |  0  |  0  
    //  0  |  1  |  1  
    //  0  |  1  |  0  
    //  1  |  0  |  1  
    //  1  |  0  |  0  
    //  1  |  1  |  1  
    //  1  |  1  |  0  
    public static void fillDigitOutcomes(int remain, String[] validLetters){
        int increment = 0;
        String printStr = " "; // Placeholder used to add to the oucomes
        for (int i = 1; i <= 2187; i++){
        printStr = validLetters[increment];
        String outcome = outcomes.get(i-1);
        outcome += printStr;
        outcomes.set(i-1, outcome);
        if (i % remain == 0){
            printStr = validLetters[increment];
            increment++;
            if (increment == 3)
                increment = 0;
        }
        }
    }
    
    // Entry point
    public static void main(String[] args) {
        
        char[] entryChars = new char[7]; // Used to index input string
        
        try (Formatter output = new Formatter("PhoneWords.txt")) { // Formatter out file
            Scanner input = new Scanner(System.in); // Scanner declaration
            boolean isValidInput = false;
            while (!isValidInput){ // Continue until valid input is given: 7 numbers.
                // User input
                System.out.printf("%s", "Enter 7 numbers (2-9): ");
                String entry = input.next();
                entryChars = entry.toCharArray(); // Convert string to char array
                if (entryChars.length != 7){
                    System.out.println("Enter 7 numbers.");
                    continue;
                }
                // only allow numbers 2-9. Valid if all is passing
                for (int i = 0;i < entryChars.length;i++){
                    if (entryChars[i] <= '1' || entryChars[i] > '9'){ 
                        System.out.println("Enter 7 numbers.");
                        break;
                    }
                    if (i == entryChars.length-1){ // Last char[] element
                        isValidInput = true;
                    }
                }
            }
            // Call function switching: it creates all of the word possibilities using the number sequence from the input
            switching(entryChars); 
            try{
                // Output format will write the word possibilities to file PhoneWords.txt
                for(int i = 0; i < 2187; i++) {
                    output.format("%s\n", outcomes.get(i));
                }
            }
            catch (IllegalFormatException e) { // Catch output.format issues
                System.out.println("Illegal format. Try again");
            }
        }
        catch (SecurityException | FileNotFoundException | FormatterClosedException e) { // Catch file exceptions
            System.out.println("Problem with the file. See stack tracke:");
            e.printStackTrace();
        }
    }
}
