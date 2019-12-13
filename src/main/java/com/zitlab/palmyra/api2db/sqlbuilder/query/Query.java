/** 
 * (C) Copyright 2018 - https://github.com/ksvraja
 *
 * Licensed under the MIT license;
 * 
 * Refer to the LICENSE file in the project root folder 
 *
 */
package com.zitlab.palmyra.api2db.sqlbuilder.query;

import com.zitlab.palmyra.api2db.sqlbuilder.dialect.Dialect;

public abstract class Query {
	protected Table table;
	
	public abstract String getQuery(Dialect dialect);
	
	public Query(String table, String alias) {
		this.table = new Table(table, alias);
	}
	

	public Table getPrimaryTable() {
		return this.table;
	}
	
	protected void appendColumns(StringBuilder sb, Table table) {
		for (String column : table.getColumns()) {
			sb.append(column).append(",");
		}
	}
}
