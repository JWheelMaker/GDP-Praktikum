package Vorbereitung;

import java.util.Scanner;

public class Caesar {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter text.");
        var input = sc.nextLine();

        while (!input.equals("quit")) {
            System.out.println("Please enter encryption key.");
            var key = sc.nextInt();

            System.out.println("Input: " + input);

            char[] arr = input.toCharArray();

            String output = "";

            for (char ch : arr) {
                int ascii = (int) ch;

                if (ascii > 77 && ascii < 91) {
                    ascii -= 26;
                }
                if (ascii > 109) {
                    ascii -= 26;
                }

                ascii += key;

                if (ascii == 32 + key) {
                    ascii = 32;
                }

                output += (char) ascii;
            }

            System.out.println("Output: " + output);
            System.out.println("");

            sc.nextLine();
            System.out.println("Please enter text.");
            input = sc.nextLine();
        }
    }
}