/** 
 * (C) Copyright 2018 - https://github.com/ksvraja
 *
 * Licensed under the MIT license;
 * 
 * Refer to the LICENSE file in the project root folder 
 *
 */
package com.zitlab.palmyra.api2db.sqlbuilder.condition;

public enum Operator {
	LESS_THAN(" < "), LESS_THAN_OR_EQUAL_TO(" <= "), GREATER_THAN(" > "), GREATER_THAN_OR_EQUAL_TO(" >= "),
	EQUAL_TO(" = "), NOT_EQUAL_TO(" <> "), LIKE(" LIKE "), NOT_LIKE(" NOT LIKE ");

	private final String operator;

	private Operator(String operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return operator;
	}
}
