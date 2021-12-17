package Pruefung;

import gmbh.kdb.hsw.gdp.Game;
import gmbh.kdb.hsw.gdp.domain.GameDevStudio;
import gmbh.kdb.hsw.gdp.domain.Money;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Main Class witch runs the Game in the main methode and refers to the other Classes.
 **/
public class MainMenu {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Game.create(MainMenu::menu).start();
    }

    /**
     * This methode prints out the main menu tho the console.
     */
    public static void printMenu() {
        System.out.println("please enter a number to choose one of the following: ");
        System.out.println("0 to end the game ");
        System.out.println("1 to continue ");
        System.out.println("2 for evaluation");
        System.out.println("3 for applicants");
        System.out.println("4 for project-menu");
    }

    /**
     * Checks if the max amount of actions is exceeded.
     * If not the user input is checked and the corresponding menu is printed.
     *
     * @param studio passed GameDevStudio for access to game data
     **/
    public static boolean menu(GameDevStudio studio) {
        while (true) {
            if (SubMenus.actionCounter < 3) {

                //getting user input
                printMenu();
                System.out.println();
                var input = sc.nextLine();
                //sc.nextLine();

                switch (input) {
                    case "0" -> {
                        System.out.println("game stopped");
                        return false; //if "false" is returned, the game will be stopped
                    }
                    case "1" -> {
                        if ((!studio.getCash().isGreaterThan(new Money(new BigDecimal(0))))) {
                            System.out.println("You are bankrupt!");
                            return false;
                        }
                        SubMenus.actionCounter = 0; //counter is set to 0 in order to start the next tick witch 3 remaining actions.d
                        System.out.println("the game will be continued");
                        System.out.println("----------------------------------------------------");
                        System.out.println("the following shows relevant information of your business: ");
                        System.out.println("studio-name: " + studio.getName().getName()); //first .getName() returns address of name, second returns actual name
                        System.out.println("liquidity: " + studio.getCash());
                        System.out.println("amount of pending applications: " + studio.getApplications().size());
                        System.out.println("amount of offices: " + studio.getOffices().size());
                        System.out.println("----------------------------------------------------");
                        return true;

                    }
                    case "2" -> {
                        System.out.println("Evaluation: ");
                        SubMenus.evaluation(studio, Game.get().getEventLog());
                    }
                    case "3" -> {
                        System.out.println("applicants: ");
                        SubMenus.applicants(studio);
                    }
                    case "4" -> {
                        System.out.println("projects: ");
                        SubMenus.projects(studio);
                    }
                    default -> //return false;
                            System.out.println("not a valid input.");
                }
            } else {
                if ((studio.getCash().isGreaterThan(new Money(new BigDecimal(0))))) {
                    System.out.println("you are bankrupt!");
                    return false;
                } else {
                    SubMenus.actionCounter = 0; //counter is set to 0, in order to continue "freshly" in the next round
                    System.out.println("the maximum ammount of turns for this round is reached, the game will be continued...");
                    System.out.println("----------------------------------------------------");
                    System.out.println("the following shows relevant information of your business: ");
                    System.out.println("studio-name " + studio.getName().getName()); //first .getName() returns address of name, second returns actual name
                    System.out.println("liquidity: " + studio.getCash());
                    System.out.println("amount of pending applications: " + studio.getApplications().size());
                    System.out.println("amount of offices: " + studio.getOffices().size());
                    System.out.println("----------------------------------------------------");
                    return true;
                }
            }
        }
    }
}