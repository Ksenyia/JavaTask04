package by.tr.web.entity.flower;

import by.tr.web.entity.Growing;
import by.tr.web.entity.Visual;

public class Flower {
	
	private String name;
	private String id;
	private String origin;
	private String soil;
	private Visual visualParameters;
	private String multiplying;
	private Growing growingTips;
	public Flower(String name, String id, String origin, String soil, Visual visualParameters, String multiplying,
			Growing growingTips) {
		super();
		this.name = name;
		this.id = id;
		this.origin = origin;
		this.soil = soil;
		this.visualParameters = visualParameters;
		this.multiplying = multiplying;
		this.growingTips = growingTips;
	}
	public Flower() {
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((growingTips == null) ? 0 : growingTips.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((multiplying == null) ? 0 : multiplying.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((soil == null) ? 0 : soil.hashCode());
		result = prime * result + ((visualParameters == null) ? 0 : visualParameters.hashCode());
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
		Flower other = (Flower) obj;
		if (growingTips == null) {
			if (other.growingTips != null)
				return false;
		} else if (!growingTips.equals(other.growingTips))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (multiplying == null) {
			if (other.multiplying != null)
				return false;
		} else if (!multiplying.equals(other.multiplying))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (soil == null) {
			if (other.soil != null)
				return false;
		} else if (!soil.equals(other.soil))
			return false;
		if (visualParameters == null) {
			if (other.visualParameters != null)
				return false;
		} else if (!visualParameters.equals(other.visualParameters))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Flower [name=" + name + ", id=" + id + ", origin=" + origin + ", soil=" + soil + ", visualParameters="
				+ visualParameters + ", multiplying=" + multiplying + ", growingTips=" + growingTips + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getSoil() {
		return soil;
	}
	public void setSoil(String soil) {
		this.soil = soil;
	}
	public Visual getVisualParameters() {
		return visualParameters;
	}
	public void setVisualParameters(Visual visualParameters) {
		this.visualParameters = visualParameters;
	}
	public void setVisualParametersLeafColor(String leafColor) {
		this.visualParameters.setLeafColor(leafColor);
	}
	public void setVisualParametersStemColor(String stemColor) {
		this.visualParameters.setStemColor(stemColor);
	}
	public void setVisualParametersPlantSize(int plantSize) {
		this.visualParameters.setPlantSize(plantSize);
	}
	public String getMultiplying() {
		return multiplying;
	}
	public void setMultiplying(String multiplying) {
		this.multiplying = multiplying;
	}
	public Growing getGrowingTips() {
		return growingTips;
	}
	public void setGrowingTips(Growing growingTips) {
		this.growingTips = growingTips;
	}
	public void setGrowingTipsTemperature(int temperature) {
		this.growingTips.setTemperature(temperature);
	}
	public void setGrowingTipsWatering(int watering) {
		this.growingTips.setWatering(watering);
	}

}
