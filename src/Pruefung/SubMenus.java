package Pruefung;

import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

import java.util.List;
import java.util.Scanner;

public class SubMenus
{
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

    public static void action(GameDevStudio studio){
        for(int i = 0; i < studio.getApplications().size(); i++){
        sout

        }

    }
}
