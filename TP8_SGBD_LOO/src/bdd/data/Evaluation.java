package bdd.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Evaluation")

public class Evaluation {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "note")
	private int note;
	
	@ManyToOne
	private Enseignant enseignant;

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}