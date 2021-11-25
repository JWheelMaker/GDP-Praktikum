package Pruefung;

import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

public class OfficeInformation {
    private GameDevStudio office;

    public OfficeInformation(GameDevStudio office){
        this.office = office;
    }

    public void print()
    {
        for (int i = 0; i < this.office.getOffices().size(); i++) {
            System.out.println("---------------------------------------");
            System.out.println("name: " + this.office.getOffices().get(i).getName().getName());
            System.out.println("number of slaves: " + this.office.getOffices().get(i).getDevelopers().size());
            System.out.println("office lease: " + this.office.getOffices().get(i).getLease());
            System.out.println("---------------------------------------");
        }
    }
}
