
public class Main {

	public static void main(String[] args) {
		// Create user instances
		User john = new User("John");
		User alex = new User("Alex");
		
		// Create user accounts
		Account johnAccount = new Account(john);
		Account alexAccount = new Account(alex);
		
		// John will deposit 1000 and Alex 2500
		johnAccount.deposite(1000);
		alexAccount.deposite(2500);
		
		// John will withdraw 300
		johnAccount.withdraw(300);
		
		// Alex will transfer 800 to John
		alexAccount.transfer(johnAccount, 800);
		
		// Print transaction history of John
		johnAccount.printHistory();
		
		// Print transaction history of John using filters
		TransactionFilter filter;
		// filter 	= new ByDate(29, 11, 2017);
		// filter 	= new DepositsOnly();
		filter 	= new WithdrawalsOnly();
		
		johnAccount.printHistory(filter);
		
		// Trying to deposit an amount <= 0, 
		// Or withdraw an amount > current balance will throw an exception
		// johnAccount.deposite(-1);
		// johnAccount.withdraw(50000);
	}

}
