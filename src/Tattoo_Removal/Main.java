package Tattoo_Removal;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

//import org.apache.commons.io.FileUtils;

//import static Tattoo_Removal.TextFilesClass.copy2DArrayIntoFile;
import static Tattoo_Removal.TextFilesClass.copy2DArrayIntoFile;
import static Tattoo_Removal.TextFilesClass.copyFileTextInto2DArray;
import static Tattoo_Removal.TextFilesClass.path;


public class Main {

    public static void main(String[] args) throws IOException {
        //printFile();
        //File file = new File("C:/incoming/text.txt");

        //readContentIntoByteArray(file);

        //int cc = TextFilesClass.readFromPosition("C:/incoming/text.txt", 1);
        //System.out.println(cc);
        //TextFilesClass.writeToPosition("C:/incoming/text2.txt", cc, 0);
        //TextFilesClass.replaceCharacters("C:/incoming/text.txt");
        //TextFilesClass.replaceCharactersAndWriteToNewFile("C:/incoming/text.txt", "C:/incoming/text2.txt");


/*
        char[][] array2d = new char[15][15];
        array2d = copyFileTextInto2DArray("C:/incoming/text.txt");
        for (int j = 0; j < array2d.length; j++){
            for (int k = 0; k < array2d[j].length; k++){
                System.out.print(array2d[j][k]);
            }
        }
*/

/*
        char[][] array2d = new char[][]{
                { 'a', 'b', 'c' },
                { '1', '2', '3', '4' },
                { '%', '*' },
                { 'x' },
                { '1', 'y', 'Z', '4', 'g' }
        };
*/

/*
        String[][] array2d = new String[][]{
                { "a", "b", "c" },
                { "1", "2", "3", "4" },
                { "%", "*" },
                { "x" },
                { "1", "y", "Z", "4", "g" }
        };
*/

        String[][] referenceArray2d = new String[][]{
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", "*", "*", " ", " ", " ", "*", "*", " ", " "},
                {" ", "*", " ", " ", "*", " ", "*", " ", " ", "*", " "},
                {" ", "*", " ", " ", " ", "*", " ", " ", " ", "*", " "},
                {" ", "*", " ", " ", " ", "*", " ", " ", " ", "*", " "},
                {" ", "*", " ", " ", " ", " ", " ", " ", " ", "*", " "},
                {" ", "*", " ", " ", " ", " ", " ", " ", " ", "*", " "},
                {" ", "*", " ", " ", " ", " ", " ", " ", " ", "*", " "},
                {" ", " ", "*", " ", " ", " ", " ", " ", "*", " ", " "},
                {" ", " ", " ", "*", " ", " ", " ", "*", " ", " ", " "},
                {" ", " ", " ", " ", "*", " ", "*", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", "P", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}
        };
        String[][] inputArray2d = new String[][]{
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", "X", "X", " ", " ", " ", "X", "X", " ", " "},
                {" ", "X", " ", " ", "X", " ", "X", " ", " ", "X", " "},
                {" ", "X", " ", " ", " ", "X", " ", " ", " ", "X", " "},
                {" ", "X", " ", " ", " ", "X", " ", " ", " ", "X", " "},
                {" ", "X", " ", " ", " ", " ", " ", " ", " ", "X", " "},
                {" ", "X", " ", " ", " ", " ", " ", " ", " ", "X", " "},
                {" ", "X", " ", " ", " ", " ", " ", " ", " ", "X", " "},
                {" ", " ", "X", " ", " ", " ", " ", " ", "X", " ", " "},
                {" ", " ", " ", "X", " ", " ", " ", "X", " ", " ", " "},
                {" ", " ", " ", " ", "X", " ", "X", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", "X", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", "X", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", "P", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}
        };

        String referenceFile = copy2DArrayIntoFile("C:/incoming/ref.txt", referenceArray2d);


        String inputFileBeforeReplaceChars = copy2DArrayIntoFile("C:/incoming/input.txt", inputArray2d);
        String FileAfterReplaceChars = RoboticTattooRemoval.robot(inputFileBeforeReplaceChars, "C:/incoming/inputFileAfterReplaceChars.txt");


        Path firstFile = Paths.get(referenceFile);
        Path secondFile = Paths.get(FileAfterReplaceChars);
        byte[] fileToBytes1 = Files.readAllBytes(firstFile);
        byte[] fileToBytes2 = Files.readAllBytes(secondFile);
        boolean isArraysEquals = Arrays.equals(fileToBytes1, fileToBytes2);
        System.out.println(isArraysEquals);

        File referenceFileObject = new File(referenceFile);
        File FileAfterReplaceCharsObject = new File(FileAfterReplaceChars);
        boolean isFilesEquals = FileUtils.contentEquals(referenceFileObject, FileAfterReplaceCharsObject);
        System.out.println(isFilesEquals + " " + isFilesEquals);
    }
}
