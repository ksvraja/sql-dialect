/** 
 * (C) Copyright 2018 - https://github.com/ksvraja
 *
 * Licensed under the MIT license;
 * 
 * Refer to the LICENSE file in the project root folder 
 *
 */
package com.zitlab.palmyra.api2db.sqlbuilder.condition;

public class CustomCondition extends Condition{
	private String condition;
	
	public CustomCondition(String condition) {
		this.condition = condition;
	}
	
	public String getCondition() {
		return condition;
	}
	
	@Override
	public String toString() {
		return condition;
	}
	
	@Override
	public void append(StringBuilder sb) {
		if (parenthesis)
			sb.append("(");
		sb.append(condition);
		if (parenthesis)
			sb.append(")");
	}
}
