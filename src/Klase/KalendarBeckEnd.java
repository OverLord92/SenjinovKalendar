package Klase;

public class KalendarBeckEnd {

	// string array with month names
	public static final String[] MONTH_NAMES = { "Jan", "Feb", "Mar", "April",
			"Maj", "Jun", "Jul", "Aug", "Sep", "Okto", "Nov", "Dec" };

	// string array with number of days in month
	public static final int[] DAYS_IN_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31,
			30, 31, 30, 31 };

	// string array with days names
	public static final String[] NAME_OF_DAYS = { "Mon", "Tue", "Wen", "Thu",
			"Fri", "Sat", "Sun" };

	/** Helper method. Calls printHeader and printBody */
	public static void printCalendar(int year, int month) {

		printHeader(year, month);
		printBody(year, month);

	}

	/** Prints the calendar header */
	public static void printHeader(int year, int month) {

		System.out.println("\n                   " + MONTH_NAMES[month] + " "
				+ year + "                 ");
		System.out.println("  _____________________"
				+ "______________________\n");

		System.out.print("    ");

		// prints the names of the days in a week
		for (int i = 0; i < 7; i++) {
			System.out.printf("%3s   ", NAME_OF_DAYS[i]);
		}
	}

	/** Prints Calendar body */
	public static void printBody(int year, int month) {

		// counts needed empty places
		int counter = getStartDays(year, month) - 1;

		System.out.println();
		System.out.print("    ");

		for (int i = 0; i <= counter; i++) {
			System.out.print("      ");
		}

		// number of days in month
		int daysInMonth = DAYS_IN_MONTH[month - 1];

		// if months is 2 and leap year increase days by one
		if (isLeapYear(year) && month == 2) {
			daysInMonth++;

		}

		// print dates
		for (int i = 1; i <= daysInMonth; i++) {

			counter++;

			if (counter % 7 == 0)
				System.out.print("\n    ");

			System.out.printf("%-6d", i);

		}

		System.out.println();

	}

	/** Calculates the first day of month */
	public static int getStartDays(int year, int month) {

		// as a reference to calculate the start day of the month we use the
		// 1.1.1973 which was a monday

		int days = 0;

		// count passed days in passed years until the desired year
		for (int i = 1973; i < year; i++) {

			if (isLeapYear(i)) {
				days += 366;
			} else {
				days += 365;
			}

		}

		// count passed days in passed month of the desired year
		for (int i = 0; i < month; i++) {
			days += DAYS_IN_MONTH[i];
		}

		if (month > 1 && isLeapYear(year))
			days++;

		// the method returns 0 if the start day is monday, 1 if start day is
		// tuesday ans so on                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		return days % 7;

	}

	/** Check if year is leap year */
	public static boolean isLeapYear(int year) {

		return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
	}

}
