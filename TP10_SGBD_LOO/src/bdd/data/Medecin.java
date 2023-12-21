package bdd.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medecin")
public class Medecin {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "ssn")
	private int snn;

	@Column(name = "salaire")
	private float salaire;

	public Medecin(final String name, final String firstName, final int snn, final float salaire) {
		this.name = name;
		this.firstName = firstName;
		this.snn = snn;
		this.salaire = salaire;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id : the id to set
	 */
	public void setId(final int id) {
		this.id = id;
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
	 * @return the snn
	 */
	public int getSnn() {
		return snn;
	}

	/**
	 * @param snn : the snn to set
	 */
	public void setSnn(final int snn) {
		this.snn = snn;
	}

	/**
	 * @return the salaire
	 */
	public float getSalaire() {
		return salaire;
	}

	/**
	 * @param salaire : the salaire to set
	 */
	public void setSalaire(final float salaire) {
		this.salaire = salaire;
	}
}
