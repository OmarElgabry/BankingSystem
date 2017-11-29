
/**
 *  The TransactionFilter interface
 *  
 *  This is an interface for all types of filters. 
 *  All filters implementing this interface have to override 
 *  and provide a proper implementation for the methods.
 *  
 *  The reason for creating an interface where different filters can inherit and implements is,
 *  separates what varies from what stays the same, 
 *  and being able to pass different filters to methods without having to know which type of filter is this.
 *  
 *  This will allow to add, update, or remove filters without need to change any dependent code.
 *  @see Account#printHistory()
 *  @see Account#printHistory(TransactionFilter)
 */
public interface TransactionFilter {
	
	/**
	 *  Checks if the passed transaction matches 
	 * 
	 * @param transaction 	The transaction to be checked
	 * @returns boolean		If transaction matches or not
	 */
	public boolean isValid(Transaction transaction);
}
