package com.Ilmars;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    static String[] guests = new String[10];
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        do {

            displayGuests();
            displayMenu();
            int option = getInput();

            if (option == 1) {
                addGuest();

            } else if (option == 2) {
                addGuestInParticularPosition();

            } else if (option == 3) {
                removeGuest();

            } else if (option == 4) {
                renameGuest();

            } else if (option == 5) {
                insertTestNames();

            } else if (option == 6) {
                System.out.println("\nExiting...");
                break;
            }

            System.out.println();
        } while (true);

        System.out.println("The program is finished");

    }

    static void displayGuests() {
        System.out.println("_______________________\n- Guests -\n");
        boolean isEmpty = true;
        for (int i = 0; i < guests.length; i++) {

            if (guests[i] != null) {
                System.out.println((i + 1) + ". " + guests[i]);
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("There are no guests!");
        }

    }

    static void displayMenu() {
        System.out.println("\n_______________________\n- Menu -\n");
        System.out.println("1 - Add Guest");
        System.out.println("2 - Add Guest in particular position");
        System.out.println("3 - Remove Guest (by Number)");
        System.out.println("4 - Rename Guest (by Number)");
        System.out.println("5 - Insert test names");
        System.out.println("6 - Exit");
    }

    static int getInput() {
        System.out.print("Option: ");
        return scan.nextInt();
    }

    static void addGuest() {
        System.out.print("Name: ");
        scan.nextLine();
        String name = scan.nextLine();

        for (int i = 0; i < guests.length; i++) {
            if (guests[i] == null) {
                guests[i] = name;
                break;
            }
        }
    }

    static void addGuestInParticularPosition() {
        System.out.print("Position to add: ");
        int num = scan.nextInt();

        if (num >= 1 && num <= 10) {
            System.out.print("Guests name: ");
            scan.nextLine();
            String newName = scan.nextLine();

            IntStream.iterate(guests.length - 1, i -> i > num - 1, i -> i - 1)
                    .forEach(i -> guests[i] = guests[i - 1]);
            guests[num - 1] = newName;
        } else {
            System.out.println("\nThis position is not accessible");
        }
    }

    static void removeGuest() {
        System.out.print("Number to remove: ");
        int num = scan.nextInt();

            if (num <= 0 || num > 10 || guests[num-1] == null) {
                System.out.println("\nThere is no guest with such number");
            } else {
                guests[num-1] = null;
            }

        String[] temp = new String[guests.length];
        int ti = 0;
        for (String guest : guests) {
            if (guest != null) {
                temp[ti] = guest;
                ti++;
            }
        }
        guests = temp;
    }

    static void renameGuest() {
        System.out.print("Number to rename: ");
        int num = scan.nextInt();

        if (num <= 0 || num > 10 || guests[num-1] == null) {
            System.out.println("\nThere is no guest with such number");
        } else {
            System.out.print("Enter new name: ");
            String newName = scan.next();
            guests[num-1] = newName;
        }
    }

    static void insertTestNames() {
        guests[0] = "John";
        guests[1] = "Marry";
        guests[2] = "Michael";
        guests[3] = "Jenifer";
        guests[4] = "Oscar";
        guests[5] = "Herbert";
        guests[6] = "Judith";
    }
}
