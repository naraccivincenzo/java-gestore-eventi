package org.lessons.java.gestore.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event {
    private double price;
    private LocalTime time;
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public Concert(String title, int totalPax, LocalDate date, LocalTime time, double price) {
        super(title, totalPax, date);
        this.time = time;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public String getFormattedPrice() {
        return String.format("%.2f€", this.price);
    }

    public String getTime() {
        return this.time.format(FORMATTER);
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return getDate() + " - " + getTime() + " - " + getTitle() + " - " + getFormattedPrice();
    }
}
