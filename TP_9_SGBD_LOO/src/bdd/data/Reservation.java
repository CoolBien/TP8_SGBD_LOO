package bdd.data;

import java.util.Date;

public class Reservation {

	private Date dateDebut;
	private Date dateFin;
	private float prixaPayer;
	private float prixDejaPaye;

	public Reservation(final Date dateDebut, final Date dateFin, final float prixaPayer, final float prixDejaPaye) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prixaPayer = prixaPayer;
		this.prixDejaPaye = prixDejaPaye;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public float getPrixaPayer() {
		return prixaPayer;
	}

	public void setPrixaPayer(float prixaPayer) {
		this.prixaPayer = prixaPayer;
	}

	public float getPrixDejaPaye() {
		return prixDejaPaye;
	}

	public void setPrixDejaPaye(float prixDejaPaye) {
		this.prixDejaPaye = prixDejaPaye;
	}

}
