/** 
 * (C) Copyright 2018 - https://github.com/ksvraja
 *
 * Licensed under the MIT license;
 * 
 * Refer to the LICENSE file in the project root folder 
 *
 */
package com.zitlab.palmyra.api2db.sqlbuilder.query;

import java.util.ArrayList;

public class Table {
	public static final String TABLE_ALIAS = "$alias";
	private String name;
	private String tableAlias;
	public final String COLUMN_SEPARATER = "__";
	private ArrayList<String> columns = new ArrayList<String>();
	
	Table(String name, String alias) {
		this.name = name;
		this.tableAlias = alias;
	}

	public void addColumn(String column, String alias) {
		columns.add(this.tableAlias + "." + column + " " + alias);
	}
		
	public void addFunctionalColumn(String column, String alias, boolean root) {
		StringBuilder sb = new StringBuilder();
		sb.append(column.replace(TABLE_ALIAS, tableAlias)).append(" ");
		if(root)
			sb.append(alias);
		else
			sb.append(tableAlias).append(COLUMN_SEPARATER).append(alias);
		columns.add(sb.toString());
	}
	
	public void addColumnWithAlias(String column, String alias, boolean root) {
		StringBuilder sb = new StringBuilder();
		sb.append(tableAlias).append(".").append(column).append(" ");
		if (root)
			sb.append(alias);
		else
			sb.append(tableAlias).append(COLUMN_SEPARATER).append(alias);
		columns.add(sb.toString());
	}
		
	public void addColumn(String column) {
		columns.add(column);
	}
	
	public String getAlias() {
		return tableAlias;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<String> getColumns(){
		return columns;
	}
}
