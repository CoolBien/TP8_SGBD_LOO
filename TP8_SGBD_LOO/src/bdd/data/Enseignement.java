package bdd.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enseignement")
public class Enseignement {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "nombreCredit")
	private int nombreCredit;

	@Column(name = "volumeHoraire")
	private int volumeHoraire;

	public Enseignement() {
		this("", 0, 0);
	}

	public Enseignement(final String nom, final int nombreCredit, final int volumeHoraire) {
		this.nom = nom;
		this.nombreCredit = nombreCredit;
		this.volumeHoraire = volumeHoraire;
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
	 * @return the nombreCredit
	 */
	public int getNombreCredit() {
		return nombreCredit;
	}

	/**
	 * @param nombreCredit : the nombreCredit to set
	 */
	public void setNombreCredit(final int nombreCredit) {
		this.nombreCredit = nombreCredit;
	}

	/**
	 * @return the volumeHoraire
	 */
	public int getVolumeHoraire() {
		return volumeHoraire;
	}

	/**
	 * @param volumeHoraire : the volumeHoraire to set
	 */
	public void setVolumeHoraire(final int volumeHoraire) {
		this.volumeHoraire = volumeHoraire;
	}
}
