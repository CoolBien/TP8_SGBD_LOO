package bdd.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bourse")
public class Bourse {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "destination")
	private String destination;

	@Column(name = "nbposte")
	private int nbPoste;

	@Column(name = "responsable")
	private String responsable;

	public Bourse() {
		this("", 0, "");
	}

	public Bourse(final String destination, final int nbposte, final String responsable) {
		this.destination = destination;
		this.responsable = responsable;
		nbPoste = nbposte;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(final String destination) {
		this.destination = destination;
	}

	public int getNbPoste() {
		return nbPoste;
	}

	public void setNbPoste(final int nbposte) {
		nbPoste = nbposte;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(final String responsable) {
		this.responsable = responsable;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

}
