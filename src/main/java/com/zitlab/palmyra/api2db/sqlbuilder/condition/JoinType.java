/** 
 * (C) Copyright 2018 - https://github.com/ksvraja
 *
 * Licensed under the MIT license;
 * 
 * Refer to the LICENSE file in the project root folder 
 *
 */
package com.zitlab.palmyra.api2db.sqlbuilder.condition;

public enum JoinType {

	OUTER_JOIN("OUTER JOIN"), LEFT_OUTER_JOIN("LEFT OUTER JOIN"), RIGHT_OUTER_JOIN("RIGHT OUTER JOIN"),
	INNER_JOIN("INNER JOIN");

	private final String type;

	private JoinType(String type) {
		this.type = type;
	}

	public String toString() {
		return this.type;
	}
}
