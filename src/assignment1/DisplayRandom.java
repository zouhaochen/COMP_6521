package assignment1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DisplayRandom
{
    public static void displayRandom()
    {
        String path = "./src/assignment1/input.txt";
        File file = new File(path);

        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(file);
            System.out.println("\nTotal file size to read (in bytes): " + fis.available() + ".");
            int content;

            while ((content = fis.read()) != -1)
            {
                System.out.print((char) content);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (fis != null)
                {
                    fis.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
