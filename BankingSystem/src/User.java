
/**
 *  The user class
 *  It represents a single account for a user.
 *  
 *  It can also have a reference to current account object (bidirectional).
 *
 */
public class User {
	private String name;

    /**
     * Initializes the user instance
     */
	public User(String name){
		this.name = name;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
