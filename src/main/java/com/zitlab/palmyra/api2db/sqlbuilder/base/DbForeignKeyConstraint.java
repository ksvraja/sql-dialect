/** 
 * (C) Copyright 2018 - https://github.com/ksvraja
 *
 * Licensed under the MIT license;
 * 
 * Refer to the LICENSE file in the project root folder 
 */

package com.zitlab.palmyra.api2db.sqlbuilder.base;

/**
 * @author ksvraja
 *
 */
public class DbForeignKeyConstraint {
	private String name;
	private DbTable targetTable;
	private DbColumn targetColumn;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DbTable getTargetTable() {
		return targetTable;
	}
	public void setTargetTable(DbTable targetTable) {
		this.targetTable = targetTable;
	}
	public DbColumn getTargetColumn() {
		return targetColumn;
	}
	public void setTargetColumn(DbColumn targetColumn) {
		this.targetColumn = targetColumn;
	}
	
	
}
