package Pruefung;

import gmbh.kdb.hsw.gdp.Game;
import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

import java.util.List;

import java.util.Scanner;

public class MainMenu {
    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        Game.create(studio -> {

            return menu(studio);
        }).start();
    }

    public static void printMenu(){
        System.out.println("please enter a number to choose one of the following: ");
        System.out.println("1 for action-menu");
        System.out.println("2 for evaluation");
        System.out.println("3 to continue ");
        System.out.println("0 to end the game ");
    }

    public static boolean menu(GameDevStudio studio) {
        while(true) { // see case 1
            printMenu();
            System.out.println("");
            var input = sc.nextInt();
            sc.nextLine();
            switch (input) {
                case 1: {
                    System.out.println("action-menu: ");
                    action();
                    break;
                }
                case 2: {
                    System.out.println("Evaluation: ");
                    evaluation(studio, Game.get().getEventLog());
                    break; //ensures ability to make a decision despite evaluating
                }
                case 3: {
                    if ((studio.getCash().getValue().intValue() <= 0)) {
                        System.out.println("You are bankrupt!");
                        return false;
                    }
                    System.out.println("the game will be continued");
                    System.out.println("----------------------------------------------------");
                    System.out.println("the following shows relevant information of your business: ");
                    System.out.println("studio-name " + studio.getName().getName()); //first .getName() returns address of name, second returns actual name
                    System.out.println("liquidity: " + studio.getCash());
                    System.out.println("amount of pending applications: " + studio.getApplications().size());
                    System.out.println("amount of offices: " + studio.getOffices().size());
                    System.out.println("----------------------------------------------------");
                    return true;

                }
                case 0: {
                    System.out.println("game stopped");
                    return false;
                }
                default: {
                    System.out.println("not a valid input. The game will be stopped.");
                    return false;
                }
            }
        }
    }


    public static void evaluation(GameDevStudio studio, List<String> eventLog) {
        DeveloperInformation devInfo = new DeveloperInformation(studio);
        OfficeInformation officeInfo = new OfficeInformation(studio);
        EventLogInformation eventLogInfo = new EventLogInformation(studio, eventLog);
        while (true) {
            System.out.println("");

            System.out.println("choose one of the following: ");
            System.out.println("1 to show Event Log ");
            System.out.println("2 to show office information");
            System.out.println("3 to show developer information");
            System.out.println("4 to exit evaluation menu");
            Scanner sc = new Scanner(System.in);
            var input = sc.nextInt();


            switch (input) {
                case 1: {
                    //Event log
                    eventLogInfo.print();
                    break;
                }
                case 2: {
                    //Office overview
                    officeInfo.print();
                    break;
                }
                case 3: {
                    //Developer
                    devInfo.print();
                    break;
                }
                case 4: {
                    return;
                }
                default:
            }
        }
    }
    public static void action(){

    }
}