package Tattoo_Removal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by meiri on 03/07/2017.
 */
public class RoboticTattooRemoval {

    public static String robot (String inputFilename, String OutputFileName) throws IOException {
        RandomAccessFile inputFileHandle = new RandomAccessFile(inputFilename, "rw");
        RandomAccessFile outputFileHandle = new RandomAccessFile(OutputFileName, "rw");

        for (int i = 0; i < inputFileHandle.length(); i++) {
            byte currentByte = inputFileHandle.readByte();
            char currentChar = (char)currentByte;
            System.out.println(i + "     Char: " + currentChar + " Byte: " +  currentByte);

            if (currentChar == 'x' || currentChar == 'X'){
                outputFileHandle.writeByte(42);
            }
            else {
                outputFileHandle.writeByte(currentChar);
            }
        }
        inputFileHandle.close();
        outputFileHandle.close();
        return OutputFileName;
    }


    public static String copy2DArrayIntoFile(String filename, String[][] array2d) {

        StringBuilder builder = new StringBuilder();

        FileWriter out = null;
        try {
            out = new FileWriter(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int arrayNumRows = array2d.length;

        for (int i = 0; i < arrayNumRows; i++) {

            for(String s : array2d[i]) {
                builder.append(s);
            }
            String str = builder.toString();

            try {
                out.write(str);
                builder.delete(0,str.length());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.write('\n');
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }
}
