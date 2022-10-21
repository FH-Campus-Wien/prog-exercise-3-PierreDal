package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class App {

    // Implement all methods as public static
    public static void oneMonthCalendar(int days, int firstday) {
        int rows;

        if ((days + firstday) % 7 != 0) {
            rows = (days / 7) + 1;
        } else {
            rows = days / 7;
        }


        for (int i = 1; i < firstday; i++) {
            System.out.print("   ");
        }

        int count = 1;
        int column = firstday;

        for (int a = 0; a < rows; a++) {
            while (column <= 7) {
                System.out.printf("%2d ", count);
                if (count == days) {
                    System.out.println();
                    return;
                }
                column++;
                count++;
            }
            column = 1;
            System.out.println();
        }
    }


    public static long[] lcg(long seed) {
        long modul = (long) Math.pow(2, 31); //2^31
        long c = 12345; //Inkrement
        long a = 1103515245; // Faktor

        long[] numbers = new long[11]; // Long Zahlen Array
        numbers[0] = seed; // Startwert

        //Zufallsgen: X = (a*Xi + c)%m

        for (int i = 0; i < 10; i++)
        {
            numbers[i + 1] = (a * numbers[i] + c) % modul;
        }
        return Arrays.copyOfRange(numbers, 1, numbers.length);
    }


    public static void guessingGame(int numberToGuess) {
        Scanner scanner = new Scanner(System.in);
        int guessNum;

        for (int i = 1; i < 11; i++)
        {
            System.out.print("Guess number " + i + ":");
            guessNum = scanner.nextInt();

            if (guessNum == numberToGuess)
            {
                System.out.println(" You won wisenheimer!");
                break;
            }
            else if (i == 10)
            {
                System.out.println(" You lost! Have you ever heard of divide & conquer?");
                break;
            }
            else if (guessNum > numberToGuess)
            {
                System.out.println(" The number AI picked is lower than your guess.");
            }
            else
            {
                System.out.println(" The number AI picked is higher than your guess.");
            }
        }
    }

    public static int randomNumberBetweenOneAndHundred() {
        int min = 1;
        int max = 100;
        int rdm = (int) (Math.random() * (max - min)) + min;
        return rdm;
    }

    public static boolean swapArrays(int arr1[], int arr2[]){
        if(arr1.length != arr2.length)
        {
            return false;
        }
        else
        {
            for(int i = 0 ; i<arr1.length;i++)
            {
                arr1[i] = arr1[i] - arr2[i];
                arr2[i] = arr2[i] + arr1[i];
                arr1[i] = arr2[i] - arr1[i];
            }
        } return true;
    }

    public static String camelCase(String satz){
        char[] charArray = satz.toCharArray();

        if (charArray[0] >= 97 && charArray[0] <= 122)
            charArray[0] -= 32;

        for (int i = 0; i < charArray.length; i++)
        {
            if (i >= 1 && charArray[i-1] == ' ' && charArray[i] >= 97 && charArray[i] <= 122)
            {
                charArray[i] -= 32;
            }
            if (i >= 1 && charArray[i-1] != ' ' && charArray[i] >= 65 && charArray[i] <= 90)
            {
                charArray[i] += 32;
            }
        }

        for (int i = 0; i < charArray.length; i++)
        {
            if ((charArray[i] > 0 && charArray[i] <= 64) || (charArray[i] >= 91 && charArray[i] <= 96) || (charArray[i] >= 123 && charArray[i] <= 127))
            {
                charArray[i] = 32;
            }
        }

        String ohneLZ = String.valueOf(charArray).replace(" ", "");
        return ohneLZ;

    }

    public static int checkDigit(int arr[]){
        int rest;
        int ziffer;
        int gewichtung = 2;
        int sum = 0;

        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i] * (gewichtung+i);
        }
        rest = sum%11;
        ziffer = 11 - rest;
        if (ziffer == 10)
        {
            return 0;
        }
        else if (ziffer == 11)
        {
            return 5;
        }
        else
        {
            return ziffer;
        }
    }

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc

        System.out.println("Aufgabe 1:");
        oneMonthCalendar(30,3);
        System.out.println();

        System.out.println("Aufgabe 2:");
        lcg(12345);
        System.out.println();

        System.out.println("Aufgabe 3:");
        guessingGame(randomNumberBetweenOneAndHundred());
        System.out.println();

        System.out.println("Aufgabe 4:");
        int[] array1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] array2 = new int[]{100, 202, 30, 14, 15, 16};
        swapArrays(array1,array2);
        System.out.println();

        System.out.println("Aufgabe 5:");
        camelCase("abc abc abc aBc");
        System.out.println();

        System.out.println("Aufgabe 6:");
        checkDigit(array1);
        System.out.println();

    }
}


