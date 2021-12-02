package Pruefung;

import gmbh.kdb.hsw.gdp.domain.*;

import java.math.BigDecimal;

public class BossProject extends Project {

    public BossProject() {
        super(new ProjectName("Boss Project (only for pros)"), new Skillset(10, 10, 10, 10), new Money(new BigDecimal(1000000000)), new CompanyName("Your Nightmare Ltd."), new Day(1));

        /**
        //initializing boss dev Mevin Koenck
        DeveloperName name = new DeveloperName("Mevin Koenck");
        Money salary = new Money(new BigDecimal(10));
        Happiness happiness = new Happiness(10.0);
        Project workingOn = new BossProject();
        Day dayOfHire = new Day(1);
        Skillset skills = new Skillset(11, 11, 11, 11);

        Developer bossDev = new Developer(name, salary, happiness, workingOn, dayOfHire, skills);
         **/
    }
}
