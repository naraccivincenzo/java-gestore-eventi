package org.lessons.java.gestore.eventi;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Event {
    private static final ZoneId EUROPE = ZoneId.of("Europe/Rome");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.ITALY);
    private final int TOTAL_PAX;
    private final LocalDate TODAY = LocalDate.now(EUROPE);
    private String title;
    private int bookedPax;
    private LocalDate date;

    public Event(String title, int TOTAL_PAX, LocalDate date) {
        this.title = title;
        this.TOTAL_PAX = TOTAL_PAX;
        this.bookedPax = 0;
        this.date = date;
    }

    //Getters and Setters
    public String getTitle() {
        return this.title;
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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTotalPax() {
        return this.TOTAL_PAX;
    }

    public int getBookedPax() {
        return this.bookedPax;
    }

    public int getVacancies() {
        return this.TOTAL_PAX - this.bookedPax;
    }

    //Methods
    public boolean checkBookedPax() {
        return this.bookedPax >= this.TOTAL_PAX;
    }

    public boolean checkDate(LocalDate date) {
        return date.isAfter(TODAY);
    }

    public void book(LocalDate date) {
        if (checkDate(date) && !checkBookedPax()) {
            this.bookedPax++;
            System.out.println("You have booked");
        } else if (!checkDate(date)) {
            System.out.println("The event is over");
        } else if (checkBookedPax()) {
            System.out.println("The event is fully booked");
        }
    }

    public void cancelBooking(LocalDate date, int bookedPax) {
        if (checkDate(date) && bookedPax > 0) {
            this.bookedPax--;
            System.out.println("You have cancelled your reservation");
        } else if (!checkDate(date)) {
            System.out.println("The event is over");
        } else if (bookedPax <= 0) {
            System.out.println("The event not has people booked");
        }
    }

    @Override
    public String toString() {
        return this.date.toString() + " - " + this.title;
    }


}