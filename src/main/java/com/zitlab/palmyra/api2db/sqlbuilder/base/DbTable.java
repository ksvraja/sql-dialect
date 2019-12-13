/** 
 * (C) Copyright 2018 - https://github.com/ksvraja
 *
 * Licensed under the MIT license;
 * 
 * Refer to the LICENSE file in the project root folder 
 *
 */
package com.zitlab.palmyra.api2db.sqlbuilder.base;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class DbTable {
	private String table;

	private HashMap<String, DbColumn> columns = new HashMap<String, DbColumn>();
	private HashMap<String, DbUniqueConstraint> uniqueKeys = new LinkedHashMap<String, DbUniqueConstraint>(8);

	public DbTable() {
	}

	public DbTable(String table) {
		this.table = table;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public HashMap<String, DbColumn> getColumns() {
		return columns;
	}

	public void setColumns(HashMap<String, DbColumn> columns) {
		this.columns = columns;
	}

	public HashMap<String, DbUniqueConstraint> getUniqueKeys() {
		return uniqueKeys;
	}

	public void setUniqueKeys(HashMap<String, DbUniqueConstraint> uniqueKeys) {
		this.uniqueKeys = uniqueKeys;
	}

}
