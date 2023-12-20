package bdd.data;

public class Utilisateur {

	private int idUtilisateur;
	private String name;
	private String firstName;
	private int ssn;

	public Utilisateur(final int idUtilisateur, final String name, final String firstName, final int ssn) {
		this.idUtilisateur = idUtilisateur;
		this.name = name;
		this.firstName = firstName;
		this.ssn = ssn;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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
