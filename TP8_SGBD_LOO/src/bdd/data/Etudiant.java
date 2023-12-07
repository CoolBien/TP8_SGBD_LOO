package bdd.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

	@ManyToOne
	private Bourse bourse1;

	@ManyToOne
	private Bourse bourse2;

	@ManyToOne
	private Evaluation evaluation1;

	@ManyToOne
	private Evaluation evaluation2;

	@ManyToMany
	private final List<Enseignement> planEnseignement = new ArrayList<>();

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

	/**
	 * @return the bourse1
	 */
	public Bourse getBourse1() {
		return bourse1;
	}

	/**
	 * @param bourse1 : the bourse1 to set
	 */
	public void setBourse1(final Bourse bourse1) {
		this.bourse1 = bourse1;
	}

	/**
	 * @return the bourse2
	 */
	public Bourse getBourse2() {
		return bourse2;
	}

	/**
	 * @param bourse2 : the bourse2 to set
	 */
	public void setBourse2(final Bourse bourse2) {
		this.bourse2 = bourse2;
	}

	/**
	 * @return le plan d'enseignement
	 */
	public List<Enseignement> getPlanEnseignement() {
		return planEnseignement;
	}

	public Evaluation getEvaluation1() {
		return evaluation1;
	}

	public void setEvaluation1(Evaluation evaluation1) {
		this.evaluation1 = evaluation1;
	}

	public Evaluation getEvaluation2() {
		return evaluation2;
	}

	public void setEvaluation2(Evaluation evaluation2) {
		this.evaluation2 = evaluation2;
	}
	
}
