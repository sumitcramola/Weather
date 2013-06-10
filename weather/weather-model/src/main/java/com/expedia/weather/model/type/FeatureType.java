package com.expedia.weather.model.type;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * The Enum FeatureType.
 */
@XmlType(name = "FeatureType")
@XmlEnum
public enum FeatureType {
	
	/** The conditions. */
	@XmlEnumValue("conditions")
	CONDITIONS("conditions");
	
	/** The value. */
	private final String value;

	/**
	 * Instantiates a new feature type.
	 *
	 * @param v the v
	 */
	FeatureType(String v) {
		value = v;
	}

	/**
	 * Value.
	 *
	 * @return the string
	 */
	public String value() {
		return value;
	}
	

}
