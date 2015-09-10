package Klase;

import java.sql.*;

public class ReminderDAO { 
	
	// connection with database used in methods
	private static Connection connection = getConnection();
	

	/** Scan reminders 
	 * @throws SQLException */
	public static void scanReminders() throws SQLException{
		
		// Statement used to get reminders from database
		Statement statement = connection.createStatement();
		
		// return reminders from database and place them in ResultSet
		ResultSet result = statement.executeQuery("SELECT * FROM reminders");
		
		// add reminders to reminder arrayList
		while(result.next()){
			Reminder r = new Reminder(result.getString(1), result.getString(2));
			Kalendar.reminders.add(r);
		}
		
	}

	/** Add a reminder to database
	 * @throws SQLException */
	public static void addReminder(Reminder r) throws SQLException{
		
		// PreparedStatement used to update database
		PreparedStatement ps = connection.prepareStatement("insert into reminders values (?,?)");
		
		ps.setString(1, r.getId());
		ps.setString(2, r.getText());
		ps.executeUpdate();
	}

	/** Returns a connection with database calendat */
	public static Connection getConnection() {

		try {
			// load Drivers
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found.");
		}

		// initialize connection
		Connection connection = null;
		
		try {
			// connect to database
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/calendar", "scott", "tiger");
		} catch (SQLException e) {
			System.out.println("Database not found.");
		}
		return connection;
	}
	
	

}
