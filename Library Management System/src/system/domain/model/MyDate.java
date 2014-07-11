package system.domain.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

// TODO: Auto-generated Javadoc
/**
 * Edited version of MyDate. Representing date.
 * 
 * @author
 * @version
 */

public class MyDate implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The month. */
	private int month;

	/** The day. */
	private int day;

	/** The year. */
	private int year;

	// CONTRUSCTOR
	/**
	 * Instantiates a new my date.
	 * 
	 * @param d
	 *            the d
	 * @param m
	 *            the m
	 * @param y
	 *            the y
	 */
	public MyDate(int d, int m, int y) {
		set(d, m, y);
	}

	// SET VALUES
	/**
	 * Sets the.
	 * 
	 * @param d
	 *            the d
	 * @param m
	 *            the m
	 * @param y
	 *            the y
	 */
	public void set(int d, int m, int y) {
		day = d;
		month = m;
		year = y;

		if (day < 1)
			day = 1;
		else if (day >= 1 && day <= numberOfDaysInMonth())
			day = d;
		else if (day > numberOfDaysInMonth())
			day = numberOfDaysInMonth();

		if (month < 1)
			month = 1;
		else if (month >= 1 && day <= 12)
			month = m;
		else if (month > 12)
			month = 12;

		if (year < 0)
			year = y * -1;
	}

	/**
	 * Gets the day.
	 * 
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Gets the month.
	 * 
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Gets the year.
	 * 
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	// BASIC STRING
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String str = "";

		if (day < 10) {
			str += "0";
		}
		str += day + "/";

		if (month < 10) {
			str += "0";
		}
		str += month + "/";
		str += year;
		return str;
	}

	// Returning the number of days in the given month
	/**
	 * Number of days in month.
	 * 
	 * @return the int
	 */
	public int numberOfDaysInMonth() {

		switch (month) {

		case 2:
			if (isLeapYear() == true)
				return 29;
			else
				return 28;
		case 4:
			return 30;
		case 6:
			return 30;
		case 9:
			return 30;
		case 11:
			return 30;
		default:
			return 31;

		}

	}

	// CHECK IF ITS A LEAP YEAR
	/**
	 * Checks if is leap year.
	 * 
	 * @return true, if is leap year
	 */
	public boolean isLeapYear() {
		if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)))
			return true;
		else
			return false;
	}

	// GET MONTH NAME
	/**
	 * Gets the month name.
	 * 
	 * @return the month name
	 */
	public String getMonthName() {

		switch (month) {
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";
		default:
			return "Wrong month";

		}
	}

	// STEP FORWARD
	/**
	 * Step forward one day.
	 */
	public void stepForwardOneDay() {
		if (day == numberOfDaysInMonth()) {
			day = 1;

			if (month == 12) {
				month = 1;
				year++;
			} else
				month++;
		} else
			day++;

	}

	// STEP FORWARD AS MANY AS YOU WANT
	/**
	 * Step forward.
	 * 
	 * @param d
	 *            the d
	 */
	public void stepForward(int d) {
		day += d;
		if (day > numberOfDaysInMonth()) {
			day -= numberOfDaysInMonth();

			if (month == 12) {
				month = 1;
				year++;
			} else
				month++;
		}

	}
	// STEP FORWARD AS MANY AS YOU WANT
		/**
	 * Step forward.
	 *
	 * @param mon the mon
	 * @return the my date
	 */
	public MyDate stepForwardMonths(int mon) {
		month += mon;
		if (month > 12) {
			month -= 12;
			year++;
		}
		return copy();
	}

	// FORWARD ONE YEAR
	/**
	 * Year forward.
	 */
	public void yearForward() {
		year++;
	}

	/**
	 * Convert to month number.
	 * 
	 * @param m
	 *            the m
	 * @return the int
	 */
	public static int convertToMonthNumber(String m) {
		String monthName = m;
		switch (monthName) {
		case "January":
			return 1;
		case "February":
			return 2;
		case "March":
			return 3;
		case "April":
			return 4;
		case "May":
			return 5;
		case "June":
			return 6;
		case "Juny":
			return 7;
		case "August":
			return 8;
		case "September":
			return 9;
		case "October":
			return 10;
		case "November":
			return 11;
		case "December":
			return 12;
		default:
			return 0;
		}
	}

	// OVERLOADING
	/**
	 * Sets the.
	 * 
	 * @param d
	 *            the d
	 * @param m
	 *            the m
	 * @param y
	 *            the y
	 */
	public void set(int d, String m, int y) {
		day = d;
		month = convertToMonthNumber(m);
		year = y;
	}

	// EQUALS
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof MyDate))
			return false;
		MyDate other = (MyDate) obj;

		return day == other.day && month == other.month && year == other.year;
	}

	// COPY METHOD
	/**
	 * Copy.
	 * 
	 * @return the my date
	 */
	public MyDate copy() {
		MyDate other = new MyDate(day, month, year);
		return other;
	}

	// NO-ARG CONSTRUCTOR
	/**
	 * Instantiates a new my date.
	 */
	public MyDate() {
		Calendar now = GregorianCalendar.getInstance();
		day = now.get(Calendar.DAY_OF_MONTH);
		month = (now.get(Calendar.MONTH) + 1);
		year = now.get(Calendar.YEAR);
	}

	// CHECK IF THE DATE IS BEFORE ANOTHER
	/**
	 * Checks if is before.
	 * 
	 * @param other
	 *            the other
	 * @return true, if is before
	 */
	public boolean isBefore(MyDate other) {
		if (other.getYear() > this.getYear())
			return true;
		else {
			if (other.getYear() == this.getYear()) {
				if (other.getMonth() > this.getMonth())
					return true;
				else if (other.getMonth() < this.getMonth())
					return false;
				else if (other.getMonth() == this.getMonth()) {
					if (other.getDay() > this.getDay())
						return true;
					else
						return false;
				}
			} else
				return false;
		}
		return true;
	}

	// CHECK HOW MANY YEARS ARE BETWEEN
	/**
	 * Years between.
	 * 
	 * @param other
	 *            the other
	 * @return the int
	 */
	public int yearsBetween(MyDate other) {
		int yearsBetween = 0;
		if (this.isBefore(other)) {
			yearsBetween = other.year - this.year;
			if (other.month < this.month
					|| (other.month == this.month && other.day < this.day))
				yearsBetween--;
		} else {
			yearsBetween = this.year - other.year;
			if (this.month < other.month
					|| (this.month == other.month && this.day < other.day))
				yearsBetween--;
		}
		return yearsBetween;

	}

	// CHECK HOW MANY DAYS ARE BETWEEN
	/**
	 * Days between.
	 * 
	 * @param other
	 *            the other
	 * @return the int
	 */
	public int daysBetween(MyDate other) {
		int daysBetween = 0;
		if (this.isBefore(other)) {
			MyDate counterDate = this.copy();
			while (counterDate.isBefore(other)) {
				daysBetween++;
				counterDate.stepForwardOneDay();
			}
		} else {
			MyDate counterDate = other.copy();
			while (counterDate.isBefore(this)) {
				daysBetween++;
				counterDate.stepForwardOneDay();
			}
		}
		return daysBetween;
	}

	// GIVE MY DATE CURRENT DATE
	/**
	 * Now.
	 * 
	 * @return the my date
	 */
	public static MyDate now() {
		Calendar now = GregorianCalendar.getInstance();
		int day = now.get(Calendar.DAY_OF_MONTH);
		int month = now.get(Calendar.MONTH) + 1;
		int year = now.get(Calendar.YEAR);

		return new MyDate(day, month, year);
	}

	/**
	 * Calculate years.
	 * 
	 * @return the int
	 */
	public int calculateYears() {
		Calendar now = GregorianCalendar.getInstance();
		int nowDay = now.get(Calendar.DAY_OF_MONTH);
		int nowMonth = (now.get(Calendar.MONTH) + 1);
		int nowYear = now.get(Calendar.YEAR);

		int years = nowYear - year;

		if (nowMonth >= month) {
			if (nowDay >= day)
				return years;
			else
				return (years - 1);
		} else
			return (years - 1);
	}

	/**
	 * Method which will take String in format DD.MM.YYYY and convert them to
	 * numbers. Then it will create a new MyDate object with these numbers.
	 * 
	 * @param date
	 *            String date in format DD.MM.YYYY
	 * @return new MyDate(d, m, y)
	 */

	public MyDate fromString(String date) {
		String day = "";
		String month = "";
		String year = "";

		if (date.charAt(8) != 0)
			day += date.charAt(0);

		day += date.charAt(9);

		if (date.charAt(5) != 0)
			month += date.charAt(6);

		// month += date.charAt(4);

		year += date.charAt(0) + "" + date.charAt(1) + "" + date.charAt(2) + ""
				+ date.charAt(3);

		this.day = Integer.parseInt(day);
		this.month = Integer.parseInt(month);
		this.year = Integer.parseInt(year);

		return new MyDate(this.day, this.month, this.year);

	}

	/**
	 * Method accepts two arguments. MyDate reservedFrom and MyDate reservedTo.
	 * It will take copies of these two objects. While reservedFrom is not equal
	 * to reservedTo, it will compare reservedFrom date to this.date. If it is
	 * equal it will return false. That means room is not available. If it is
	 * not equal, reservedFrom will go one day forward.
	 * 
	 * @param reservedFrom
	 *            reserved from date, type of MyDate
	 * @param reservedTo
	 *            reserved to date, type of MyDate
	 * @return true - if the room is available, or false if it is not
	 */

	public boolean checkAvailability(MyDate reservedFrom, MyDate reservedTo) {
		MyDate copyFrom = reservedFrom.copy();
		MyDate copyTo = reservedTo.copy();
		copyTo.stepForwardOneDay();

		while (!(copyFrom.equals(copyTo))) {
			if (this.day == copyFrom.day && this.month == copyFrom.month
					&& this.year == copyFrom.year) {
				return false;
			} else {
				copyFrom.stepForwardOneDay();
			}

		}
		return true;
	}

}
