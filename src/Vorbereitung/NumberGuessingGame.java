package Vorbereitung;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static int minimumwert = 0;
    private static int maximumwert = 1;
    private static int anzahlVersuche = 4;
    private static int durchlauf = 0;
    private static Random rd = new Random();
    private static Scanner scanner = new Scanner(System.in);
    private static int zufall;

    public static void main(String[] args) throws Exception {
        schwierigkeit();
        zufall = (int) rd.nextInt(minimumwert, maximumwert);
        while (true) {
            if (eingabe() == 0) return;
            System.out.println("Weiter? (ja/nein)");
            String eingabe = scanner.nextLine();
            if (eingabe.equals("nein") || eingabe.equals("n") || eingabe.equals("Nein")) return;

        }
    }

    public static void schwierigkeit() {
        while (true) {
            System.out.println("Schwierigkeit: (1 bis 5) ");
            int schwierigkeitseinstellung = scanner.nextInt();
            scanner.nextLine();
            switch (schwierigkeitseinstellung) {
                case 1:
                    minimumwert = rd.nextInt(-10, 0);
                    maximumwert = rd.nextInt(0, 10);
                    System.out.println("Min: " + minimumwert + " Max: " + maximumwert);
                    return;
                case 2:
                    minimumwert = rd.nextInt(-20, -3);
                    maximumwert = rd.nextInt(3, 20);
                    System.out.println("Min: " + minimumwert + " Max: " + maximumwert);
                    return;
                case 3:
                    minimumwert = rd.nextInt(-30, -6);
                    maximumwert = rd.nextInt(6, 30);
                    System.out.println("Min: " + minimumwert + " Max: " + maximumwert);
                    return;
                case 4:
                    minimumwert = rd.nextInt(-40, -9);
                    maximumwert = rd.nextInt(9, 40);
                    System.out.println("Min: " + minimumwert + " Max: " + maximumwert);
                    return;
                case 5:
                    minimumwert = rd.nextInt(-50, -12);
                    maximumwert = rd.nextInt(12, 50);
                    System.out.println("Min: " + minimumwert + " Max: " + maximumwert);
                    return;
                default:
            }
        }
    }

    public static int eingabe() throws Exception {
        System.out.println("Geben Sie bitte eine Zahl ein: ");
        int eingabe = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Zufallszahl: " + zufall);
        int erg = guess(eingabe);
        System.out.println("Rückgabe: " + erg);
        return erg;
    }

    public static int guess(int z) throws Exception {
        if (durchlauf < anzahlVersuche - 1) {
            durchlauf++;
            if (z < zufall) return -1;
            else if (z > zufall) return 1;
            System.out.println("Glückwunsch!! Deine Antwort ist richtig.");
            return 0;
        } else throw new RuntimeException("Anzahl der Versuche ueberschritten");

    }
}

