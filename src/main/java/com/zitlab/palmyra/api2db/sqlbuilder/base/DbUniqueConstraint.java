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

public class DbUniqueConstraint {
	private String name;
	private HashMap<String, DbColumn> columns = new HashMap<String, DbColumn>(8);
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, DbColumn> getColumns() {
		return columns;
	}
	public void setColumns(HashMap<String, DbColumn> columns) {
		this.columns = columns;
	}
	
}
