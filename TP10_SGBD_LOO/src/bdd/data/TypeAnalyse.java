package bdd.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typeAnalyse")
public class TypeAnalyse {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "hemogramme")
	private String hemogramme;

	@Column(name = "groupeSanguin")
	private String groupeSanguin;

	@Column(name = "vitesseSedimentation")
	private float vitesseSedimentation;

	@Column(name = "prix")
	private float prix;

	@Column(name = "duree")
	private int duree;

	public TypeAnalyse() {}

	public TypeAnalyse(final String hemogramme, final String groupeSanguin, final float vitesseSedimentation, final float prix, final int duree) {
		this.hemogramme = hemogramme;
		this.groupeSanguin = groupeSanguin;
		this.vitesseSedimentation = vitesseSedimentation;
		this.prix = prix;
		this.duree = duree;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getHemogramme() {
		return hemogramme;
	}

	public void setHemogramme(final String hemogramme) {
		this.hemogramme = hemogramme;
	}

	public String getGroupeSanguin() {
		return groupeSanguin;
	}

	public void setGroupeSanguin(final String groupeSanguin) {
		this.groupeSanguin = groupeSanguin;
	}

	public float getVitesseSedimentation() {
		return vitesseSedimentation;
	}

	public void setVitesseSedimentation(final float vitesseSedimentation) {
		this.vitesseSedimentation = vitesseSedimentation;
	}

	/**
	 * @return the prix
	 */
	public float getPrix() {
		return prix;
	}

	/**
	 * @param prix : the prix to set
	 */
	public void setPrix(final float prix) {
		this.prix = prix;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(final int duree) {
		this.duree = duree;
	}

	@Override
	public String toString() {
		return prix + " €, hemogramme: " + hemogramme + ", groupeSanguin: " + groupeSanguin + ", vitesseSedimentation: " + vitesseSedimentation + ", duree: " + duree;
	}
}
