import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  The transaction class
 *  It represents a transaction with attributes (date, deposit/withdraw, amount, balance)
 *  
 *  A transaction object is immutable. It can't be changed once it's attributes are assigned.
 *  The reason is, changing the transaction can lead to unexpected behavior or invalid state.
 */
public final class Transaction {
	private final Date date;				// date of transaction
	private final boolean isDeposit;		// whether operation was deposit (true) or withdraw (false)
	private final double amount;			// The amount credited or debited
	private final double balance;			// The current balance
	
	public Transaction(Date date, boolean isDeposit, double amount, double balance){
		this.date 		= new Date(date.getTime());		// copy instead of reference
		this.isDeposit  = isDeposit;
		this.amount     = amount;
		this.balance 	= balance;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the isDeposite
	 */
	public boolean isDeposit() {
		return isDeposit;
	}
	
	/**
	 * @return the !isDeposite
	 */
	public boolean isWithdraw() {
		return !isDeposit;
	}

	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return " Date: " + dateFormat.format(date) + "\n" +
				" Amount of " + amount + " has been " + 
				((isDeposit == true)? "credited": "debited") + "\n" +
			   " Current balance: " + balance + "\n";
	}
}
