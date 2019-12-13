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

public abstract class Condition extends NestableObject{

	protected static final String getColumnAlias(Table table, String column) {
		return table.getAlias() + "." + column;
	}
}
