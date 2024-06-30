package org.lessons.java.gestore.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert the year of the event:");
        int EventYear = scanner.nextInt();
        System.out.println("Insert the month of the event:");
        int EventMonth = scanner.nextInt();
        System.out.println("Insert the day of the event:");
        int Eventday = scanner.nextInt();
        LocalDate EventDate = LocalDate.of(EventYear, EventMonth, Eventday);
        System.out.println("Insert the maximum number of people for the event:");
        int EventTotalPax = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Insert the title of the event:");
        String eventTitle = scanner.nextLine();

        Event beerFest = new Event(eventTitle, EventTotalPax, EventDate);

        System.out.println("How many booking do you want to do?");
        int booking = scanner.nextInt();

        if (booking > EventTotalPax || !beerFest.checkDate(EventDate) || beerFest.checkBookedPax()) {
            System.out.println(
                    "You cannot make this number of reservations as it exceeds the maximum number of people for the event or it's not possible to book for this date");
        } else {
            for (int i = 0; i < booking; i++) {
                beerFest.book(EventDate);
            }
            System.out.println("You have booked for " + booking + " person");
            System.out.println("There are still " + beerFest.getVacancies() + " seat available");
        }

        System.out.println("How many cancellation do you want to do?");
        int cancellation = scanner.nextInt();

        if (cancellation > beerFest.bookedPax() || !beerFest.checkDate(EventDate)) {
            System.out.println("You cannot make this number of cancellation as it exceeds the number of people booked for the event or it's not possible to cancel for this date");
        } else {
            for (int i = 0; i < cancellation; i++) {
                beerFest.cancelBooking(EventDate, booking);
            }
            System.out.println("You have cancelled for " + cancellation + " person");
            System.out.println("There are still " + beerFest.getVacancies() + " seat available");
        }

        System.out.println("Insert the hour of the event:");
        int hour = scanner.nextInt();
        System.out.println("Insert the minute of the event:");
        int minute = scanner.nextInt();
        LocalTime time = LocalTime.of(hour, minute);
        System.out.println("Insert the day of the event:");
        int ConcertDay = scanner.nextInt();
        System.out.println("Insert the month of the event:");
        int ConcertMonth = scanner.nextInt();
        System.out.println("Insert the year of the event:");
        int ConcertYear = scanner.nextInt();
        LocalDate ConcertDate = LocalDate.of(ConcertYear, ConcertMonth, ConcertDay);
        System.out.println("Insert the maximum number of people for the event:");
        int ConcertTotalPax = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Insert the title of the concert:");
        String ConcertTitle = scanner.nextLine();
        System.out.println("Insert the price of the event:");
        double price = scanner.nextDouble();
        Concert concert = new Concert(ConcertTitle, ConcertTotalPax, ConcertDate, time, price);
        System.out.println(concert);

        scanner.close();
    }
}