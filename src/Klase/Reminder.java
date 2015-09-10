package Klase;

public class Reminder {

	// Data Access Object for the Reminder class
	static ReminderDAO reimnderDAO = new ReminderDAO();

	private int id;
	private String text;
	
	
    /** Returns reminder id */
	public int getId() {
		return id;
	}
	
	/** Returns text of the reminder*/
	public String getText() {
		return text;
	}

	/** Sets a new text to the reminder */
	public void setText(String text) {
		this.text = text;
	}

	/** No arg contructor */
	public Reminder() {
	}

	/** Konstruktor with defined text */
	public Reminder(String text) {
		this.text = text;
	}
	
	/** Konstruktor with defined text */
	public Reminder(String text, int id) {
		this.id = id;
		this.text = text;
	}
	
	
	
	/** Overriden toString method */
	public String toString(){
		return "  " + id + " " + text;
	}

}
