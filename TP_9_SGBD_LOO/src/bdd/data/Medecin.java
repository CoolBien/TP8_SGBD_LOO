package bdd.data;

public class Medecin {

	private int idMedecin;
	private String name;
	private String firstName;
	private int ssn;
	private float salary;

	public Medecin(final int idMedecin, final String name, final String firstName, final int ssn, final float salary) {
		this.idMedecin = idMedecin;
		this.name = name;
		this.firstName = firstName;
		this.ssn = ssn;
		this.salary = salary;
	}

	public int getId() {
		return idMedecin;
	}

	public void setId(int idMedecin) {
		this.idMedecin = idMedecin;
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

	/**
	 * @return the salary
	 */
	public float getSalary() {
		return salary;
	}

	/**
	 * @param salary : the salary to set
	 */
	public void setSalary(final float salary) {
		this.salary = salary;
	}
}
