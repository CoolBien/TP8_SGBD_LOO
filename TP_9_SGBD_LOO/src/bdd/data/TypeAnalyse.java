package bdd.data;

import java.util.ArrayList;
import java.util.List;

public class TypeAnalyse {

	private List<String> hemogramme = new ArrayList();
	private String groupeSanguin;
	private float vitesseSedimentation;

	public TypeAnalyse(final List<String> hemogramme, final String groupeSanguin, final float vitesseSedimentation) {
		this.hemogramme = hemogramme;
		this.groupeSanguin = groupeSanguin;
		this.vitesseSedimentation = vitesseSedimentation;
	}

	public List<String> getHemogramme() {
		return hemogramme;
	}

	public void setHemogramme(List<String> hemogramme) {
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
