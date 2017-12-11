/*
Filename:   FileOp.java
Author:     Connor Ness
Date:       December 10, 2017

FileOp handles all of the file operations. It either appends a line to a file
 or scans a file, line by line, searching for a match.
 */

import java.io.*;

public class FileOp {
    private String fileName;

    FileOp(String file) {
        fileName = file;
    }

    // addLine adds a line to the file.
    public void addLine(String line) {
        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(fileName, true);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + fileName + "'");
        }
    }

//  contains looks through the file, line by line, and returns a boolean value
//   whether the target value (token) was found
    public boolean contains(String token) {
        boolean found = false;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if(token.equals(line)) {
                    found = true;
                    break;
                }
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
        return found;
    }
}
