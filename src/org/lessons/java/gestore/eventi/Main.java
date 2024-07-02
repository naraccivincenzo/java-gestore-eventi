package org.lessons.java.gestore.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the year of the event:");
        int eventYear = scanner.nextInt();
        System.out.println("Insert the month of the event:");
        int eventMonth = scanner.nextInt();
        System.out.println("Insert the day of the event:");
        int eventDay = scanner.nextInt();
        LocalDate eventDate = LocalDate.of(eventYear, eventMonth, eventDay);
        System.out.println("Insert the maximum number of people for the event:");
        int eventTotalPax = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Insert the title of the event:");
        String eventTitle = scanner.nextLine();

        Event beerFest = new Event(eventTitle, eventTotalPax, eventDate);

        System.out.println("How many booking do you want to do?");
        int booking = scanner.nextInt();

        if (booking > eventTotalPax || !beerFest.checkDate(eventDate) || beerFest.checkBookedPax()) {
            System.out.println(
                    "You cannot make this number of reservations as it exceeds the maximum number of people for the event or it's not possible to book for this date");
        } else {
            for (int i = 0; i < booking; i++) {
                beerFest.book(eventDate);
            }
            System.out.println("You have booked for " + booking + " person");
            System.out.println("There are still " + beerFest.getVacancies() + " seat available");
        }

        System.out.println("How many cancellation do you want to do?");
        int cancellation = scanner.nextInt();

        if (cancellation > beerFest.getBookedPax() || !beerFest.checkDate(eventDate)) {
            System.out.println("You cannot make this number of cancellation as it exceeds the number of people booked for the event or it's not possible to cancel for this date");
        } else {
            for (int i = 0; i < cancellation; i++) {
                beerFest.cancelBooking(eventDate, booking);
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
        int concertDay = scanner.nextInt();
        System.out.println("Insert the month of the event:");
        int concertMonth = scanner.nextInt();
        System.out.println("Insert the year of the event:");
        int concertYear = scanner.nextInt();
        LocalDate concertDate = LocalDate.of(concertYear, concertMonth, concertDay);
        System.out.println("Insert the maximum number of people for the event:");
        int concertTotalPax = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Insert the title of the concert:");
        String concertTitle = scanner.nextLine();
        System.out.println("Insert the price of the event:");
        double price = scanner.nextDouble();
        Concert concert = new Concert(concertTitle, concertTotalPax, concertDate, time, price);
        System.out.println(concert);

        scanner.close();

        PlanEvent planEvent = new PlanEvent("Cinema", LocalDate.of(2022, 1, 1));
        planEvent.addEvent(new Event("Beerfest", 100, LocalDate.of(2023, 1, 1)));
        planEvent.addEvent(new Concert("Concerto", 300, LocalDate.of(2022, 1, 1), LocalTime.of(20, 0), 30));

        planEvent.getEventsByDate(LocalDate.of(2022, 1, 1));
        System.out.println("Total events: " + planEvent.getTotalEvents());
        planEvent.printEvents();
        planEvent.clearEvents();
        System.out.println("Total events: " + planEvent.getTotalEvents());

    }
}