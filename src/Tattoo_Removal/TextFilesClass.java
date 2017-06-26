package Tattoo_Removal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
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

    public static void replaceCharacters (String filename) throws IOException {
        RandomAccessFile fileHandle = new RandomAccessFile(filename, "rw");
        //long position = 0;

        for (int i = 0; i < fileHandle.length(); i++) {
            byte currentByte = fileHandle.readByte();
            char currentChar = (char)currentByte;
            System.out.println(i + "     Char: " + currentChar + " Byte: " +  currentByte);

            if (currentChar == 'x'){

              //fileHandle.seek(position);
                fileHandle.seek(fileHandle.getFilePointer() - 1);
                fileHandle.writeByte(42);
            }
            //position = position + 1;
        }
        fileHandle.close();
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
