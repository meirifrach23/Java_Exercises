package Tattoo_Removal;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


/**
 * Created by batel on 23/06/2017.
 */
public class TextFilesClass {
    public static String path = "C:/incoming/text.txt";

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public TextFilesClass(String path) {

        this.path = path;
    }


    public static String replaceCharacters (String filename) throws IOException {
        RandomAccessFile fileHandle = new RandomAccessFile(filename, "rw");
        //long position = 0;

        for (int i = 0; i < fileHandle.length(); i++) {
            byte currentByte = fileHandle.readByte();
            char currentChar = (char)currentByte;
            System.out.println(i + "     Char: " + currentChar + " Byte: " +  currentByte);

            if (currentChar == 'x' || currentChar == 'X'){

                //fileHandle.seek(position);
                fileHandle.seek(fileHandle.getFilePointer() - 1);
                fileHandle.writeByte(42);
            }
            //position = position + 1;
        }
        fileHandle.close();
        return filename;
    }

    public static void replaceCharactersAndWriteToNewFile (String filename, String filename2) throws IOException {
        RandomAccessFile fileHandle = new RandomAccessFile(filename, "rw");
        RandomAccessFile fileHandle2 = new RandomAccessFile(filename2, "rw");
        //long position = 0;

        for (int i = 0; i < fileHandle.length(); i++) {
            byte currentByte = fileHandle.readByte();
            char currentChar = (char)currentByte;
            System.out.println(i + "     Char: " + currentChar + " Byte: " +  currentByte);

            if (currentChar == 'x'){
                fileHandle2.writeByte(42);
            }
            else {
                fileHandle2.writeByte(currentChar);
            }

        }
        fileHandle.close();
        fileHandle2.close();
    }

    public static char[][] copyFileTextInto2DArray(String filename) throws IOException{
        RandomAccessFile fileHandle = new RandomAccessFile(filename, "rw");
        int j = 0;
        int k = 0;
        char[][] array2d = new char[5][7];
        for (int i = 0; i < fileHandle.length(); i++) {
            byte currentByte = fileHandle.readByte();
            char currentChar = (char)currentByte;
            System.out.println(i + "     Char: " + currentChar + " Byte: " +  currentByte);



            if (currentChar == '\r'){
                j++;
                k = 0;
                System.out.println("lalala" + j + k);
            }

            else{
                array2d[j][k] = currentChar;
                k++;
                System.out.println("tatata" + j +k);
            }
        }
        fileHandle.close();

        for (j = 0; j < array2d.length; j++){
            for (k = 0; k < array2d[j].length; k++){
                System.out.print(array2d[j][k]);
            }
        }
        return array2d;
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
        System.out.println("Done ..........");

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }



    public static void printFile() {

        Path file = Paths.get(path);
        try {
/*
            byte[] fileArray = Files.readAllBytes(file);

            for (int i = 0; i < fileArray.length; i++) {
                System.out.print((char)fileArray[i]);
            }
            System.out.println();
*/


            //Files.write(file, "content".getBytes(), StandardOpenOption.APPEND);

            for (int i = 0; i < 5; i++) {

                Files.write(file, "content\n".getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static int readFromPosition(String filename, long position)
            throws IOException {
        int result = 0;
        RandomAccessFile reader = new RandomAccessFile(filename, "r");

        long EOF = reader.getFilePointer();
        System.out.println("*****" + EOF + "*****");

        reader.seek(position);

        long EOF2 = reader.getFilePointer();
        System.out.println("*****" + EOF2 + "*****");

        result = reader.readInt();
        reader.close();
        return result;
    }

    public static void writeToPosition(String filename, int data, long position)
            throws IOException {
        RandomAccessFile writer = new RandomAccessFile(filename, "rw");
        writer.seek(position);
        writer.writeInt(data);
        writer.close();
    }



    public static byte[] readContentIntoByteArray(File file)
    {
        FileInputStream fileInputStream = null;
        byte[] bFile = new byte[(int) file.length()];
        try
        {
            //convert file into array of bytes
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
            for (int i = 0; i < bFile.length; i++)
            {
                System.out.print( (char) bFile[i]);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println();
        return bFile;
    }

}
