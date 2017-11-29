import java.util.Date;
import java.util.Iterator;
import java.util.Stack;

/**
 *  The account class
 *  It represents a single account for a user.
 *
 */
public class Account {
	private User user;							// owner user of the account
	private double balance;						// balance
	private Stack<Transaction> transactions;	// a list of transactions
	
    /**
     * Initializes the account instance
     */
	public Account(User user){
		this.user = user;
		this.balance = 0;
		this.transactions = new Stack<Transaction>();
	}
	
	/**
	 *  Deposit the given amount
	 * 
	 * @param amount 	The amount of money to be credited to the account.
	 * @throws	IllegalArgumentException 	If amount is less than or equal zero
	 */
	public void deposite(double amount) {
		if(amount <= 0){
			throw new IllegalArgumentException("Amount can't be less than or equal zero.");
		}
		
		balance += amount;		
		logTransaction(true, amount);
	}
	
	/**
	 *  Withdraw the given amount
	 * 
	 * @param amount 	The amount of money to be debited from the account.
	 * @throws	IllegalArgumentException 	If no sufficient balance or amount is less than or equal zero
	 */
	public void withdraw(double amount){
		if(balance < amount || amount <= 0){
			throw new IllegalArgumentException("No sufficient balance or amount can't be less than or equal zero.");
		}
		
		balance -= amount;
		logTransaction(false, amount);
	}
	
	/**
	 *  Transfers amount to another account
	 * 
	 * @param receiver 	The account of the receiver
	 * @param amount 	The amount to be transfered
	 */
	public void transfer(Account receiver, double amount){
		withdraw(amount);
		receiver.deposite(amount);
	}
	
	/**
	 *  Prints the history of transactions
	 */
	public void printHistory(){		
		System.out.println(toString());
		
		Iterator<Transaction> it = transactions.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
	}
	
	/**
	 *  Prints the history of transactions using a filter
	 *  
	 *  @param filter	The filter to match against.
	 */
	public void printHistory(TransactionFilter filter){		
		System.out.println(toString());
		
		Iterator<Transaction> it = transactions.iterator();
		while(it.hasNext()) {
			Transaction current = it.next();
			if(filter.isValid(current))
				System.out.println(current.toString());
		}
	}
	
	/**
	 *  A helper method to log a transaction
	 *  
	 *  @param isDeposite 	Indicates whether the transaction is deposit or withdraw
	 *  @param amount		The amount credited or debited
	 */
	private void logTransaction(boolean isDeposite, double amount){
		transactions.push(new Transaction(new Date(), isDeposite, amount, balance));
	}

	@Override
	public String toString() {
		return "----- Account: " + user.getName() + " - " + "Current balance: " + balance + " -----\n";
	}

}
