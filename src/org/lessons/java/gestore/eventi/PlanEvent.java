package org.lessons.java.gestore.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;


public class PlanEvent {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.ITALY);
    private LocalDate date;
    private String title;
    private ArrayList<Event> plannedEvent;

    public PlanEvent(String title, LocalDate date) {
        this.title = title;
        this.plannedEvent = new ArrayList<>();
        this.date = date;
    }

    //Getters and Setters
    public void addEvent(Event event) {
        this.plannedEvent.add(event);
    }

    public ArrayList<Event> getEvents() {
        return this.plannedEvent;
    }

    public int getTotalEvents() {
        return this.plannedEvent.size();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormattedDate() {
        return this.date.format(FORMATTER);
    }

    public LocalDate getDate() {
        return this.date;
    }

    //Methods
    public void clearEvents() {
        this.plannedEvent.clear();
    }

    public ArrayList<Event> getEventsByDate(LocalDate date) {
        ArrayList<Event> eventsByDate = new ArrayList<>();
        for (Event events : this.plannedEvent) {
            if (events.getDate().isEqual(this.date)) {
                eventsByDate.add(events);
            }
        }
        return eventsByDate;
    }

    public void printEvents() {
        System.out.println("The events planned for " + getFormattedDate() + " are: ");
        for (Event events : getEventsByDate(date)) {
            System.out.println(events);
        }
    }

}
