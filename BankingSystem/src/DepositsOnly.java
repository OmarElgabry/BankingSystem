
/**
 *  The deposits only class
 *  It inherits from TransactionFilter 
 *  and represents a filter to be used to filter a list of transactions
 *
 *  This class filters the deposit transactions only.
 *  
 */
public class DepositsOnly implements TransactionFilter {
	
	@Override
	public boolean isValid(Transaction transaction) {
		return transaction.isDeposit();
	}
}
