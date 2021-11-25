package Pruefung;

import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

import java.util.List;

public class EventLogInformation {
    private GameDevStudio log;
    private List<String> eventlog;

    public EventLogInformation(GameDevStudio log, List<String> eventlog) {
        this.log = log;
        this.eventlog = eventlog;
    }

    public void print() {
        System.out.println("Event logs of the current game:");
        for (String st : eventlog) {
            System.out.println(st);
        }
    }
}