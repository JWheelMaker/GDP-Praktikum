package Pruefung;

import gmbh.kdb.hsw.gdp.domain.*;

import java.math.BigDecimal;

public class BossApplication extends Application {
    

    /**
     * The BossApplication class extends the ordinary Application to create a "Boss Application".
     * @param developer
     * @param hireBonus
     * @param hireAgentFee
     */
    public BossApplication(){
        super(new Developer(new DeveloperName("Mevin Koenk"), new Money(new BigDecimal(10)), Happiness.create(),null, new Day(1), new Skillset(10, 10, 10, 10)), new Money(new BigDecimal(10)), new Money(new BigDecimal(10)));


    }
    
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
