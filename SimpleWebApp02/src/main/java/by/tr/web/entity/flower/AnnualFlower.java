package by.tr.web.entity.flower;

import by.tr.web.entity.Growing;
import by.tr.web.entity.Visual;

public class AnnualFlower extends Flower{

	public AnnualFlower(String name, String id, String origin, String soil, Visual visualParameters,
			String multiplying, Growing growingTips) {
		super(name, id, origin, soil, visualParameters, multiplying, growingTips);

	}

	public AnnualFlower() {
		super();
	}

}
