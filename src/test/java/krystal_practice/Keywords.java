package krystal_practice;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Keywords {

	public static void wait(int second) throws InterruptedException {
		Thread.sleep(second * 1000);
	}

	public static String getTimeStamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime() + "";
	}

	/**
	 * Converts date string from "MM/dd/yyyy" format to "yyyy-mm-dd" format
	 * 
	 * @param inputDateString
	 * @return formattedDateString
	 */
	public static String formatInputDate(String inputDateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate date = LocalDate.parse(inputDateString, formatter);
		return date.toString();
	}

	public static void waitWithOutTry(int i) {
		// TODO Auto-generated method stub
		
	}

}
