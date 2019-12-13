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

public abstract class SqlObject {
	
	public void append(StringBuilder sb, Dialect dialect) {
		this.append(sb);
	}
	
	public abstract void append(StringBuilder sb);
}
