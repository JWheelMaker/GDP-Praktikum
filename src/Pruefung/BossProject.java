package Pruefung;

import gmbh.kdb.hsw.gdp.domain.*;

import java.math.BigDecimal;

public class BossProject extends Project {

    public BossProject() {
        super(new ProjectName("Boss Project (only for pros)"), new Skillset(11, 11, 11, 11), new Money(new BigDecimal(1000000000)), new CompanyName("Your Nightmare Ltd."), new Day(1));
    }
}
