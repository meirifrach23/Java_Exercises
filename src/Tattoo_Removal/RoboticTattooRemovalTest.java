package Tattoo_Removal;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class RoboticTattooRemovalTest {

    RoboticTattooRemoval roboticTattooRemoval = new RoboticTattooRemoval();

    @Test
    public void test1() throws Exception {

        String fileBeforeReplacing = RoboticTattooRemoval.copy2DArrayIntoFile("C:/incoming/input.txt",
                new String[][]{
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
                        {" ", " ", " ", "X", " ", " ", " ", "x", " ", " ", " "},
                        {" ", " ", " ", " ", "X", " ", "X", " ", " ", " ", " "},
                        {" ", " ", " ", " ", " ", "X", " ", " ", " ", " ", " "},
                        {" ", " ", " ", " ", " ", "X", " ", " ", " ", " ", " "},
                        {" ", " ", " ", " ", " ", " ", " ", " ", " ", "P", " "},
                        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}
                });
        String fileAfterReplacing = RoboticTattooRemoval.robot(fileBeforeReplacing, "C:/incoming/inputFileAfterReplaceChars.txt");
        String referenceFile = RoboticTattooRemoval.copy2DArrayIntoFile("C:/incoming/ref.txt", new String[][]{
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
        });

        File referenceFileObject = new File(referenceFile);
        File FileAfterReplaceCharsObject = new File(fileAfterReplacing);
        assertTrue(FileUtils.contentEquals(referenceFileObject, FileAfterReplaceCharsObject));
    }
}