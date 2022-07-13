/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package p1;

/**
 *
 * @author Reddogg
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.NumberFormatException;
public class Week1P1 {
    // I started this project thinking enums will be efficient to separate calculations.
    // Below are Length, Mass, Volume enums
    public static enum Length {
        METERS,
        INCHES,
        FEET,
        YARDS,
    }

    public static enum Mass {
        GRAMS,
        OUNCES,
    }

    public static enum Volume {
        LITERS,
        PINTS,
        GALLONS
    }
    // Public Variables
    public static ArrayList<Length> Lengths = new ArrayList<Length>(); // Array of Length enums
    public static ArrayList<Mass> Masses = new ArrayList<Mass>(); // Array of Masses enums
    public static ArrayList<Volume> Volumes = new ArrayList<Volume>(); // Array of Volumes enums
    public static ArrayList<String> allUnits = new ArrayList<String>(); // Stores a string of all possible enum types
    
    
    // Prints all the available units before conversion question is entered.
    public static void printAllUnits(){
        // Provide units to pick from
        for (int i = 0; i < allUnits.size(); i++){
            System.out.printf("%-20s", allUnits.get(i));
            if(i == 0)
                continue;
            if (i % 5 == 0){
                System.out.println();
            }
        }
    }
    
    // This function provides a type (either length, mass, or volume) of the provided unit
    public static String isLenthMassVolume (String unit) {
        String enumType = ""; // used to store Length, Mass, or Volume
        Length[] allLength = Length.values();
        for (Length len : allLength){
            if (len.toString().equals(unit)){ // String comparison unit against valid enum types
                enumType = "Length";
            }
        }
        Mass[] allMass = Mass.values();
        for (Mass m : allMass){
            if (m.toString().equals(unit)){ // String comparison unit against valid enum types
                enumType = "Mass";
            }
        }
        Volume[] allVolume = Volume.values();
        for (Volume v : allVolume){
            if (v.toString().equals(unit)){ // String comparison unit against valid enum types
                enumType = "Volume";
            }
        }
        // If length, mass, or volume, return enumType
        if (enumType.matches("Length") || enumType.matches("Mass") || enumType.matches("Volume")){
            return enumType;
        }
        else {
        System.out.println("Must be a length, mass, or volume measurement.");
        printAllUnits();
        return "";
        }
    }
    
    // This function returns all the conversion math
    public static double conversions(String first, String second, Double operand ){
        // Convert first --> second
        //METERS --> INCHES, FEET, YARDS
        //INCHES --> METERS, FEET, YARDS
        //FEET, --> METERS, INCHES, YARDS
        //YARDS --> METERS, INCHES, FEET

        //GRAMS --> OUNCES
        //OUNCES --> GRAMS

        //LITERS --> PINTS, GALLONS
        //PINTS --> LITERS, GALLONS
        //GALLONS --> LITERS, PINTS

        switch(first){
            case "METERS":
                switch(second){
                    case "INCHES":
                        operand *= 39.3701;
                        break;
                    case "FEET":
                        operand *= 3.2808;
                        break;
                    case "YARDS":
                        operand *= 1.0936;
                        break;
                }
                break;
            case "INCHES":
                switch(second){
                    case "METERS":
                        operand /= 39.3701;
                        break;
                    case "FEET":
                        operand /= 12;
                        break;
                    case "YARDS":
                        operand /= 36;
                        break;
                }
                break;
            case "FEET":
                switch(second){
                    case "METERS":
                        operand /= 3.2808;
                        break;
                    case "INCHES":
                        operand *= 12;
                        break;
                    case "YARDS":
                        operand /= 3;
                        break;
                }
                break;
            case "YARDS":
                switch(second){
                    case "METERS":
                        operand /= 1.0936;
                        break;
                    case "INCHES":
                        operand *= 36;
                        break;
                    case "FEET":
                        operand *= 3;
                        break;
                }
                break;
            case "GRAMS":
                operand /= 28.3495;
                break;
            case "OUNCES":
                operand *= 28.3495;
                break;
            case "LITERS":
                switch(second){
                    case "PINTS":
                        operand *= 2.1134;
                        break;
                    case "GALLONS":
                        operand /= 3.7854;
                        break;
                }
                break;
            case "PINTS":
                switch(second){
                    case "LITERS":
                        operand /= 2.1134;
                        break;
                    case "GALLONS":
                        operand /= 8;
                        break;
                }
                break;
            case "GALLONS":
                switch(second){
                    case "LITERS":
                        operand *= 3.7854;
                        break;
                    case "PINTS":
                        operand *= 8;
                        break;
                }
                break;
        }
        return operand;
    }
        
    // Entry point
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Scanner for inputs
        String question = ""; // Stores the question string entered by the user
        ArrayList <StringBuilder> eachUnit = new ArrayList<StringBuilder>(3); // Array of string builders
        StringBuilder firstStrBld = new StringBuilder(); // First string builder used to store a found unit
        StringBuilder secondstrBld = new StringBuilder(); // Second string builder used to store a found unit
        StringBuilder numberOf = new StringBuilder(); // Third string builder used to store the number to calculate
        //Populate string builder array
        eachUnit.add(firstStrBld); 
        eachUnit.add(secondstrBld);
        eachUnit.add(numberOf);
        
        // Populate arrayList with all units available
        for (Length unit : Length.values()){
            Lengths.add(unit);
            allUnits.add(unit.toString());
        }
        for (Mass mass : Mass.values()){
            Masses.add(mass);
            allUnits.add(mass.toString());
        }
        for (Volume volume : Volume.values()){
            Volumes.add(volume);
            allUnits.add(volume.toString());
        }
        
        // Show available units
        printAllUnits();
        
        // User Input
        System.out.println();
        System.out.println("Enter your unit conversion question (Available above): ");
        question = input.nextLine();
        
        // Search input for valid metric/imperial units
        // If found, the string builder arrayList is modified
        // --Logic error --> The first stringbuilder may not be the first unit contained in the string
        int counter = 0;
        for (String str : allUnits){
            if (question.toUpperCase().contains(str)){
                //System.out.println("The index of " + str.toLowerCase() + " is at: " + question.indexOf(str.toLowerCase()));
                eachUnit.get(counter).append(str);
                counter++;
            }
            if (counter == 2){
                break;
            }
        }
        
        // --Fix logic error. 
        // ** If first string builder index is greater, then the string builders are in the wrong order.** 
        // Correct the first and second string order based on index of input string
        StringBuilder temp = new StringBuilder();
        if (question.indexOf(eachUnit.get(0).toString().toLowerCase()) > question.indexOf(eachUnit.get(1).toString().toLowerCase())){
            //Switch eachUnit(0) and eachUnit(1)
            temp = eachUnit.get(0);
            eachUnit.set(0, eachUnit.get(1));
            eachUnit.set(1, temp);
        }
        
        //Create first and second unit strings
        String firstUnit = eachUnit.get(0).toString();
        String secondUnit = eachUnit.get(1).toString();
        String operand = ""; //  Create an operand string
        try {
            // Find the number from the input used for calculation
            char[] questionChars = question.toCharArray();
            for (int i = 0; i < questionChars.length; i++){
                String s = "";
                if (Character.isDigit(questionChars[i])){ // Retrieve the number then append to stringbuilder(2);
                    s = Character.toString(questionChars[i]);
                    eachUnit.get(2).append(s);
                }
                if (i < questionChars.length-1){// if there's a decimal, append it too.
                    if (questionChars[i+1] == '.'){ 
                        s = Character.toString(questionChars[i+1]);
                        eachUnit.get(2).append(s);
                    }
                }
            }
            // Cannot have empty operand string
            operand = eachUnit.get(2).toString();
            if (operand.isEmpty()){
                throw new NumberFormatException(); 
            }
        }
        catch (NumberFormatException e){
            System.out.printf("Your question is missing an operand. \n Use this format:\n%s",
                "How many gallons are in 81.2 pints?");
            return;
        }
               
        // Get the type by calling isLengthMassVolume of the unit. Returns "Length", "Mass", or "Volume"
        String firstEnumType = ""; // Stores the first unit's metric/imperial type
        String secondEnumType = ""; // Stores the second unit's metric/imperial type
        firstEnumType = isLenthMassVolume(firstUnit); // call function
        secondEnumType = isLenthMassVolume(secondUnit); // call function
        
        double answer = 0; // Used to output the calculation result
        // Switch case prints whether units can convert or is illegal conversion
        switch(firstEnumType){
            case "Length":
                if (secondEnumType.equals("Length")) {
                    answer = conversions(secondUnit, firstUnit, Double.parseDouble(operand));
                    System.out.printf("There are %.2f %s in %s %s: ", answer, firstUnit.toLowerCase(), operand, secondUnit.toLowerCase() );
                }
                else if (secondEnumType.equals("Mass")){
                    System.out.println("Cannot convert length to mass. Please retry.");
                    return;
                }
                else if (secondEnumType.equals("Volume")){
                    System.out.println("Cannot convert length to volume. Please retry.");
                    return;
                }
                break;
            case "Mass":
                if (secondEnumType.equals("Mass")) {
                    answer = conversions(secondUnit, firstUnit, Double.parseDouble(operand));
                    System.out.printf("There are %.2f %s in %s %s: ", answer, firstUnit.toLowerCase(), operand, secondUnit.toLowerCase() );
                }
                else if (secondEnumType.equals("Length")){
                    System.out.println("Cannot convert mass to length. Please retry.");
                    return;
                }
                else if (secondEnumType.equals("Volume")){
                    System.out.println("Cannot convert mass to volume. Please retry.");
                    return;
                }
                break;
            case "Volume":
                if (secondEnumType.equals("Volume")) {
                    answer = conversions(secondUnit, firstUnit, Double.parseDouble(operand));
                    System.out.printf("There are %.2f %s in %s %s: ", answer, firstUnit.toLowerCase(), operand, secondUnit.toLowerCase() );
                }
                else if (secondEnumType.equals("Mass")){
                    System.out.println("Cannot convert volume to mass. Please retry.");
                    return;
                }
                else if (secondEnumType.equals("Length")){
                    System.out.println("Cannot convert volume to length. Please retry.");
                    return;
                }
                break;
            default:
                System.out.println("Please try again.");
                break;
        }
    }
}
