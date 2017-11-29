import java.util.Calendar;
import java.util.Date;

/**
 *  The by date class
 *  It inherits from TransactionFilter 
 *  and represents a filter to be used to filter a list of transactions
 *
 *  This class relies on three properties: day, month, and year.
 *  It can be the case that filtration needs to be on basis of day only, or month only, etc.
 *  But, for simplicity, It's implemented so that it matches between day, month and year.
 *  
 */
public class ByDate implements TransactionFilter {
	private int day; 
	private int month;
	private int year;
	
    /**
     * Initializes the by date instance by passing day, month and year.
     */
	public ByDate(int day, int month, int year){
		this.day 	= day;
		this.month 	= month;
		this.year 	= year;
	}
	
	@Override
	public boolean isValid(Transaction transaction) {
		if(transaction == null)
			return false;
		
		Date date = transaction.getDate();
		Calendar calender = Calendar.getInstance();
		calender.setTime(date);

		if(this.day != calender.get(Calendar.DAY_OF_MONTH))
			return false;
		if(this.month != calender.get(Calendar.MONTH) + 1)
			return false;
		if(this.year != calender.get(Calendar.YEAR))
			return false;
		
		return true;
	}

}
