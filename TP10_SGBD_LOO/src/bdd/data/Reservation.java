package bdd.data;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "startDate")
	private LocalDateTime startDate;

	@Column(name = "endDate")
	private LocalDateTime endDate;

	@Column(name = "priceToPay")
	private float priceToPay;

	@Column(name = "pricePayed")
	private float pricePayed;

	@ManyToOne
	private Medecin medecin;

	@ManyToOne
	private TypeAnalyse typeAnalyse;

	@ManyToOne
	private Utilisateur user;

	public Reservation(final LocalDateTime startDate, final LocalDateTime endDate, final float priceToPay, final float pricePayed, final Medecin medecin, final TypeAnalyse typeAnalyse, final Utilisateur user) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceToPay = priceToPay;
		this.pricePayed = pricePayed;
		this.medecin = medecin;
		this.typeAnalyse = typeAnalyse;
		this.user = user;
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
	 * @return the startDate
	 */
	public LocalDateTime getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate : the startDate to set
	 */
	public void setStartDate(final LocalDateTime startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public LocalDateTime getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate : the endDate to set
	 */
	public void setEndDate(final LocalDateTime endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the priceToPay
	 */
	public float getPriceToPay() {
		return priceToPay;
	}

	/**
	 * @param priceToPay : the priceToPay to set
	 */
	public void setPriceToPay(final float priceToPay) {
		this.priceToPay = priceToPay;
	}

	/**
	 * @return the pricePayed
	 */
	public float getPricePayed() {
		return pricePayed;
	}

	/**
	 * @param pricePayed : the pricePayed to set
	 */
	public void setPricePayed(final float pricePayed) {
		this.pricePayed = pricePayed;
	}

	/**
	 * @return the medecin
	 */
	public Medecin getMedecin() {
		return medecin;
	}

	/**
	 * @param medecin : the medecin to set
	 */
	public void setMedecin(final Medecin medecin) {
		this.medecin = medecin;
	}

	/**
	 * @return the typeAnalyse
	 */
	public TypeAnalyse getTypeAnalyse() {
		return typeAnalyse;
	}

	/**
	 * @param typeAnalyse : the typeAnalyse to set
	 */
	public void setTypeAnalyse(final TypeAnalyse typeAnalyse) {
		this.typeAnalyse = typeAnalyse;
	}

	/**
	 * @return the user
	 */
	public Utilisateur getUser() {
		return user;
	}

	/**
	 * @param user : the user to set
	 */
	public void setUser(final Utilisateur user) {
		this.user = user;
	}
}
