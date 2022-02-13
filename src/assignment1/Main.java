package assignment1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main
{

    public static void main(String[] args)
    {
        int[] randomList;
        boolean flag = true;

        while(flag)
        {
            System.out.println("Please input a choice number:");
            System.out.println("1. Create a random list of integers.");
            System.out.println("2. Display the random list.");
            System.out.println("3. Run 2PMMS.");
            System.out.println("4. Exit.");
            Scanner keyboard = new Scanner(System.in);
            String inputChoice = keyboard.nextLine();

            while (!inputChoice.equals("1") && !inputChoice.equals("2") && !inputChoice.equals("3") && !inputChoice.equals("4")) {
                System.out.println("Please input a valid choice.");
                inputChoice = keyboard.nextLine();
            }

            switch (inputChoice)
            {
                case "1":
                    System.out.println();
                    randomList = RandomNumber.randomListCreation();
                    System.out.println("Random list of integers is created.");

                    try
                    {
                        String path = "./src/assignment1/input.txt";

                        File f = new File(path);
                        BufferedWriter out = new BufferedWriter(new FileWriter(f,true));
                        for(int i = 0; i < randomList.length; i++)
                        {
                            out.write(String.valueOf(randomList[i])+"\r\n");
                        }
                        out.close();
                        System.out.println("Random list text file is created");
                    }
                    catch (IOException e)
                    {
                        System.out.println("Exception occurs");
                    }
                    System.out.println();
                    break;
                case "2":
                    break;
                case "3":
                    ArrayList<Integer> input = Phase1.input();
                    List<List<Integer>> blocks = Phase1.sortBlocks(input);
                    Phase1.generateSubFiles(blocks);
                    break;
                case "4":
                    flag = false;
                    System.out.println("\nExit the program, see you next time!");
                    System.exit(0);
                    break;
            }
        }

    }
}
