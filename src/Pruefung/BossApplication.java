package Pruefung;

import gmbh.kdb.hsw.gdp.Game;
import gmbh.kdb.hsw.gdp.domain.*;

import java.math.BigDecimal;

public class BossApplication extends Application {


    /**
     * The BossApplication class extends the ordinary Application to create a "Boss Application".
     */
    public BossApplication() {
        super(new Developer(new DeveloperName("Mevin Koenk"), new Money(new BigDecimal(10)), Happiness.create(), null, Game.get().getDay(), new Skillset(10, 10, 10, 10)), new Money(new BigDecimal(10)), new Money(new BigDecimal(10)));
    }
}
