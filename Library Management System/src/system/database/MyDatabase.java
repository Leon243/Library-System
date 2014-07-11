package system.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class MyDatabase.
 */
public class MyDatabase {
	
	/** The driver. */
	private String driver = "com.mysql.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://localhost/";
	
	/** The user. */
	private String user = "root";
	
	/** The pw. */
	private String pw = "";
	
	/** The is debug mode. */
	private boolean isDebugMode = false;
	
	/** The connection. */
	private Connection connection;
	
	/** The is open. */
	private boolean isOpen;

	/**
	 * 4 argument constructor taking all the details needed to connect to the
	 * database including the driver.
	 *
	 * @param driver the driver
	 * @param url the url
	 * @param user the user
	 * @param pw the pw
	 */
	public MyDatabase(String driver, String url, String user, String pw) {
		
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pw = pw;
		connection = null;
		isOpen = false;
	}

	/**
	 * 3 argument constructor taking the details to connect to the database.
	 *
	 * @param databaseName the database name
	 * @param user the user
	 * @param pw the pw
	 */
	public MyDatabase(String databaseName, String user, String pw) {
		this.url = url + databaseName;
		this.user = user;
		this.pw = pw;
		connection = null;
		isOpen = false;
	}

	/**
	 * 1 argument constructor taking only the database name as argument and
	 * using default username and password to connect to the database.
	 *
	 * @param databaseName the database name
	 * @throws SQLException the sQL exception
	 */
	public MyDatabase(String databaseName) throws SQLException {
		connection = null;
		isOpen = false;
	}

	/**
	 * Opens the database and returns the state.
	 *
	 * @return true if database opens successfully false if database fails to
	 * open
	 */
	public boolean openDatabase() {
		if (isOpen) {
			return true;
		}
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, pw);
			isOpen = true;
			return true;
		} catch (Exception e) {
			if (isDebugMode) {
				System.out.println("MyDatabase: DEBUG");
				System.out.flush();
				e.printStackTrace();
			}
			return false;
		}
	}

	/**
	 * Closes the database and returns the state.
	 *
	 * @return true if database successfully closes<br/>
	 * false if database did not close properly
	 */
	public boolean closeDatabase() {
		try {
			isOpen = false;
			if (connection != null)
				connection.close();
			return true;
		} catch (Exception e) {
			if (isDebugMode) {
				System.out.println("MyDatabase: DEBUG");
				System.out.flush();
				e.printStackTrace();
			}
			return false;
		}
	}

	/**
	 * Takes a String with a SQL statement and sends a query to the database and
	 * returns the result in the form of an ArrayList of Object arrays.
	 *
	 * @param sql - a String containing an SQL query statement
	 * @return ArrayList of Object[] containing the result
	 */
	public ArrayList<Object[]> query(String sql) {
		boolean justOpened = false;
		if (!isOpen) {
			isOpen = openDatabase();
			justOpened = true;
		}
		ArrayList<Object[]> list = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			list = new ArrayList<Object[]>();
			while (resultSet.next()) {
				Object[] elements = new Object[resultSet.getMetaData()
						.getColumnCount()];
				for (int i = 0; i < elements.length; i++) {
					elements[i] = resultSet.getObject(i + 1);
				}
				list.add(elements);
			}
			if (resultSet != null)
				resultSet.close();
			if (statement != null)
				statement.close();
		} catch (Exception e) {
			if (isDebugMode) {
				System.out.println("MyDatabase: DEBUG");
				System.out.flush();
				e.printStackTrace();
			}
		}
		if (justOpened) {
			closeDatabase();
		}
		return list;
	}

	/**
	 * Takes a String with an update SQL statement and a sends it to the
	 * database and returns the number of updates in the form of an integer
	 * Note: not all statements return an update value!.
	 *
	 * @param sql a String containing an SQL update statement
	 * @return integer with number of updates made
	 */
	public int update(String sql) {
		boolean justOpened = false;
		if (!isOpen) {
			isOpen = openDatabase();
			justOpened = true;
		}
		Statement statement = null;
		int result = 0;
		try {
			statement = connection.createStatement();
			result = statement.executeUpdate(sql);
		} catch (Exception e) {
			if (isDebugMode) {
				System.out.println("MyDatabase: DEBUG");
				System.out.flush();
				e.printStackTrace();
			}
		}
		if (justOpened) {
			closeDatabase();
		}
		return result;
	}

	/**
	 * Takes an ArrayList of String with update SQL statements and a sends it to
	 * the database, then returns the SQL statements sent to the database in the
	 * form of a String.
	 *
	 * @param sqlList an ArrayList of String containing update SQL statements
	 * @return String of the SQL statements sent
	 */
	public int[] updateAll(ArrayList<String> sqlList) {
		if (sqlList == null)
			return null;
		int[] results = new int[sqlList.size()];
		for (int i = 0; i < sqlList.size(); i++) {
			results[i] = update(sqlList.get(i));
		}
		return results;
	}

	/**
	 * Takes a file containing sql statements, sorts it into single lines of sql
	 * commands, puts it into an ArrayList of Strings and sends it to the
	 * updateAll(ArrayList<Strings> method.
	 *
	 * @param fileName - a String containing the filename and/or path to the file
	 * (e.g. c:\path\file.sql)
	 * @return String of the sql statements sent
	 */
	public int[] updateAll(String fileName) {
		ArrayList<String> sqlList = readFile(fileName);
		return updateAll(sqlList);
	}

	/**
	 * Sets the debugMode. Debug mode lets the class return different error
	 * messages that may appear and helps troubleshooting
	 * 
	 * @param isDebugMode
	 *            boolean switching the debug mode on or off
	 */
	public void setDebugMode(boolean isDebugMode) {
		this.isDebugMode = isDebugMode;
	}

	/**
	 * Opend a specific file, reads the content line by line, stores it in an
	 * ArrayList of Strings and then returns the list.
	 *
	 * @param filename the filename
	 * @return ArrayList of String with the content of the file
	 */
	private ArrayList<String> readFile(String filename) {
		Scanner input = null;
		String path = new File(filename).getAbsolutePath();
		try {
			FileInputStream fileIn = new FileInputStream(filename);
			input = new Scanner(fileIn);
		} catch (FileNotFoundException e) {
			if (isDebugMode) {
				System.out.println("MyDatabase: DEBUG");
				System.out.println("Cannot open file: \"" + path + "\" ");
				System.out.flush();
				e.printStackTrace();
			}
			return null;
		}

		ArrayList<String> list = new ArrayList<String>();
		while (input.hasNext()) {
			list.add(input.nextLine());
		}
		input.close();
		return list;
	}

	/**
	 * Creates the databse.
	 *
	 * @param databaseName the database name
	 * @throws SQLException the sQL exception
	 */
	protected void createDatabse(String databaseName) throws SQLException {
		ArrayList<String> sql = readFile(databaseName + ".sql");
		if (sql != null) {
			for (int i = 0; i < sql.size(); i++) {
				PreparedStatement statement = connection.prepareStatement(sql
						.get(i));
				int nr = statement.executeUpdate();
				System.out.println("UPDATED " + nr + ": " + sql.get(i));
			}
		}
	}

}