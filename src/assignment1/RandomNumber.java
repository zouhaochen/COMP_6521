package assignment1;

import java.util.Random;
import java.util.Scanner;

public class RandomNumber
{
    public static int[] randomListCreation()
    {
        String regex = "^[1-9]\\d*$";
        String userInput = "";
        String userInputMinValue = "";
        String userInputMaxValue = "";
        int numberOfRandomInteger = 0;
        int[] randomNumberList;
        int minValue = 0;
        int maxValue = 0;

        System.out.println("Create a random number list.");
        System.out.println("Please input the number of random integers to generate:");
        Scanner keyboard = new Scanner(System.in);
        userInput = keyboard.nextLine();

        while(!userInput.matches(regex))
        {
            System.out.println("\nPlease input a valid integer.");
            userInput = keyboard.nextLine();
        }

        numberOfRandomInteger = Integer.parseInt(userInput);

        System.out.println("\nPlease input the minimum value of random integer:");
        userInputMinValue = keyboard.nextLine();

        while(true)
        {
            if(userInputMinValue.matches("^-[0-9]*[1-9][0-9]*$"))
            {
                if(userInputMinValue.charAt(1) == '0')
                {
                    System.out.println("\nPlease input a valid integer.");
                    userInputMinValue = keyboard.nextLine();
                    continue;
                }
                else
                    break;
            }
            else if (userInputMinValue.matches("^[0-9]*[1-9][0-9]*$"))
            {
                if(userInputMinValue.charAt(0) == '0' && userInputMinValue.charAt(1) == '0')
                {
                    System.out.println("\nPlease input a valid integer.");
                    userInputMinValue = keyboard.nextLine();
                    continue;
                }
                else
                    break;
            }
            else if (userInputMinValue.equals("0"))
            {
                break;
            }
            else
            {
                System.out.println("\nPlease input a valid integer.");
                userInputMinValue = keyboard.nextLine();
                continue;
            }
        }

        minValue = Integer.parseInt(userInputMinValue);

        System.out.println("\nPlease input the maximum value of random integer:");
        userInputMaxValue = keyboard.nextLine();

        while(true)
        {
            if(userInputMaxValue.matches("^-[0-9]*[1-9][0-9]*$"))
            {
                if(userInputMaxValue.charAt(1) == '0')
                {
                    System.out.println("\nPlease input a valid integer.");
                    userInputMaxValue = keyboard.nextLine();
                    continue;
                }
                else
                    break;
            }
            else if (userInputMaxValue.matches("^[0-9]*[1-9][0-9]*$"))
            {
                if(userInputMaxValue.charAt(0) == '0' && userInputMaxValue.charAt(1) == '0')
                {
                    System.out.println("\nPlease input a valid integer.");
                    userInputMaxValue = keyboard.nextLine();
                    continue;
                }
                else
                    break;
            }
            else if (userInputMaxValue.equals("0"))
            {
                break;
            }
            else
            {
                System.out.println("\nPlease input a valid integer.");
                userInputMaxValue = keyboard.nextLine();
                continue;
            }
        }

        maxValue = Integer.parseInt(userInputMaxValue);

        randomNumberList = new int[numberOfRandomInteger];

        for(int i = 0; i < numberOfRandomInteger; i++)
        {
            randomNumberList[i] = getRandomNumberInRange(minValue,maxValue);
        }

        return randomNumberList;
    }

    private static int getRandomNumberInRange(int min, int max)
    {
        Random random = new Random();
        return random.ints(min, (max+1)).limit(1).findFirst().getAsInt();
    }
}