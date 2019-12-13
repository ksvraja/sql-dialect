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

public class OrderClause extends SqlObject{
	public final boolean ASC = true;
	public final boolean DESC = false;
	String name;
	boolean asc;
	
	public OrderClause (String alias, boolean asc) {
		this.name = alias;
		this.asc = asc;
	}

	@Override
	public void append(StringBuilder sb) {
		sb.append(name);
		sb.append((asc) ? " ASC" : " DESC");
	}
	
	public void append(StringBuilder sb, Dialect dialect) {
		dialect.append(sb, this);
	}
}
