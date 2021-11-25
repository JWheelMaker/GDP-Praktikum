package Pruefung;

import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

public class DeveloperInformation {
    GameDevStudio studio;

    /*
    This method outputs all information about the employees to the console.
    The name, the day of the hiring, the satisfaction level, the salary and
     the current project on which the employee is working are displayed.
     */
    public DeveloperInformation(GameDevStudio studio) {
        this.studio = studio;
    }

    public void print() {
        for (int i = 0; i < studio.getOffices().size(); i++) {
            for (int j = 0; j < studio.getOffices().get(i).getDevelopers().size(); j++) {
                System.out.println("---------------------------------------");
                System.out.println("name: " + studio.getOffices().get(i).getDevelopers().get(j).getName().getName());
                System.out.println("day of hire: " + studio.getOffices().get(i).getDevelopers().get(j).getDayOfHire().getNumber());
                System.out.println("happiness: " + studio.getOffices().get(i).getDevelopers().get(j).getHappiness().get());
                System.out.println("salary: " + studio.getOffices().get(i).getDevelopers().get(j).getSalary());
                if (studio.getOffices().get(i).getDevelopers().get(j).getWorkingOn() != null) {
                    System.out.println("current project: " + studio.getOffices().get(i).getDevelopers().get(j).getWorkingOn().getName());
                }
                System.out.println("coding skills : " + studio.getOffices().get(i).getDevelopers().get(j).getSkills().getCoding());
                System.out.println("design skills : " + studio.getOffices().get(i).getDevelopers().get(j).getSkills().getDesign());
                System.out.println("research skills : " + studio.getOffices().get(i).getDevelopers().get(j).getSkills().getResearch());
                System.out.println("testing skills : " + studio.getOffices().get(i).getDevelopers().get(j).getSkills().getTesting());
                System.out.println("---------------------------------------");
            }
        }
    }
}