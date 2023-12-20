package bdd.data;

public class TypeAnalyse {

	private int idTypeAnalyse;
	private String hemogramme;
	private String groupeSanguin;
	private float vitesseSedimentation;

	public TypeAnalyse(final int idTypeAnalyse, final String hemogramme, final String groupeSanguin, final float vitesseSedimentation) {
		this.idTypeAnalyse = idTypeAnalyse;
		this.hemogramme = hemogramme;
		this.groupeSanguin = groupeSanguin;
		this.vitesseSedimentation = vitesseSedimentation;
	}

	public int getIdTypeAnalyse() {
		return idTypeAnalyse;
	}

	public void setIdTypeAnalyse(int idTypeAnalyse) {
		this.idTypeAnalyse = idTypeAnalyse;
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