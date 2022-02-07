package assignment1;

import java.util.Scanner;

import static assignment1.RandomNumber.randomListCreation;

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
                    randomList = randomListCreation();
                    System.out.println("Random list of integers is created.");
                    System.out.println();
                    break;
                case "2":
                    break;
                case "3":
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
