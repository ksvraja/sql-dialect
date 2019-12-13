/** 
 * (C) Copyright 2018 - https://github.com/ksvraja
 *
 * Licensed under the MIT license;
 * 
 * Refer to the LICENSE file in the project root folder 
 *
 */
package com.zitlab.palmyra.api2db.sqlbuilder.condition;

import com.zitlab.palmyra.api2db.sqlbuilder.query.Table;

public class BetweenCondition extends Condition{
	private String field;
	private boolean _negate = false;

	public BetweenCondition(String field) {
		this.field = field;
	}
	
	public BetweenCondition(Table table, String field) {
		this.field = getColumnAlias(table, field);
	}
	
	@Override
	public void append(StringBuilder sb) {
		 sb.append(field)
	      .append(_negate ? " NOT BETWEEN " : " BETWEEN ")
	      .append("? AND ?");
	}	
}
