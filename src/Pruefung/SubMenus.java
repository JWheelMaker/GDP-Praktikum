package Pruefung;

import gmbh.kdb.hsw.gdp.domain.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubMenus {
    static boolean testForBossAppl = false;
    static boolean testForBossPro = false;
    static int actionCounter = 0; //counts the quantity of executed actions
    private static final Scanner scanner = new Scanner(System.in);

    public static void evaluation(GameDevStudio studio, List<String> eventLog) {

        DeveloperInformation devInfo = new DeveloperInformation(studio);
        OfficeInformation officeInfo = new OfficeInformation(studio);
        EventLogInformation eventLogInfo = new EventLogInformation(eventLog);

        while (true) {
            System.out.println();
            System.out.println("choose one of the following: ");
            System.out.println("1 to show Event Log ");
            System.out.println("2 to show office information");
            System.out.println("3 to show developer information");
            System.out.println("4 to exit evaluation menu");

            //getting user input
            Scanner sc = new Scanner(System.in);
            var input = sc.nextInt();


            switch (input) {
                case 1 -> //Event log
                        eventLogInfo.print();
                case 2 -> //Office overview
                        officeInfo.print();
                case 3 -> //Developer
                        devInfo.print();
                case 4 -> {
                    return;
                }
                default -> {
                }
            }
        }
    }

    public static void applicants(GameDevStudio studio) {
        System.out.println("actions left: " + (3 - actionCounter));
        if(!testForBossAppl){
            BossApplication bossApplicant = new BossApplication();
            testForBossAppl = true;
            ArrayList<Application> anotherHelpList = new ArrayList<>();

                anotherHelpList.addAll(studio.getApplications());
                anotherHelpList.add(bossApplicant);
                studio.setApplications(anotherHelpList);


        }
        while (true) {
            System.out.println("---------------------------------------");
            if (!studio.getApplications().isEmpty()) {

                Money costs = calcCosts(studio);

                for (var i = 0; i < studio.getApplications().size(); i++) {
                    System.out.println(i + 1 + ".  " + studio.getApplications().get(i).getDeveloper().getName().getName());

                    //subtracting the costs of employing from capital
                    Money remaining = studio.getCash();
                    remaining = remaining.subtract(studio.getApplications().get(i).getHireBonus());
                    remaining = remaining.subtract(studio.getApplications().get(i).getHireAgentFee());

                    System.out.println("Remaining capital with this applicant: " + remaining);


                    Money newCosts = costs.add(studio.getApplications().get(i).getDeveloper().getSalary());

                    System.out.println("Remaining game rounds, when hiring this applicant: " + remainingDays(studio, newCosts));

                }
                System.out.println("---------------------------------------");

                System.out.println("Would you like to hire one of the applicants above? ((y)es/no)");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("yes") || input.equals("y")) {

                    // new applicant will always be employed at the first office
                    System.out.println("Please enter the number of the applicant you would like to hire.");
                    int applNum = scanner.nextInt() - 1;
                    scanner.nextLine();

                    try {
                        var a = studio.getApplications().get(applNum);
                        studio.acceptApplication(a, studio.getOffices().get(0));
                        System.out.println(studio.getApplications().get(applNum).getDeveloper().getName().getName() + " was hired successfully");
                        actionCounter++; //incrementing counter by one, because an action was made
                        System.out.println("you have: " + (3 - actionCounter) + " actions left");
                        studio.setApplications(studio.getApplications().stream().filter(application -> application != a).toList());
                    } catch (Exception e) {
                        System.out.println("Please enter a valid applicant number");
                        throw e;
                    }
                } else {
                    break;
                }
            } else {
                System.out.println("no open applications.");
                System.out.println("---------------------------------------");
                break;
            }
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

    public static int remainingDays(GameDevStudio studio, Money costs) {
        var remainingRounds = 0;
        var remaining = studio.getCash();
        while (remaining.isGreaterThan(costs)) {
            remaining = remaining.subtract(costs);
            remainingRounds++;
        }
        return remainingRounds;
    }

    /**
     * This methode creates the Boss Project and prints out the project menu.
     * It then takes the user input to accept projects and assign the best dev by using the bestDev-methode
     * @param studio
     */
    public static void projects(GameDevStudio studio) {
        System.out.println("actions left: " + (3 - actionCounter));

        if(!testForBossPro){
            BossProject bossProject = new BossProject();
            ArrayList<Project> helpList = new ArrayList<>();
            helpList.addAll(studio.getProjectBoard().get());
            helpList.add(bossProject);
            studio.setProjectBoard(new ProjectBoard(helpList));
            testForBossPro = true;
        }


        System.out.println("---------------------------------------");
        if (!studio.getProjectBoard().get().isEmpty()) {
            System.out.println("0. Return to previous menu");
            for (int i = 0; i < studio.getProjectBoard().get().size(); i++) {
                System.out.println(i + 1 + ". " + studio.getProjectBoard().get().get(i).getName().getName());
            }
            System.out.println("---------------------------------------");


            System.out.println("please select one of the projects above: ");
            int projNum = scanner.nextInt() - 1;
            if (projNum == -1) {
                return;
            }
            scanner.nextLine();
            Project currentProject = studio.getProjectBoard().get().get(projNum);


            System.out.println("name: " + currentProject.getName().getName());
            System.out.println("customer: " + currentProject.getCustomer().getName());
            System.out.println("deadline: in " + currentProject.getDeadline().getNumber() + " days");
            System.out.println("reward: " + currentProject.getReward());
            System.out.println("running costs: " + calcCosts(studio));
            System.out.println("remaining game rounds: " + remainingDays(studio, calcCosts(studio)));
            Developer dev = getBestDev(studio, projNum);
            if (dev != null) {
                System.out.println("---------------------------------------");
                System.out.println("best suited developer for this project: " + dev.getName().getName());
                System.out.println("should " + dev.getName().getName() + " be commissioned for this project? ((y)es/no)");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("yes") || input.equals("y")) {


                    dev.setWorkingOn(studio.getProjectBoard().get().get(projNum));
                    System.out.println("project successfully assigned");
                    actionCounter++;
                    System.out.println("you have" + (3 - actionCounter) + " actions left");
                    studio.setProjectBoard(new ProjectBoard(studio.getProjectBoard().get().stream().filter(project -> project != currentProject).toList()));

                    System.out.println("---------------------------------------");
                }
            } else {
                System.out.println("there are no developers available");
            }
        } else {
            System.out.println("no projects available");
            System.out.println("---------------------------------------");
        }
    }

    /**
     * This methode detects the best dev for a certain project.
     *
     * @param studio
     * @param projNum
     * @return
     */
    public static Developer getBestDev(GameDevStudio studio, int projNum) {

        Developer best = null;
        int help = 100; //help var for bubble sort
        var days = 0; //days a specific dev needs to fulfill a task
        int minDays = 100; //every time a better (faster) is found this is replaced.

        Skillset effort = studio.getProjectBoard().get().get(projNum).getEffort();

        for (int k = 0; k < studio.getOffices().size(); k++) {
            for (int l = 0; l < studio.getOffices().get(k).getDevelopers().size(); l++) {

                Developer currentDev = studio.getOffices().get(k).getDevelopers().get(l);
                Skillset devSkills = studio.getOffices().get(k).getDevelopers().get(l).getSkills();

                //only takes a dev into consideration if he's working on no other project at the time.
                if (currentDev.getWorkingOn() == null) {

                    if (effort.getCoding() != 0) {
                        if (devSkills.getCoding() != 0) {
                            if (effort.getCoding() % devSkills.getCoding() == 0) {
                                days = effort.getCoding() / devSkills.getCoding();
                            } else {
                                days = effort.getCoding() / devSkills.getCoding() + 1;
                            }
                            if (days < minDays)
                                minDays = days; //if the current dev is faster the variable min days will be overwritten
                        } else {
                            //effort for the task != 0 but dev's skill = 0  --> dev cannot solve the task
                            continue;
                        }
                    }

                    if (effort.getDesign() != 0) {
                        if (devSkills.getDesign() != 0) {
                            if (effort.getDesign() % devSkills.getDesign() == 0) {
                                days = effort.getDesign() / devSkills.getDesign();
                            } else {
                                days = effort.getDesign() / devSkills.getDesign() + 1;
                            }
                            if (days < minDays) minDays = days;
                        } else {
                            //effort for the task != 0 but dev's skill = 0  --> dev cannot solve the task
                            continue;
                        }
                    }

                    if (effort.getResearch() != 0) {
                        if (devSkills.getResearch() != 0) {
                            if (effort.getResearch() % devSkills.getResearch() == 0) {
                                days = effort.getResearch() / devSkills.getResearch();
                            } else {
                                days = effort.getResearch() / devSkills.getResearch() + 1;
                            }
                            if (days < minDays) minDays = days;
                        } else {
                            //effort for the task != 0 but dev's skill = 0  --> dev cannot solve the task
                            continue;
                        }
                    }

                    if (effort.getTesting() != 0) {
                        if (devSkills.getTesting() != 0) {
                            if (effort.getTesting() % devSkills.getTesting() == 0) {
                                days = effort.getTesting() / devSkills.getTesting();
                            } else {
                                days = effort.getTesting() / devSkills.getTesting() + 1;
                            }
                            if (days < minDays) minDays = days;
                        } else {
                            //effort for the task != 0 but dev's skill = 0  --> dev cannot solve the task
                            continue;
                        }
                    }

                    //Bubble sorting for the best dev
                    //If multiple devs have the same "score" the first one will be chosen
                    if (minDays < help) {
                        help = minDays;
                        best = currentDev;
                    }
                }
            }

        }
        return best;
    }


}
