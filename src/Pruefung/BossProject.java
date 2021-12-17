package Pruefung;

import gmbh.kdb.hsw.gdp.domain.*;

import java.math.BigDecimal;

/**
 * Extends Project and creates a BossProject witch has the highest possible effort Skillset (but an insane reward)
 */
public class BossProject extends Project {

    /**
     * Creating an instance of BossProject will build a new Object BossProject
     */
    public BossProject() {
        super(new ProjectName("Boss Project (only for pros)"), new Skillset(10, 10, 10, 10), new Money(new BigDecimal(1000000000)), new CompanyName("Your Nightmare Ltd."), new Day(1));

    }
}
