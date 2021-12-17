package Pruefung;

import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

/**
 * collects and prints out all information about the offices
 */
public class OfficeInformation {
    private final GameDevStudio office;

    /**
     * This method outputs all Office information to the console.
     * The name, the number of employees and the rent are displayed.
     *
     * @param office passed GameDevStudio for access to game data
     */
    public OfficeInformation(GameDevStudio office) {
        this.office = office;
    }

    /**
     * This methode collects and prints out all Information regarding the offices to the console.
     */
    public void print() {
        for (int i = 0; i < this.office.getOffices().size(); i++) {
            System.out.println("---------------------------------------");
            System.out.println("name: " + this.office.getOffices().get(i).getName().getName());
            System.out.println("number of slaves: " + this.office.getOffices().get(i).getDevelopers().size());
            System.out.println("office lease: " + this.office.getOffices().get(i).getLease());
            System.out.println("---------------------------------------");
        }
    }
}
