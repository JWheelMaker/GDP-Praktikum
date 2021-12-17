package Pruefung;

import java.util.List;

/**
 * collects and prints out the event log of the game
 */
public class EventLogInformation {
    private final List<String> eventLog;

    /**
     * This class takes the passed List to print out the event log.
     *
     * @param eventLog
     */
    public EventLogInformation(List<String> eventLog) {
        this.eventLog = eventLog;
    }

    /**
     * This methode prints out the event log.
     */
    public void print() {
        System.out.println("---------------------------------------");
        System.out.println("Event logs of the current game:");
        for (String st : eventLog) {
            System.out.println(st);
        }
        System.out.println("---------------------------------------");
    }
}