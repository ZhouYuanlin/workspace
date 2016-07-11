package printCalendar;


public class printMonth {
	public static String printMonthTile(int year,int month){
		String monthString = " ";
		switch (month) {
		case 1:monthString = "January";break;
		case 2:monthString = "February";break;
		case 3:monthString = "March";break;
		case 4:monthString = "April";break;
		case 5:monthString = "May";break;
		case 6:monthString = "Jane";break;
		case 7:monthString = "July";break;
		case 8:monthString = "August";break;
		case 9:monthString = "September";break;
		case 10:monthString = "October";break;
		case 11:monthString = "November";break;
		case 12:monthString = "December";break;
		default:break;
		}
		String monthTile =  year + "  " + monthString;
		return monthTile;
	}
	public static void printMonthBody(int year,int month){
		
	}
	
	public static boolean isLeapYear(int year){
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		}
		else return false;
	}
	
	public static int totalDaysOfMonth(int year,int month) {
		int totalDaysOfMonth = 0;
		switch (month) {
		case 1:totalDaysOfMonth = 31;break;
		case 2:if (isLeapYear(year)) {
			totalDaysOfMonth = 29;
		}else totalDaysOfMonth = 28;break;
		case 3:totalDaysOfMonth = 31;break;
		case 4:totalDaysOfMonth = 30;break;
		case 5:totalDaysOfMonth = 31;break;
		case 6:totalDaysOfMonth = 30;break;
		case 7:totalDaysOfMonth = 31;break;
		case 8:totalDaysOfMonth = 31;break;
		case 9:totalDaysOfMonth = 30;break;
		case 10:totalDaysOfMonth = 31;break;
		case 11:totalDaysOfMonth = 30;break;
		case 12:totalDaysOfMonth = 31;break;
		default:break;
		}
		return totalDaysOfMonth;
		
	}
	
	public static 
	
}
