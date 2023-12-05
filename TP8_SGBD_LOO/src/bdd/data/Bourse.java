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
	private int nbposte;

	@Column(name = "responsable")
	private String responsable;

	public Bourse() {
		this("", 0, "");
	}

	public Bourse(final String destination, final int nbposte, final String responsable) {
		this.destination = destination;
		this.responsable = responsable;
		this.nbposte = nbposte;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getNbposte() {
		return nbposte;
	}

	public void setNbposte(int nbposte) {
		this.nbposte = nbposte;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
