package bdd.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "etudiant")
public class Etudiant {

	@Id
	@GeneratedValue
	@Column(name = "numeroEtu")
	private int numeroEtu;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "noteMoyLastSemester")
	private float noteMoyLastSemester;

	public Etudiant() {
		this("", "", 0);
	}

	public Etudiant(final String nom, final String prenom, final int numeroEtu) {
		this(nom, prenom, numeroEtu, 0);
	}

	public Etudiant(final String nom, final String prenom, final int numeroEtu, final float noteMoyLastSemester) {
		this.nom = nom;
		this.prenom = prenom;
		this.numeroEtu = numeroEtu;
		this.noteMoyLastSemester = noteMoyLastSemester;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom : the nom to set
	 */
	public void setNom(final String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom : the prenom to set
	 */
	public void setPrenom(final String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the numeroEtu
	 */
	public int getNumeroEtu() {
		return numeroEtu;
	}

	/**
	 * @param numeroEtu : the numeroEtu to set
	 */
	public void setNumeroEtu(final int numeroEtu) {
		this.numeroEtu = numeroEtu;
	}

	/**
	 * @return the noteMoyLastSemester
	 */
	public float getNoteMoyLastSemester() {
		return noteMoyLastSemester;
	}

	/**
	 * @param noteMoyLastSemester : the noteMoyLastSemester to set
	 */
	public void setNoteMoyLastSemester(final float noteMoyLastSemester) {
		this.noteMoyLastSemester = noteMoyLastSemester;
	}
}
