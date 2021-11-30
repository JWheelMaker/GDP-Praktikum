package Pruefung;

import java.util.List;

public class EventLogInformation {
    private final List<String> eventLog;


    public EventLogInformation(List<String> eventLog) {
        this.eventLog = eventLog;
    }

    public void print() {
        System.out.println("---------------------------------------");
        System.out.println("Event logs of the current game:");
        for (String st : eventLog) {
            System.out.println(st);
        }
        System.out.println("---------------------------------------");
    }
}