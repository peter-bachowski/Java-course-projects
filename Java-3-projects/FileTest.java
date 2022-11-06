import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class FileTest { // this method introduces the PrintWriter class that can create and write to new txt files as well as scan existing files for keywords
    public static void main(String[] args) {
        String inputFileName = args[0];
        String word = args[1];

        File fileIn = new File(inputFileName); //creates a file input object
        File fileOut = new File(word + "In" + inputFileName);//creates a file output object

        Scanner fileScan = null;        //instantiates the scanner with null
        PrintWriter filePrint = null;   //instantiates the print writer with null

        try{
            fileScan = new Scanner(fileIn);
            filePrint = new PrintWriter(fileOut);
            int lineCount = 0;

            System.out.printf("Lines in %s containing %s: \n", args[0], args[1]); // prints to the console
            filePrint.printf("Lines in %s containing %s: \n", args[0], args[1]); //prints to the new txt file

            while(fileScan.hasNextLine()){ //checks each line for the chosen word until there are no more lines to read
                String line = fileScan.nextLine();
                if(line.contains(word)){
                    System.out.println(lineCount + ": " + line); //prints to the console
                    filePrint.println(lineCount + ": " + line); //writes the lines that include "we" to the new txt file
                }
                lineCount++;
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage()); //if the program throws a file not found exception error, this prints the error to the console
        }
        finally{
            if(fileScan != null){
                fileScan.close(); //closes the scanner
            }
            if(filePrint != null){
                filePrint.close();
            }
        }
    }
}
