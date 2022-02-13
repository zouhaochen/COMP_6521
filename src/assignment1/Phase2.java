package assignment1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phase2
{
    //Merge sorting for all sub lists
    public static List<List<Integer>>sortList (int BlockNum)
    {
        Scanner sc = null;
        List<List<Integer>> readInput = new ArrayList<>();

        //read all subFiles
        for (int i = 0; i < BlockNum; i++)
        {
            List<Integer> subInput = new ArrayList<>();
            try
            {
                sc = new Scanner(new FileInputStream("./src/assignment1/subfile/subFile" + (i + 1) + ".txt"));
            } catch (FileNotFoundException e) {
                System.out.println("Could not open input file");
                System.exit(0);
            }
            while (sc.hasNextLine()) {
                String num = sc.nextLine();
                subInput.add(Integer.parseInt(num));
            }
            readInput.add(subInput);
            System.out.println(subInput);
        }
        System.out.println(readInput);
        return readInput;
    }
}
