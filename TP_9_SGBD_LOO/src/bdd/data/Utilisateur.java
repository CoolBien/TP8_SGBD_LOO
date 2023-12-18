package bdd.data;

public class Utilisateur {

	private String name;
	private String firstName;
	private int ssn;

	public Utilisateur(final String name, final String firstName, final int ssn) {
		this.name = name;
		this.firstName = firstName;
		this.ssn = ssn;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name : the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName : the firstName to set
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the social security number
	 */
	public int getSsn() {
		return ssn;
	}

	/**
	 * @param ssn : the social security number to set
	 */
	public void setSsn(final int ssn) {
		this.ssn = ssn;
	}

}
