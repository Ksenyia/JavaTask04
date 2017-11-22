package by.tr.web.entity.flower;

import by.tr.web.entity.Growing;
import by.tr.web.entity.Visual;

public class BiennialFlower extends Flower {

	public BiennialFlower(String name, String id, String origin, String soil, Visual visualParameters,
			String multiplying, Growing growingTips) {
		super(name, id, origin, soil, visualParameters, multiplying, growingTips);
	}

	public BiennialFlower() {
		super();
	}

}
