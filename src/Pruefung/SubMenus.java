package Pruefung;

import gmbh.kdb.hsw.gdp.domain.Developer;
import gmbh.kdb.hsw.gdp.domain.GameDevStudio;
import gmbh.kdb.hsw.gdp.domain.Money;

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
        Money costs = calcCosts(studio);

        System.out.println("---------------------------------------");
        for (int i = 0; i < studio.getApplications().size(); i++) {
            System.out.println(i + 1 + ".  " + studio.getApplications().get(i).getDeveloper().getName().getName());

            //subtracting the costs of employing from capital
            Money remaining = studio.getCash();
            remaining = remaining.subtract(studio.getApplications().get(i).getHireBonus());
            remaining = remaining.subtract(studio.getApplications().get(i).getHireAgentFee());

            System.out.println("Remaining capital: " + remaining);

            //calculating the new costs per round and remaining rounds
            Money newCosts = costs.add(studio.getApplications().get(i).getDeveloper().getSalary());
            int remainingRounds = 0;
            while (remaining.isGreaterThan(newCosts)) {
                remaining = remaining.subtract(newCosts);
                remainingRounds++;
            }
            System.out.println("Remaining game rounds: " + remainingRounds);

        }
        System.out.println("---------------------------------------");

        System.out.println("Would you like to hire one of the above? (yes/no)");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("yes") || input.equals("y")) {
            // new applicant will always be employed at the first office
            //studio.acceptApplication(studio.getApplications().get(inputInt), studio.getOffices().get(0));
            System.out.println("Please enter a valid application number or die ");
            int inputInt = scanner.nextInt();
            scanner.nextLine();




        }
    }

    public static Money calcCosts(GameDevStudio studio) {
        Money sum = new Money(new BigDecimal(0));

        for (int i = 0; i < studio.getOffices().size(); i++) {
            sum = sum.add(studio.getOffices().get(i).getLease());
            for (int j = 0; j < studio.getOffices().get(i).getDevelopers().size(); j++) {
                sum = sum.add(studio.getOffices().get(i).getDevelopers().get(j).getSalary());
            }
        }
        return sum;
    }

    public static void projects(GameDevStudio studio) {

        for(int i = 0; i < studio.getProjectBoard().get().size(); i++){
            System.out.println(i+". " + studio.getProjectBoard().get().get(i).getName().getName());
        }


        System.out.println("please select one of the above: ");
        int input = scanner.nextInt();
        scanner.nextLine();
        System.out.println("name: " + studio.getProjectBoard().get().get(input).getName().getName());
        System.out.println("customer: " + studio.getProjectBoard().get().get(input).getCustomer().getName());
        System.out.println("deadline: in " + studio.getProjectBoard().get().get(input).getDeadline().getNumber() + " days");
        System.out.println("reward: " + studio.getProjectBoard().get().get(input).getReward());
        Developer dev = timeCalc(studio, input);
        if(dev != null){
            System.out.println("best suited developer for this project: " + dev.getName().getName());
        }else{
            System.out.println("there are no developers available");
        }

    }

    public static Developer timeCalc(GameDevStudio studio, int input) {
        Developer help = null;

            for(int k = 0; k < studio.getOffices().size(); k++){
                for(int l = 0; l < studio.getOffices().get(k).getDevelopers().size(); l++){



                    //if (studio.getOffices().get(k).getDevelopers().get(l).getWorkingOn() == null && studio.getOffices().get(k).getDevelopers().get(l).getSkills().equals(studio.getProjectBoard().get().get(input).getEffort()))
                    {
                        //Test der verfügbaren Developer
                        System.out.println("");
                        System.out.println("");
                        System.out.println(studio.getOffices().get(k).getDevelopers().get(l).getWorkingOn());
                        System.out.println(studio.getOffices().get(k).getDevelopers().get(l).getSkills());
                        System.out.println(studio.getProjectBoard().get().get(input).getEffort());
                        System.out.println("");
                        System.out.println("");
                        help = studio.getOffices().get(k).getDevelopers().get(l);
                    }

                }

            }


        return help;
    }

}
