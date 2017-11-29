
/**
 *  The withdrawals only class
 *  It inherits from TransactionFilter 
 *  and represents a filter to be used to filter a list of transactions
 *
 *  This class filters the withdrawal transactions only.
 *  
 */
public class WithdrawalsOnly implements TransactionFilter {

	@Override
	public boolean isValid(Transaction transaction) {
		return transaction.isWithdraw();
	}

}
