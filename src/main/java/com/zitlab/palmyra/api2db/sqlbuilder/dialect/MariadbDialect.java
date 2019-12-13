/** 
 * (C) Copyright 2018 - https://github.com/ksvraja
 *
 * Licensed under the MIT license;
 * 
 * Refer to the LICENSE file in the project root folder 
 *
 */
package com.zitlab.palmyra.api2db.sqlbuilder.dialect;

import com.zitlab.palmyra.api2db.sqlbuilder.query.LimitClause;

public class MariadbDialect extends Dialect{
	
	public void append(StringBuilder sb, LimitClause lc) {
		sb.append(" LIMIT ").append(lc.getLimit());
		int offset = lc.getOffset();
		if(offset > 0)
			sb.append(" OFFSET ").append(offset);
	}
}
