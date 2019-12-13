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
	private String name;
	private String alias;
	public final String COLUMN_SEPARATER = "__";
	private ArrayList<String> columns = new ArrayList<String>();
	
	Table(String name, String alias) {
		this.name = name;
		this.alias = alias;
	}

	public void addColumn(String column, String alias) {
		columns.add(this.alias + "." + column + " " + alias);
	}
	
	public void addColumnWithAlias(String column, String attribute) {
		StringBuilder sb = new StringBuilder();
		sb.append(alias).append(".").append(column).append(" ");
		sb.append(alias).append(COLUMN_SEPARATER).append(attribute);
		columns.add(sb.toString());
	}
	
	public void addColumnWithAlias(String column) {
		columns.add(this.alias + "." + column);
	}
	
	public void addColumn(String column) {
		columns.add(column);
	}
	
	public String getAlias() {
		return alias;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<String> getColumns(){
		return columns;
	}
}
