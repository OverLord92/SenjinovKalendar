package Klase;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

/**
 * Naime, program koji trebamo napisati treba da pita korisnika da unese mjesec
 * i godinu te da mu ispiše, kalendar za taj mjesec i tu godinu. Kada program
 * ispiše dati mjesec korisniku na konzoli, program onda pita korisnika da li
 * želi unijeti neki reminder za određeni dan ili želi vidjeti kalendar za
 * neki drugi mjesec. Ukoliko korisnik želi neki podsjetnik/reminder/note za
 * određeni dan, program treba da sačuva korisnikov unos i da ga prikaže pri
 * sljedećem pokretanju programa.
 */

public class Kalendar {
	
	// array list with reminders
	public static ArrayList<Reminder> reminders = new ArrayList<>();

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner input = new Scanner(System.in);
		
		// Import reminders from database
		ReminderDAO.scanReminders();
		
		int year, month, choice;

		do {

			printUserMenu();

			// aks user to choose option
			System.out.print("  Enter your choice: ");
			choice = input.nextInt();
			input.nextLine();
			System.out.println();

			// user choose to print calendar
			if (choice == 1) {

				// ask user to enter year of the calendar to be printed
				System.out.print("  Enter the year: ");
				year = input.nextInt();

				// ask user to enter month of the calendar to be printed
				System.out.print("  Enter month: ");
				month = input.nextInt() - 1; // program is 0-based

				KalendarBeckEnd.printCalendar(year, month);

				printReminders();

				// user chose to add another reminder
			} else if (choice == 2) {
				
				addReminder();				
			}

		

		} while (choice != 3);

		// the program ends by printing a message to the user
		System.out.println("  You closed the program. Hava a nice day.");

		input.close();

	}

	/** Print user menu */
	public static void printUserMenu() {
		System.out.println("\nPress 1 to print a calendar,");
		System.out.println("press 2 to add a reminder,");
		System.out.println("Press 3 to exit.\n");
	}

	
	/** Add a reminder to reminder database */
	public static void addReminder() throws SQLException{
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter reminder: ");
		String reminderText = input.nextLine();
		Reminder r = new Reminder("2", reminderText);
		ReminderDAO.addReminder(r);
		reminders.clear();
		ReminderDAO.scanReminders();
	}

	/** Prints entered reminders */
	public static void printReminders() {

		System.out.println("\n\n  The reminders you entered: \n");
		for (Reminder r: reminders) {
			System.out.println(r);
		}

	}

	
	
}
