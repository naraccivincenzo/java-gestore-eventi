package org.lessons.java.gestore.eventi;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Event {
    private String title;
    private int totalPax;
    private int bookedPax;
    private static final ZoneId EUROPE = ZoneId.of("Europe/Rome");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.ITALY);
    private LocalDate date;
    private LocalDate today = LocalDate.now(EUROPE);

    public Event(String title, int totalPax, LocalDate date) {
        this.title = title;
        this.totalPax = totalPax;
        this.bookedPax = 0;
        this.date = date;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDate() {
        return this.date.format(FORMATTER);
    }

    public int getTotalPax() {
        return this.totalPax;
    }

    public int bookedPax() {
        return this.bookedPax;
    }

    public boolean checkBookedPax() {
        return this.bookedPax >= this.totalPax;
    }

    public boolean checkDate(LocalDate date) {
        return date.isAfter(today);
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

    public int getVacancies() {
        return this.totalPax - this.bookedPax;
    }

    @Override
    public String toString() {
        return this.date.toString() + " - " + this.title;
    }


}