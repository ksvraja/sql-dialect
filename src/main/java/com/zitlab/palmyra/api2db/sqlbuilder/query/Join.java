/** 
 * (C) Copyright 2018 - https://github.com/ksvraja
 *
 * Licensed under the MIT license;
 * 
 * Refer to the LICENSE file in the project root folder 
 *
 */
package com.zitlab.palmyra.api2db.sqlbuilder.query;

import com.zitlab.palmyra.api2db.sqlbuilder.condition.Condition;
import com.zitlab.palmyra.api2db.sqlbuilder.condition.JoinType;

public class Join {
	Table table;
	JoinType joinType;
	Condition condition;
	
	public Join(Table table, JoinType type, Condition condition) {
		this.table = table;
		this.joinType = type;
		this.condition = condition;
	}
}
