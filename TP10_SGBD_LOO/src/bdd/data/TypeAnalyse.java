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

	public TypeAnalyse(final String hemogramme, final String groupeSanguin, final float vitesseSedimentation) {
		this.hemogramme = hemogramme;
		this.groupeSanguin = groupeSanguin;
		this.vitesseSedimentation = vitesseSedimentation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHemogramme() {
		return hemogramme;
	}

	public void setHemogramme(String hemogramme) {
		this.hemogramme = hemogramme;
	}

	public String getGroupeSanguin() {
		return groupeSanguin;
	}

	public void setGroupeSanguin(String groupeSanguin) {
		this.groupeSanguin = groupeSanguin;
	}

	public float getVitesseSedimentation() {
		return vitesseSedimentation;
	}

	public void setVitesseSedimentation(float vitesseSedimentation) {
		this.vitesseSedimentation = vitesseSedimentation;
	}

}
