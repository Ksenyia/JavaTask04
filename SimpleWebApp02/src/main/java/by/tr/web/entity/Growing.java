package by.tr.web.entity;

public class Growing {
	
	private int temperature;
	private int watering;
	public Growing(int temperature, int watering) {
		this.temperature = temperature;
		this.watering = watering;
	}
	public Growing() {
		temperature = 0;
		watering = 0;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + temperature;
		result = prime * result + watering;
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
		Growing other = (Growing) obj;
		if (temperature != other.temperature)
			return false;
		if (watering != other.watering)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "temperature = " + temperature + "\nwatering = " + watering;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getWatering() {
		return watering;
	}
	public void setWatering(int watering) {
		this.watering = watering;
	}

}
