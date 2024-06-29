package org.lessons.java.gestore.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert the year of the event:");
        int year = scanner.nextInt();
        System.out.println("Insert the month of the event:");
        int month = scanner.nextInt();
        System.out.println("Insert the day of the event:");
        int day = scanner.nextInt();
        LocalDate date = LocalDate.of(year, month, day);
        System.out.println("Insert the maximum number of people for the event:");
        int totalPax = scanner.nextInt();

        Event beerFest = new Event("Beer Festival", totalPax, date);

        System.out.println("How many booking do you want to do?");
        int booking = scanner.nextInt();

        if (booking > totalPax || !beerFest.checkDate(date) || beerFest.checkBookedPax()) {
            System.out.println(
                    "You cannot make this number of reservations as it exceeds the maximum number of people for the event or it's not possible to book for this date");
        } else {
            for (int i = 0; i < booking; i++) {
                beerFest.book(date);
            }
            System.out.println("You have booked for " + booking + " person");
            System.out.println("There are still " + beerFest.getVacancies() + " seat available");
        }

        System.out.println("How many cancellation do you want to do?");
        int cancellation = scanner.nextInt();

        if (cancellation > beerFest.bookedPax() || !beerFest.checkDate(date)) {
            System.out.println("You cannot make this number of cancellation as it exceeds the number of people booked for the event or it's not possible to cancel for this date");
        } else {
            for (int i = 0; i < cancellation; i++) {
                beerFest.cancelBooking(date, booking);
            }
            System.out.println("You have cancelled for " + cancellation + " person");
            System.out.println("There are still " + beerFest.getVacancies() + " seat available");
        }

        scanner.close();
    }
}