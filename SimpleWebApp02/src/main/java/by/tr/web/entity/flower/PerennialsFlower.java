package by.tr.web.entity.flower;

import by.tr.web.entity.Growing;
import by.tr.web.entity.Visual;

public class PerennialsFlower extends Flower {
	

	public PerennialsFlower(String name, String id, String origin, String soil, Visual visualParameters,
			String multiplying, Growing growingTips, int bloomDuration) {
		super(name, id, origin, soil, visualParameters, multiplying, growingTips);
	}

	public PerennialsFlower() {
		super();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}



}
