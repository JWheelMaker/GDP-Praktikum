package Pruefung;

import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class SubMenus {
    private static Scanner scanner = new Scanner(System.in);

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

    public static void applicants(GameDevStudio studio) {
        BigDecimal costs = calcCosts(studio);

        System.out.println("---------------------------------------");
        for (int i = 0; i < studio.getApplications().size(); i++) {
            System.out.println(i+1 + ".  " + studio.getApplications().get(i).getDeveloper().getName().getName());

            //subtracting the costs of employing from capital
            BigDecimal remaining = studio.getCash().getValue().subtract(studio.getApplications().get(i).getHireBonus().getValue().add(studio.getApplications().get(i).getHireAgentFee().getValue()));

            System.out.println("Remaining capital: " + remaining);

            //calculating the new costs per round and remaining rounds
            BigDecimal newCosts = costs.add(studio.getApplications().get(i).getDeveloper().getSalary().getValue());
            BigDecimal remainingRounds = studio.getCash().getValue().subtract(studio.getApplications().get(i).getHireBonus().getValue().add(studio.getApplications().get(i).getHireAgentFee().getValue()).divide(newCosts));

            System.out.println("Remaining game rounds: " + remainingRounds);

        }
        System.out.println("---------------------------------------");

        System.out.println("Would you like to hire one of the above? (yes/no)");
        String input = scanner.nextLine();
        if (input.equals("yes") || input.equals("y") || input.equals("Yes")) {
            System.out.println("Please enter a valid application number or die ");
            int inputInt = scanner.nextInt();
            scanner.nextLine();
            // new applicant will always be employed at the first office
            studio.acceptApplication(studio.getApplications().get(inputInt), studio.getOffices().get(0));


        }
    }

    public static BigDecimal calcCosts(GameDevStudio studio) {
        BigDecimal sum = new BigDecimal(0);

        for (int i = 0; i < studio.getOffices().size(); i++) {
            sum.add(studio.getOffices().get(i).getLease().getValue());
            for (int j = 0; j < studio.getOffices().get(i).getDevelopers().size(); j++) {
                sum.add(studio.getOffices().get(i).getDevelopers().get(j).getSalary().getValue());
            }
        }
        return sum;
    }

    public static void projects(GameDevStudio studio) {

    }


}
