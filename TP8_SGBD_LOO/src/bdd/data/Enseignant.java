package bdd.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enseignant")
public class Enseignant {

	@Id
	@GeneratedValue	
	@Column(name = "id")
	private int id;
	
	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;
	
	public Enseignant () {
		this("", "");
	}
	
	public Enseignant(final String nom, final String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
