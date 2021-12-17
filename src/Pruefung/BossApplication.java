package Pruefung;

import gmbh.kdb.hsw.gdp.Game;
import gmbh.kdb.hsw.gdp.domain.*;

import java.math.BigDecimal;

/**
 * Extends Application and creates an Application for no one else than Mevin Koenk
 */
public class BossApplication extends Application {


    /**
     * Creating an instance of BossApplication will build a new Object BossApplication
     */
    public BossApplication() {
        super(new Developer(new DeveloperName("Mevin Koenk"), new Money(new BigDecimal(10)), Happiness.create(), null, Game.get().getDay(), new Skillset(10, 10, 10, 10)), new Money(new BigDecimal(10)), new Money(new BigDecimal(10)));
    }
}
