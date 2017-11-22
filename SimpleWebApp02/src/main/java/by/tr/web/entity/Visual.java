package by.tr.web.entity;

public class Visual {
	
	private String stemColor;
	private String leafColor;
	private int plantSize;
	
	
	public Visual(String stemColor, String leafColor, int plantSize) {
		super();
		this.stemColor = stemColor;
		this.leafColor = leafColor;
		this.plantSize = plantSize;
	}

	public Visual() {
		stemColor = "";
		leafColor = "";
		plantSize = 0;
	}

	@Override
	public String toString() {
		return "stemColor = " + stemColor + "\nleafColor = " + leafColor + "\nplantSize = " + plantSize;
	}
	public String getStemColor() {
		return stemColor;
	}
	public void setStemColor(String stemColor) {
		this.stemColor = stemColor;
	}
	public String getLeafColor() {
		return leafColor;
	}
	public void setLeafColor(String leafColor) {
		this.leafColor = leafColor;
	}
	public int getPlantSize() {
		return plantSize;
	}
	public void setPlantSize(int plantSize) {
		this.plantSize = plantSize;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((leafColor == null) ? 0 : leafColor.hashCode());
		result = prime * result + plantSize;
		result = prime * result + ((stemColor == null) ? 0 : stemColor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visual other = (Visual) obj;
		if (leafColor == null) {
			if (other.leafColor != null)
				return false;
		} else if (!leafColor.equals(other.leafColor))
			return false;
		if (plantSize != other.plantSize)
			return false;
		if (stemColor == null) {
			if (other.stemColor != null)
				return false;
		} else if (!stemColor.equals(other.stemColor))
			return false;
		return true;
	}



}
