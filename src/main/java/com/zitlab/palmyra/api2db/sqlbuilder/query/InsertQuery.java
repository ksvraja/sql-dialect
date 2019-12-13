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

public class InsertQuery extends Query{

	public InsertQuery(String table, String alias) {
		super(table, alias);
	}
	
	@Override
	public String getQuery(Dialect dialect) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(table.getName());
		sb.append(" (");
		appendColumns(sb, table);
		sb.deleteCharAt(sb.length() - 1);
		sb.append(") VALUES (");
		int length = table.getColumns().size();
		
		for(int i = 0 ; i < length; i++) {
			sb.append("?,");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append(")");
		return sb.toString();
	}

}
