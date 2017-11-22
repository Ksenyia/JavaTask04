package by.tr.web.entity;

public class TagName {
	public enum FlowerTagName {
		PERENNIALS_FLOWER, FLOWERS, ANNUAL_FLOWER, BIENNIAL_FLOWER,
		VISUAL_PARAMETERS, GROWING_TIPS, 
		NAME, ORIGIN,SOIL, TEMPERATURE, WATERING,
		STEM_COLOR, LEAF_COLOR, PLANT_SIZE;
		

		public static FlowerTagName getElementTagName(String element) {
			switch (element) {
			case "flowers":
				return FLOWERS;
			case "perennials-flower":
				return PERENNIALS_FLOWER;
			case "biennial-flower":
				return BIENNIAL_FLOWER;
			case "annual-flower":
				return ANNUAL_FLOWER;
			case "visual-parameters":
				return VISUAL_PARAMETERS;
			case "growing-tips":
				return GROWING_TIPS;
			case "name":
				return NAME;
			case "origin":
				return ORIGIN;
			case "soil":
				return SOIL;
			case "watering":
				return WATERING;
			case "temperature":
				return TEMPERATURE;
			case "stem-color":
				return STEM_COLOR;
			case "leaf-color":
				return LEAF_COLOR;
			case "plant-size":
				return PLANT_SIZE;
			default:
				throw new EnumConstantNotPresentException(FlowerTagName.class, element);
			}
		}
	}

}
