/** 
 * (C) Copyright 2018 - https://github.com/ksvraja
 *
 * Licensed under the MIT license;
 * 
 * Refer to the LICENSE file in the project root folder 
 * 
 */
package com.zitlab.palmyra.api2db.sqlbuilder.base;

/**
 * @author ksvraja
 *
 */
public class DbColumn {
	private String name;
	private int dataType;
	private String defaultValue;
	private Integer length;
	private boolean mandatory;
	private boolean unsigned = false;
	private DbForeignKeyConstraint foreignKey;
	
	public DbForeignKeyConstraint getForeignKey() {
		return foreignKey;
	}
	public void setForeignKey(DbForeignKeyConstraint foreignKey) {
		this.foreignKey = foreignKey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDataType() {
		return dataType;
	}
	public void setDataType(int dataType) {
		this.dataType = dataType;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public boolean isMandatory() {
		return mandatory;
	}
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}
	public boolean isUnsigned() {
		return unsigned;
	}
	public void setUnsigned(boolean unsigned) {
		this.unsigned = unsigned;
	}
}
