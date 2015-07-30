package Klase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Reminder {

	// file u koji smjestamo remindere
	public static File file = new File("reminders.txt");
	
	public static ArrayList<String> reminders = new ArrayList<>();

	
	/** Metoda koja skenira remindere s fajla */
	public static void scanReminders() {

		Scanner input;
		try {
			input = new Scanner(file);
			while (input.hasNextLine()) {
				reminders.add(input.nextLine());
			}

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/** Metoda koja dodaje novi reminder */
	public static void addReminder(){
		
		Scanner input = new Scanner(System.in);
		System.out.print("  Enter the reminder you want to add: ");
		reminders.add(input.nextLine());
		
		input.close();
	}
	
	/** Metoda koja printa remindere na fajl */
	public static void printReminders(){
		
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileOutputStream(file));
			
			for(String str: reminders)
				pw.println(str);
			
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
