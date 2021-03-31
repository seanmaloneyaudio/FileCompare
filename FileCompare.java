package edu.belmont.csc3130;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileCompare {
    public static ArrayList<String> parseFile(String filename) {
        ArrayList<String> expressions = new ArrayList<>();
        try {
            FileInputStream input = new FileInputStream(filename);
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                expressions.add(reader.nextLine());
            }
            reader.close();
            input.close();
        } catch (Exception e) {
            /*using printStackTrace shows the line where the error is...
            System.out.println does not do this */
            e.printStackTrace();
        }
        return expressions;
    }

    public static void compareFiles (String fileOne, String fileTwo) {
        List<String> lines;
        List<String> lines2;
        lines = parseFile(fileOne);
        lines2 = parseFile(fileTwo);
        int min = Math.min(lines.size(), lines.size());
        for(int i = 0; i < min; i++) {
            String a = lines.get(i);
            String b = lines2.get(i);
            if(!a.equals(b)) {
                System.out.println("Not the same\nFile 1: " + lines.get(i) + "\nFile 2: "+ lines2.get(i));
            }
        }

    }

    public static void main(String[] args) {
        Scanner myFile = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter file name (exactly)");

        String fileName = myFile.nextLine();  // Read user input
        System.out.println("Enter file name 2 (exactly)");
        String fileName2 = myFile.nextLine();
        System.out.println("File name is: " + fileName);  // Output user input
        System.out.println("File name 2 is: " + fileName2);  // Output user input
        compareFiles(fileName, fileName2);
    }
}

