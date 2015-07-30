package Klase;
import java.util.Scanner;

/**
 * Naime, program koji trebamo napisati treba da pita korisnika da unese mjesec
 * i godinu te da mu ispiše, kalendar za taj mjesec i tu godinu. Kada program
 * ispiše dati mjesec korisniku na konzoli, program onda pita korisnika da li
 * želi unijeti neki reminder za određeni dan ili želi vidjeti kalendar za neki
 * drugi mjesec. Ukoliko korisnik želi neki podsjetnik/reminder/note za određeni
 * dan, program treba da sačuva korisnikov unos i da ga prikaže pri sljedećem
 * pokretanju programa.
 */

public class Kalendar {

	// niz za imenima mjeseci
	public static final String[] MONTH_NAMES = { "Jan", "Feb", "Mar", "April",
			"Maj", "Jun", "Jul", "Aug", "Sep", "Okto", "Nov", "Dec" };

	// niz sa brojevima dana u mjesecima
	public static final int[] DAYS_IN_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31,
			30, 31, 30, 31 };

	// niz sa imenima dana
	public static final String[] NAME_OF_DAYS = { "Pon", "Uto", "Sri", "Cet",
			"Pet", "Sub", "Ned" };

	/** Main metoda */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Reminder.scanReminders();
		
		int year, month;

		int choice;
		
		do {

			// printanje korisnickog menija
			System.out
					.println("\n  Press 1 to print a calendar for a prticular month, or");
			System.out.println("  press 2 to add a reminder.");
			System.out.println("  Press 3 to exit.\n");
			
			System.out.print("  Enter your choice: ");

			choice = input.nextInt();
			
			System.out.println();

			if (choice == 1) {

				// korisnik unosi godinu i mjesec za printanje
				System.out.print("  Enter the year: ");
				year = input.nextInt();

				System.out.print("  Enter month: ");
				month = input.nextInt();
				
				// printanje kalendara
				printCal(year, month);

				// printanje remindera
				System.out.println("\n\n  The reminders you entered: \n");
				for (String str : Reminder.reminders) {
					System.out.println("   -   " + str);
				}

			} else if (choice == 2) {
				
				Reminder.addReminder();
			
			}

			Reminder.printReminders();
		} while (choice != 3);

		// poruka koja se printa pti zatvaranju programa
		System.out.println("  You closed the program. Hava a nice day.");

		// petlja za stampanje godisnjeg kalendara
		// for(int i = 1; i <= 12; i++){
		// printCal(year, i);
		// }

		input.close();

	}

	/** Helper metoda koja poziva metode za header i body */
	public static void printCal(int year, int month) {

		printHeader(year, month);

		printBody(year, month);

	}

	/** Metoda koja printa zaglavlje kalendara */
	public static void printHeader(int year, int month) {

		System.out.println("\n                   " + MONTH_NAMES[month - 1] + " "
				+ year + "                 ");
		System.out
				.println("  _____________________" + "______________________\n");

		System.out.print("    ");

		// petlja koja printa imena dana sedmice
		for (int i = 0; i < 7; i++) {
			System.out.printf("%3s   ", NAME_OF_DAYS[i]);
		}
	}

	/** Metoda koja printa tijelo kalendara */
	public static void printBody(int year, int month) {

		// ako je godina prestupna februar ima 28 + 1 dana
//		if (isLeapYear(year))
//			DAYS_IN_MONTH[1]++;

		// brojac za "prazna mjesta"
		int counter = getStartDays(year, month) - 1;

		System.out.println();
		System.out.print("    ");

		for (int i = 0; i <= counter; i++) {
			System.out.print("      ");
		}

		// broj dana u printanom mjesecu
		int daysInMonth = DAYS_IN_MONTH[month - 1];
		
		// povecanje broja dana ako je februar u prestupnoj godini
		if(isLeapYear(year) && month == 2){
			daysInMonth++;
			
		}
		// brojac koji stampa datume
		for (int i = 1; i <= daysInMonth; i++) {
		
			counter++;

			if (counter % 7 == 0)
				System.out.print("\n    ");

			System.out.printf("%-6d", i);

		}

		System.out.println();

	}

	/** Metoda koja vraca pocetni dan mjeseca */
	public static int getStartDays(int year, int month) {

		month--;

		// 1. januar 1970 je bio četvrtak

		int days = 0;

		// petlja koja broji dane do po godinama koje su prosle od 1973
		// do trazene godine
		for (int i = 1973; i < year; i++) {

			if (isLeapYear(i)) {
				days += 366;
			} else {
				days += 365;
			}

		}

		// petlja koj broji dane po mjesecima do trazenog mjeseca
		for (int i = 0; i < month; i++) {
			days += DAYS_IN_MONTH[i];
		}
		
		if (month > 1 && isLeapYear(year))
			days++;
	

		// ako je prvi dan u mjesecu pon metoda vraca 0, utorak 1 itd
		return days % 7;

	}

	/** Metoda koja vraca true ukoliko je je godina prestupna */
	public static boolean isLeapYear(int year) {

		return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
	}

}
